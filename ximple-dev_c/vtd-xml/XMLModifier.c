/* 
 * Copyright (C) 2002-2007 XimpleWare, info@ximpleware.com
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */ 
#include "XMLModifier.h"
//#include "elementFragmentNs.h"

static void check(XMLModifier *xm);
static void sort(XMLModifier *xm);
static void insertBytesAt(XMLModifier *xm, int offset, Long l);
static void insertBytesAt2(XMLModifier *xm, int offset, Long lenPlusPointer);
static void insertBytesAt3(XMLModifier *xm, int offset, ElementFragmentNs* ef);
//static void removeContent(XMLModifier *xm, int offset, int len);
static Long getBytes_UTF8(UCSChar *s);
static Long getBytes_UTF16LE(UCSChar *s);
static Long getBytes_UTF16BE(UCSChar *s);
static Long getBytes_ISO_8859_1(UCSChar *s);
static Long getBytes_ASCII(UCSChar *s);
// Fwrite will make sure the entire segment of bytes gets written into the stream, 
// otherwise it will return false


static UByte *doubleCapacity(UByte *b, size_t cap){
	b = realloc(b,cap);
	if (b == NULL){
		throwException2(out_of_mem,"Byte allocation failed in doubleCapacity");
	}
	return b;
}
/*convert UCSChar into bytes corresponding to UTF-8 encoding */
static Long getBytes_UTF8(UCSChar *s){
	/* < 0x7f  1 byte*/
	/* < 0x7ff  2 bytes */
	/* < 0xffff  3 bytes */
	/* < 0x 10ffff  4 bytes*/
	size_t len = wcslen(s),i=0,k=0,capacity = max(len,8);/*minimum size is 8 */
	UByte *ba = malloc(sizeof(UByte)*capacity); 
	if (ba == NULL)
		throwException2(out_of_mem,"Byte allocation failed in getBytes_UTF_8");
	for (i=0;i<len;i++){
		if (s[i]<= 0x7f){
			if (capacity -k<1){
				capacity = capacity<<1;
				ba = doubleCapacity(ba,capacity);
			}
			ba[k]=(UByte)s[i];
			k++;
		}else if (s[i] <=0x7ff){
			if (capacity -k<2){
				capacity = capacity<<1;
				ba = doubleCapacity(ba,capacity);
			}
			ba[k]= ((s[i] & 0x7c0) >> 6) | 0xc0;
			ba[k+1] = (s[i] & 0x3f) | 0x80;
			k += 2;
		}else if (s[i] <=0xffff){
			if (capacity -k<3){
				capacity = capacity<<1;
				ba = doubleCapacity(ba,capacity);
			}
			ba[k]= ((s[i] & 0xf000) >> 12) | 0xe0;
			ba[k+1] = ((s[i] & 0xfc) >> 6) | 0x80;
			ba[k+2] = (s[i] & 0x3f) | 0x80;
			k += 3;
		}else if (s[i] <=0x10ffff){
			if (capacity -k<4){
				capacity = capacity<<1;
				ba = doubleCapacity(ba,capacity);
			}
			ba[k]= ((s[i] & 0x1c0000) >> 18) | 0xf0;
			ba[k+1] = ((s[i] & 0x3f0) >> 12) | 0x80;
			ba[k+2] = ((s[i] & 0xfc) >> 6) | 0x80;
			ba[k+3] = (s[i] & 0x3f) | 0x80;
			k += 4;
		}else
			throwException2(modify_exception, "Invalid XML char for getBytes_UTF_8");
	}
	return ((Long)k<<32)|(Long)ba;
}

/*convert UCSChar into bytes corresponding to UTF-16LE encoding */
static Long getBytes_UTF16LE(UCSChar *s){
	size_t len = wcslen(s),i=0,k=0,capacity = max(len,8)<<1;/*minimum size is 16 */
	int tmp,w1,w2;
	UByte *ba = malloc(sizeof(UByte)*(capacity<<1)); 
	if (ba == NULL)
		throwException2(out_of_mem,"Byte allocation failed in getBytes_UTF_16LE");

	for (i=0;i<len;i++){
		if (s[i]<0x10000){
			ba[k]= s[i] & 0x00ff;
			ba[k+1]= (s[i] & 0xff00)>>8;
			k=k+2;
		} else if (s[i]<=0x10ffff){
			if (capacity -k<4){
				capacity = capacity<<1;
				ba = doubleCapacity(ba,capacity);
			}
			tmp = s[i]-0x10000;
			w1 = 0xd800 | (tmp & 0xffc00);
			w2 = 0xdc00 | (tmp & 0x3ff);
			ba[k] = (w1 & 0xff);
			ba[k+1] = (w1 & 0xff00) >> 8;
			ba[k+2] =(w2 & 0xff);
			ba[k+3] = (w2 & 0xff00) >> 8;

		}else 
			throwException2(modify_exception, "Invalid XML char for getBytes_UTF_16LE");
	}
	return ((Long)k<<32)|(Long)ba;
}

/*convert UCSChar into bytes corresponding to UTF-16BE encoding */
static Long getBytes_UTF16BE(UCSChar *s){
	size_t len = wcslen(s),i=0,k=0,capacity = max(len,8)<<1;/*minimum size is 16 */
	int tmp,w1,w2;
	UByte *ba = malloc(sizeof(UByte)*(capacity<<1)); 
	if (ba == NULL)
		throwException2(out_of_mem,"Byte allocation failed in getBytes_UTF_16BE");
	for (i=0;i<len;i++){
		if (s[i]<0x10000){
			ba[k]= (s[i] & 0xff00)>>8;
			ba[k+1]= s[i] & 0x00ff;
			k=k+2;
		} else if (s[i]<=0x10ffff){
			if (capacity -k<4){
				capacity = capacity<<1;
				ba = doubleCapacity(ba,capacity);
			}
			tmp = s[i]-0x10000;
			w1 = 0xd800 | (tmp & 0xffc00);
			w2 = 0xdc00 | (tmp & 0x3ff);
			ba[k] = (w1 & 0xff00) >> 8;
			ba[k+1] = (w1 & 0xff);
			ba[k+2] =(w2 & 0xff00) >> 8;
			ba[k+3] = (w2 & 0xff);
			k+=4;
		}else 
			throwException2(modify_exception, "Invalid XML char for getBytes_UTF_16BE");
	}
	return ((Long)k<<32)|(Long)ba;
}

/*convert UCSChar into bytes corresponding to iso-8859-1 encoding */
static Long getBytes_ISO_8859_1(UCSChar *s){
	size_t len = wcslen(s),i=0;
	UByte *ba = malloc(sizeof(UByte)*(len));
	if (ba == NULL)
		throwException2(out_of_mem,"byte allocation failed in getBytes_ISO_8859_1");
	for (i=0;i<len;i++){
		if (s[i]>0xff)
			throwException2(modify_exception,"Invalid char for ISO_8859_1");
		ba[i]=(UByte)s[i];
	}
	return ((Long)len<<32)|(Long)ba;
}

/*convert UCSChar into bytes corresponding to ascii encoding */
static Long getBytes_ASCII(UCSChar *s){
	size_t len = wcslen(s),i=0;
	UByte *ba = malloc(sizeof(UByte)*(len));
	if (ba == NULL)
		throwException2(out_of_mem,"byte allocation failed in getBytes_ASCII");
	for (i=0;i<len;i++){
		if (s[i]>127)
			throwException2(modify_exception,"Invalid char for ASCII");
		ba[i]=(UByte)s[i];
	}
	return ((Long)len<<32)|(Long)ba;
}

/* create XMLModifier */ 

XMLModifier *createXMLModifier(){
	XMLModifier *xm = NULL;
	xm = (XMLModifier *)malloc(sizeof(XMLModifier));
	if (xm == NULL){
		throwException2(out_of_mem, "xm failed");
		return NULL;
	}
	xm->deleteHash = NULL;
	xm->insertHash = NULL;
	xm->flb = NULL;
	xm->fob = NULL;
	xm->md = NULL;
	return xm;
}

XMLModifier *createXMLModifier2(VTDNav *vn){
	XMLModifier *xm = NULL;
	if (vn==NULL){
		 throwException2(invalid_argument,
			 "createXMLModifier failed: can't take NULL VTDNav pointer");
		 return NULL;
	}	
	xm = (XMLModifier *)malloc(sizeof(XMLModifier));
	if (xm == NULL){
		 throwException2(invalid_argument,
			 "XMLModifier allocation failed");
		 return NULL;
	}
	bind4XMLModifier(xm, vn);
	return xm;
}
/*  freeXMLModifier will remove */
void freeXMLModifier(XMLModifier *xm){
	if (xm!=NULL){
		int i=0;
		freeIntHash(xm->deleteHash);
		freeIntHash(xm->insertHash);
		
		for (i=0;i<xm->fob->size;i++){
			Long l = longAt(xm->flb,i);
			if ((l & (~0x1fffffffffffffffLL)) == MASK_INSERT_SEGMENT_BYTE
				//|| (l & (~0x1fffffffffffffffLL)) == MASK_INSERT_SEGMENT_BYTE
				)
				free((void *)lower32At(xm->fob,i));
			else if ((l & (~0x1fffffffffffffffLL)) == MASK_INSERT_FRAGMENT_NS){
				freeElementFragmentNs((ElementFragmentNs *)lower32At(xm->fob,i));
			}
		}
		freeFastLongBuffer(xm->flb);
		freeFastLongBuffer(xm->fob);
	}
	free(xm);
}

/*  */
void bind4XMLModifier(XMLModifier *xm, VTDNav *vn){
	if (vn==NULL){
		throwException2(invalid_argument,
			"createXMLModifier failed: can't take NULL VTDNav pointer");
	}
	xm->md = vn;
	xm->encoding = xm->md->encoding;
	xm->deleteHash = createIntHash2(determineHashWidth(vn->vtdSize));
	xm->insertHash = createIntHash2(determineHashWidth(vn->vtdSize));
	xm->flb = createFastLongBuffer();
	xm->fob = createFastLongBuffer();
	switch(xm->md->encoding){
		case FORMAT_ASCII:
			xm->gbytes  = getBytes_ASCII;
			break;
		case FORMAT_ISO_8859_1:
			xm->gbytes  = getBytes_ISO_8859_1;
			break;
		case FORMAT_UTF8:
			xm->gbytes = getBytes_UTF8;
			break;
		case FORMAT_UTF_16LE:
			xm->gbytes = getBytes_UTF16LE;
			break;
		case FORMAT_UTF_16BE:
			xm->gbytes = getBytes_UTF16BE;
			break;
		default:
			throwException2(modify_exception, "Encoding not yet supported ");
	}
}
   /**
     * Removes content from the master XML document 
     * It first calls getCurrentIndex() if the result is 
     * a starting tag, then the entire element referred to
     * by the starting tag is removed
     * If the result is an attribute name or ns node, then 
     * the corresponding attribute name/value pair is removed
     * If the token type is one of text, CDATA or commment,
     * then the entire node, including the starting and ending 
     * delimiting text surrounding the content, is removed
     *
     */
void remove4XMLModifier(XMLModifier *xm){
	int i = getCurrentIndex(xm->md);
	int type = getTokenType(xm->md,i);
	if (type==TOKEN_STARTING_TAG){
		Long l = getElementFragment(xm->md);
		removeContent(xm,(int)l, (int)(l>>32));            
	} else if (type == TOKEN_ATTR_NAME 
		|| type==TOKEN_ATTR_NS){
			removeAttribute(xm,i);
	} else {
		removeToken(xm,i);
	}
}

void removeToken(XMLModifier *xm, int i){
	    int type = getTokenType(xm->md,i);
        int os,len;
		os = getTokenOffset(xm->md,i);
   		len = getTokenLength(xm->md,i);
        switch(type){
        	case TOKEN_CDATA_VAL:
        	    if (xm->encoding < FORMAT_UTF_16BE)
        		    removeContent(xm, os - 9, len + 12 );
        		else
        		    removeContent(xm, (os - 9)<<1,(len+12)<<1);
        		return;
        		 
        	case TOKEN_COMMENT:
           	    if (xm->encoding< FORMAT_UTF_16BE)
           	        removeContent(xm, os-4, len+7);
           	    else
           	        removeContent(xm, (os-4) << 1, (len+7) << 1);
           	    return;
        		
        	default:
    			if (xm->encoding < FORMAT_UTF_16BE)
        	        removeContent(xm, os, len);
        	    else
        	        removeContent(xm,(os) << 1, (len) << 1);
        	    return;        	    
        }
}

void removeAttribute(XMLModifier *xm,int attrNameIndex){
	int type = getTokenType(xm->md,attrNameIndex);
	int os1,os2,len2;
	if (type != TOKEN_ATTR_NAME && type != TOKEN_ATTR_NS){
		throwException2(modify_exception,
			"token type should be attribute name");
	}
	os1 = getTokenOffset(xm->md,attrNameIndex);
	os2 = getTokenOffset(xm->md,attrNameIndex+1);
	len2 = getTokenLength(xm->md,attrNameIndex+1);
	if ( xm->md->encoding < FORMAT_UTF_16BE)
		removeContent(xm,os1,os2+len2-os1+1); 
	else 
		removeContent(xm,os1<<1,(os2+len2-os1+1)<<1); 
}

void removeContent(XMLModifier *xm, int offset, int len){
	if (offset < xm->md->docOffset || len > xm->md->docLen 
		|| offset + len > xm->md->docOffset + xm->md->docLen){
			throwException2(modify_exception,
				"Invalid offset or length for removeContent");
	}
	if (isUniqueIntHash(xm->deleteHash,offset)==FALSE){
		throwException2(modify_exception,
			"There can be only one deletion per offset value");
	}
	appendLong(xm->flb,((Long)len)<<32 | offset | MASK_DELETE);
	appendLong(xm->fob,(Long)NULL);
}

void insertBytesAt(XMLModifier *xm, int offset, Long lenPlusPointer){
	if (isUniqueIntHash(xm->insertHash,offset)==FALSE){
		throwException2(modify_exception,
			"There can be only one insertion per offset value");
	}
	appendLong(xm->flb, offset | MASK_INSERT_BYTE);
	appendLong(xm->fob, lenPlusPointer);
}

void insertBytesAt2(XMLModifier *xm, int offset, Long lenPlusPointer){
	if (isUniqueIntHash(xm->insertHash,offset)==FALSE){
		throwException2(modify_exception,
			"There can be only one insertion per offset value");
	}
	appendLong(xm->flb, offset | MASK_INSERT_SEGMENT_BYTE);
	appendLong(xm->fob, lenPlusPointer);
}

void insertBytesAt3(XMLModifier *xm, int offset, ElementFragmentNs* ef){
	if (isUniqueIntHash(xm->insertHash,offset)==FALSE){
		throwException2(modify_exception,
			"There can be only one insertion per offset value");
	}
	appendLong(xm->flb, offset | MASK_INSERT_FRAGMENT_NS);
	appendLong(xm->fob, ef);
}

void updateToken(XMLModifier *xm, int index, UCSChar *newContent){
	int offset, len, type;
	if (newContent==NULL){
		throwException2(invalid_argument,
			"String newContent can't be null");
	}
	offset = getTokenOffset(xm->md,index);
	len = getTokenLength(xm->md,index);
	type = getTokenType(xm->md,index);
	// one insert
	switch(type){
			case TOKEN_CDATA_VAL:
				if (xm->md->encoding < FORMAT_UTF_16BE)
					insertBytesAt(xm,offset-9,xm->gbytes(newContent));
				else 
					insertBytesAt(xm,(offset-9)<<1,xm->gbytes(newContent));
				break;
			case TOKEN_COMMENT:
				if (xm->md->encoding < FORMAT_UTF_16BE)
					insertBytesAt(xm,offset-4,xm->gbytes(newContent));
				else 
					insertBytesAt(xm,(offset-4)<<1,xm->gbytes(newContent));
				break;

			default: 
				insertBytesAt(xm, offset,xm->gbytes(newContent));
	}
	/* one delete */
	removeToken(xm,index);      
}

/* replace token with a segment of byte array */
void updateToken2(XMLModifier *xm, int index, UByte *byteContent, int contentOffset, int contentLen){
	int offset, len, type;
	if (byteContent==NULL){
		throwException2(invalid_argument,
			"byteContent can't be null");
	}
	offset = getTokenOffset(xm->md,index);
	len = getTokenLength(xm->md,index);
	type = getTokenType(xm->md,index);
	// one insert
	switch(type){
			case TOKEN_CDATA_VAL:
				if (xm->md->encoding < FORMAT_UTF_16BE)
					insertBytesAt2(xm,offset-9,(((Long)contentLen)<<32)|((int)byteContent+contentOffset));
				else 
					insertBytesAt2(xm,(offset-9)<<1,(((Long)contentLen)<<32)|((int)byteContent+contentOffset));
				break;
			case TOKEN_COMMENT:
				if (xm->md->encoding < FORMAT_UTF_16BE)
					insertBytesAt2(xm,offset-4,(((Long)contentLen)<<32)|((int)byteContent+contentOffset));
				else 
					insertBytesAt2(xm,(offset-4)<<1,(((Long)contentLen)<<32)|((int)byteContent+contentOffset));
				break;

			default: 
				insertBytesAt2(xm, offset,(((Long)contentLen)<<32)|((int)byteContent+contentOffset));
	}
	/* one delete */
	removeToken(xm,index);    
}

void insertAfterElement(XMLModifier *xm, UCSChar *s){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset, len;
	Long l;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	l = getElementFragment(xm->md);
	offset = (int)l;
	len = (int)(l>>32);
	insertBytesAt(xm, offset+len, xm->gbytes(s));
}

void insertBeforeElement(XMLModifier *xm, UCSChar *s){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	offset = getTokenOffset(xm->md,startTagIndex)-1;
	
	if (xm->encoding < FORMAT_UTF_16BE)
		insertBytesAt(xm,offset,xm->gbytes(s));
	else
		insertBytesAt(xm,(offset)<<1,xm->gbytes(s));
}

void insertAttribute(XMLModifier *xm, UCSChar *attr){
	int startTagIndex = getCurrentIndex(xm->md),offset,len;
	int type = getTokenType(xm->md,startTagIndex);
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	offset = getTokenOffset(xm->md,startTagIndex);
	len = getTokenLength(xm->md,startTagIndex);

	if (xm->encoding < FORMAT_UTF_16BE)
		insertBytesAt(xm,offset+len,xm->gbytes(attr));
	else
		insertBytesAt(xm, (offset+len)<<1,xm->gbytes(attr));
}

/* insert a byte array before the start of an element 
   the byte array won't get freed when calling XMLModifier's 
   resetXMLModifier() and freeXMLModifier() 
*/
void insertAfterElement2(XMLModifier *xm, UByte* ba, int arrayLen){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset, len;
	Long l;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	l = getElementFragment(xm->md);
	offset = (int)l;
	len = (int)(l>>32);
	insertBytesAt2(xm, offset+len, (((Long)arrayLen)<<32)|(int)ba);
}

void insertBeforeElement2(XMLModifier *xm, UByte* ba, int arrayLen){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	offset = getTokenOffset(xm->md,startTagIndex)-1;
	
	if (xm->encoding < FORMAT_UTF_16BE)
		insertBytesAt2(xm,offset, (((Long)arrayLen)<<32)|(int)ba);
	else
		insertBytesAt2(xm,(offset)<<1, (((Long)arrayLen)<<32)|(int)ba);
}

void insertAfterElement3(XMLModifier *xm, UByte* ba, int contentOffset, int contentLen){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	offset = getTokenOffset(xm->md,startTagIndex)-1;
	
	if (xm->encoding < FORMAT_UTF_16BE)
		insertBytesAt2(xm,offset, (((Long)contentLen)<<32)|((int)ba+contentOffset));
	else
		insertBytesAt2(xm,(offset)<<1, (((Long)contentLen)<<32)|((int)ba+contentOffset));
}

void insertBeforeElement3(XMLModifier *xm, UByte* ba, int contentOffset, int contentLen){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset, len;
	Long l;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	l = getElementFragment(xm->md);
	offset = (int)l;
	len = (int)(l>>32);
	insertBytesAt2(xm, offset+len, (((Long)contentLen)<<32)|((int)ba+contentOffset));
}

void insertBeforeElement4(XMLModifier *xm, ElementFragmentNs *ef){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset, len;
	Long l;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	l = getElementFragment(xm->md);
	offset = (int)l;
	len = (int)(l>>32);
	insertBytesAt3(xm,offset+len,ef);
}


void insertAfterElement4(XMLModifier *xm, ElementFragmentNs *ef){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	offset = getTokenOffset(xm->md,startTagIndex)-1;
	if (xm->encoding < FORMAT_UTF_16BE)
		insertBytesAt3(xm,offset, ef);
	else
		insertBytesAt3(xm,(offset)<<1, ef);
}


/* the present implementation automatically garbage collect 
   the byte array newContentBytes when calling freeXMLModifier*/
/*void updateToken2(XMLModifier *xm, int index, UByte *newContentBytes, int l){
		int offset, len, type;
	if (newContentBytes==NULL){
		throwException2(invalid_argument,
			" newContentBytes can't be null");
	}
	offset = getTokenOffset(xm->md,index);
	len = getTokenLength(xm->md,index);
	type = getTokenType(xm->md,index);
	// one insert
	switch(type){
			case TOKEN_CDATA_VAL:
				if (xm->md->encoding < FORMAT_UTF_16BE)
					insertBytesAt(xm,offset-9,(((Long)l <<32)| (int)newContentBytes));
				else 
					insertBytesAt(xm,(offset-9)<<1,(((Long)l <<32)| (int)newContentBytes));
				break;
			case TOKEN_COMMENT:
				if (xm->md->encoding < FORMAT_UTF_16BE)
					insertBytesAt(xm,offset-4,(((Long)l <<32)| (int)newContentBytes));
				else 
					insertBytesAt(xm,(offset-4)<<1,(((Long)l <<32)| (int)newContentBytes));
				break;

			default: 
				insertBytesAt(xm, offset,(((Long)l <<32)| (int)newContentBytes));
	}
	// one delete
	removeToken(xm,index);   
}*/

/* the present implementation automatically garbage collect 
   the byte array b when calling freeXMLModifier*/
/*void insertAfterElement2(XMLModifier *xm, UByte *b, int l){
	int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset, len;
	Long ll;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	} 
	ll = getElementFragment(xm->md);
	offset = (int)ll;
	len = (int)(ll>>32);
	insertBytesAt(xm, offset+len, (((Long)l <<32)| (int)b));
}*/

/* the present implementation automatically garbage collect 
   the byte array b when calling freeXMLModifier*/
/*void insertBeforeElement2(XMLModifier *xm, UByte *b, int l){
		int startTagIndex = getCurrentIndex(xm->md);
	int type =  getTokenType(xm->md, startTagIndex);
	int offset;
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	offset = getTokenOffset(xm->md,startTagIndex)-1;
	
	if (xm->encoding < FORMAT_UTF_16BE)
		insertBytesAt(xm,offset,(((Long)l <<32)  | (int)b));
	else
		insertBytesAt(xm,(offset)<<1,(((Long)l <<32)  | (int)b));
}*/

/* the present implementation automatically garbage collect 
   the byte array attrBytes when calling freeXMLModifier*/
/*void insertAttribute2(XMLModifier *xm, UByte *attrBytes, int l){
	int startTagIndex = getCurrentIndex(xm->md),offset,len;
	int type = getTokenType(xm->md,startTagIndex);
	if (type!=TOKEN_STARTING_TAG){
		throwException2(modify_exception,
			"Token type is not a starting tag");
	}
	offset = getTokenOffset(xm->md,startTagIndex);
	len = getTokenLength(xm->md,startTagIndex);

	if (xm->encoding < FORMAT_UTF_16BE)
		insertBytesAt(xm,offset+len,(((Long)l <<32)  | (int)attrBytes));
	else
		insertBytesAt(xm, (offset+len)<<1,(((Long)l<<32) |(int)attrBytes));
}*/

/* write the updated document into a File */
void output(XMLModifier *xm, FILE *f){
	 Long l;
	 size_t k;
	 UByte *ba;
	 int t,start,len;
	if (f == NULL){
		throwException2(invalid_argument,
			"FILE can't be a NULL");
	}           
	t = lower32At(xm->md->vtdBuffer,0);
	start = (t==0)?
		xm->md->docOffset:32;
	len = (t==0)?
		xm->md->docLen:(xm->md->docLen-32);
	sort(xm);
	check(xm);
	ba = xm->md->XMLDoc;

	if (xm->flb->size==0){
		k=fwrite(xm->md->XMLDoc+start,sizeof(UByte),len,f);
		if (k!=len){
			throwException2(io_exception,"fwrite didn't complete");
		}
	}else{
		int offset = start;
		int i;
		int inc=1;
		size_t t;
		for(i=0;i<xm->flb->size;i=i+inc){
			if (lower32At(xm->flb,i)==lower32At(xm->flb,i+1)){
				inc  = 2;
			} else 
				inc = 1;
			l = longAt(xm->flb,i);
			if (inc == 1){                    
				if ((l & (~0x1fffffffffffffffLL)) == MASK_DELETE){
					t = lower32At(xm->flb,i);
					k=fwrite(xm->md->XMLDoc+offset,sizeof(UByte),t-offset,f);
					if (k!=t-offset)
						throwException2(io_exception,"fwrite didn't complete");
					offset = t + (upper32At(xm->flb,i) & 0x1fffffff);
				}else if ((l & (~0x1fffffffffffffffLL)) == MASK_INSERT_BYTE
					|| (l & (~0x1fffffffffffffffLL)) == MASK_INSERT_SEGMENT_BYTE){ 
					// insert
					t = lower32At(xm->flb,i);
					k=fwrite(xm->md->XMLDoc+offset,sizeof(UByte),t-offset,f);
					if (k!=t-offset)
						throwException2(io_exception,"fwrite didn't complete");
					t = upper32At(xm->fob,i);/* the length */
					k=fwrite((void *)lower32At(xm->fob,i),sizeof(UByte),t,f);
					if (k!=t)
						throwException2(io_exception,"fwrite didn't complete");                      
					offset=lower32At(xm->flb,i);
				}else {
					t = lower32At(xm->flb,i);
					k=fwrite(xm->md->XMLDoc+offset,sizeof(UByte),t-offset,f);
					if (k!=t-offset)
						throwException2(io_exception,"fwrite didn't complete");
					writeFragmentToFile((ElementFragmentNs*)lower32At(xm->fob,i),f);
					offset=lower32At(xm->flb,i);
				}
			} else {
				    long k = longAt(xm->flb,i+1),temp;
                    int i1 = i,temp2;
                    int i2 = i+1;
                    if ((l & (~0x1fffffffffffffffL)) != MASK_DELETE){
                        temp = l;
                        l= k;
                        k = temp;
                        temp2 = i1;
                        i1 = i2;
                        i2 = temp2;
                    }									
					
					t = lower32At(xm->flb,i1);
					k=fwrite(xm->md->XMLDoc+offset,sizeof(UByte),t-offset,f);
					if (k!=t-offset)
						throwException2(io_exception,"fwrite didn't complete");
					//os.write(ba,offset, flb.lower32At(i)-offset);
					//os.write((byte[])fob.objectAt(i+1));
					//t = upper32At(xm->fob,i+1);/* the length */
								   
					if ((k & (~0x1fffffffffffffffLL)) == MASK_INSERT_BYTE
					|| (k & (~0x1fffffffffffffffLL)) == MASK_INSERT_SEGMENT_BYTE){
					/*t = lower32At(xm->flb,i+1);
					k=fwrite(xm->md->XMLDoc+offset,sizeof(UByte),t-offset,f);
					if (k!=t-offset)
						throwException2(io_exception,"fwrite didn't complete");*/
					/*os.write(ba,offset, flb.lower32At(i+1)-offset);*/
					t = upper32At(xm->fob,i2);   /* the length */
					k=fwrite((void *)lower32At(xm->fob,i2),sizeof(UByte),t,f);
					if (k!=t)
						throwException2(io_exception,"fwrite didn't complete");  
					offset = lower32At(xm->flb,i1) + (upper32At(xm->flb,i1) & 0x1fffffff);
				}else {
					/*t = lower32At(xm->flb,i+1);
					  k=fwrite(xm->md->XMLDoc+offset,sizeof(UByte),t-offset,f);
					  if (k!=t-offset)
					 	throwException2(io_exception,"fwrite didn't complete");*/
					writeFragmentToFile((ElementFragmentNs*)lower32At(xm->fob,i2),f);
					offset = lower32At(xm->flb,i1) + (upper32At(xm->flb,i1) & 0x1fffffff);
				}
			}
		}  
		t = start+len-offset;
		k=fwrite(xm->md->XMLDoc+offset,sizeof(UByte),t,f);
		if (k!=t)
			throwException2(io_exception,"fwrite didn't complete");  
		/*os.write(ba,offset,md.docOffset+md.docLen-offset);*/
	}

}

void output2(XMLModifier *xm, char *fileName){
	FILE *f = NULL;
	f = fopen(fileName,"wb");
	
	if (f==NULL){
		throwException2(invalid_argument,"fileName not valid");
		return FALSE;
	}
	output(xm,f);
	fclose(f);
}

static void check(XMLModifier *xm){
	int os1, os2, temp,i;
	int size = xm->flb->size;

	for (i=0;i<size;i++){
		os1 = lower32At(xm->flb,i);
		os2 = lower32At(xm->flb,i)+ (upper32At(xm->flb,i)& 0x1fffffff)-1;
		if (i+1<size){
			temp = lower32At(xm->flb,i+1);
			if (temp!= os1 && temp<=os2){
				throwException2(modify_exception,
					"Invalid insertion/deletion condition detected in output()");
			}
		}
	}
}
static quickSort(XMLModifier* xm, int lo, int hi){
	int i=lo, j=hi; 
	Long h;
	Long o;
	int x= lower32At(xm->flb,(lo+hi)/2);

	//  partition
	do
	{    
		while (lower32At(xm->flb,i)<x) i++; 
		while (lower32At(xm->flb,j)>x) j--;
		if (i<=j)
		{
			h= longAt(xm->flb,i); 
			o = longAt(xm->fob,i);
			modifyEntryFLB(xm->flb,i,longAt(xm->flb,j)); 
			modifyEntryFLB(xm->fob,i,longAt(xm->fob,j));
			modifyEntryFLB(xm->flb,j,h);
			modifyEntryFLB(xm->fob,j,o);
			i++; 
			j--;
		}
	} while (i<=j);

	//  recursion
	if (lo<j) quickSort(xm,lo, j);
	if (i<hi) quickSort(xm,i, hi);
}

/* sort flb based on offset value so the sorted flb offset vals are document order*/
static void sort(XMLModifier *xm){
	if (xm->flb->size >0)
		quickSort(xm,0,xm->flb->size-1);
}

/* resetXMLModifier */
void resetXMLModifier(XMLModifier *xm){
	if (xm != NULL){
		if (xm->fob!= NULL){
			int i=0;
			for (i=0; i< xm->flb->size;i++){
				// free byte segment and elementFragmentNs
				Long l = longAt(xm->flb,i);
				if ( (l & (~0x1fffffffffffffffLL)) == MASK_INSERT_BYTE
					//||(l & (~0x1fffffffffffffffLL)) == MASK_INSERT_SEGMENT_BYTE
					)
					free((void *)lower32At(xm->fob,i));
				else if ( (l & (~0x1fffffffffffffffLL)) == MASK_INSERT_FRAGMENT_NS){
					freeElementFragmentNs((ElementFragmentNs *)lower32At(xm->fob,i));
				}
			}
			clearFastLongBuffer(xm->fob);
		}
		if (xm->flb!= NULL){
			clearFastLongBuffer(xm->flb);
		}
		if (xm->insertHash!= NULL){
			resetIntHash(xm->insertHash);
		}
		if (xm->deleteHash!= NULL){
			resetIntHash(xm->deleteHash);
		}
	}
}
/* 
ByteSegment* createByteSegment(){
	ByteSegment* bs = NULL;
	return bs;
}
void freeByteSegment(ByteSegment *bs){
	free(bs);
}
*/



