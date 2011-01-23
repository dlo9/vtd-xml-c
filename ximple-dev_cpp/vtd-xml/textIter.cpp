/* 
 * Copyright (C) 2002-2011 XimpleWare, info@ximpleware.com
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
#include "textIter.h"
#include "vtdNav_L5.h"
using namespace com_ximpleware;


int TextIter::increment(int sp){
	tokenType type = vn->getTokenType(sp);
    int vtdSize = vn->vtdBuffer->size;
    int i=sp+1;
    while(i<vtdSize && 
    	depth == vn->getTokenDepth(i) && 
		type == vn->getTokenType(i)&&
		(vn->getTokenOffset(i-1)+ (int)((vn->vtdBuffer->longAt( i-1) & VTDNav::MASK_TOKEN_FULL_LEN)>>32) 
			        == vn->getTokenOffset(i))){
		i++;
    }      	
    return i;
}
/* Test whether a give token type is a TEXT.*/
bool TextIter::isText(int i){
	tokenType type = vn->getTokenType(i);
	if (sel_type == 0) {
		return (type == TOKEN_CHARACTER_DATA
			// || type == vn.TOKEN_COMMENT
			|| type == TOKEN_CDATA_VAL);
	}
	if (sel_type == 1) {
		return (type == TOKEN_COMMENT);
	}

	if (sel_type == 2)
		return (type == TOKEN_PI_NAME);
	try {
		return (vn->matchRawTokenString(index, piName));
	} catch(NavException&){
		
	}
	return false;
}		

int TextIter::handleDocumentNode(){
	int sp;
	if (sel_type == 0)
		return -1;
	sp = (prevLocation != -1) ? increment(prevLocation): index + 1;
	if (sp>=vn->vtdSize) return -1;
	//int d = vn.getTokenDepth(sp);
	//int type = vn.getTokenType(sp);
	//while (d == -1/*&& !(d == depth && type == VTDNav.TOKEN_STARTING_TAG)*/) {
	while(true){    
		if (sp< vn->rootIndex) {
			if (isText(sp)){
				prevLocation = sp;
				return sp;
			} else 
				sp++;
		} else { 
			// rewind to the end of document
			if (sp == vn->rootIndex){
				sp = vn->vtdSize-1;
				while(vn->getTokenDepth(sp)==-1){
					sp--;
				}
				sp++;
			}        		 
			if (sp>=vn->vtdSize){
				return -1;
			} else if (isText(sp)){
				prevLocation = sp;
				return sp;
			} else
				sp++;        		         		 
		}
	}
}

int TextIter::handleLevel0(){
	//int curDepth = vn.context[0];
	int d, sp;
	sp = (prevLocation != -1) ? increment(prevLocation): index + 1;
	if (sp>=vn->vtdSize) return -1;
	d = vn->getTokenDepth(sp);
	tokenType type = vn->getTokenType(sp);
	while (d >= depth
		&& !(d == depth && type == TOKEN_STARTING_TAG)) {
			if (isText(sp) == true && d == depth) {
				prevLocation = sp;
				return sp;
			}
			sp++;
			if(sp >= vn->vtdSize)
				return -1;

			d = vn->getTokenDepth(sp);
			type = vn->getTokenType(sp);                
	}
	return -1;
}
int TextIter::handleLevel1(){
	   	int sp,size;
        if (prevLocation != -1) {
            sp = increment(prevLocation) ;
        } else {
            // fetch lclower and lcupper
			int i;
            lcLower = vn->l1Buffer->lower32At(vn->l1index);
            if (lcLower != -1) {
				lcUpper = vn->l2Buffer->size - 1;
                size = vn->l1Buffer->size;
                for (i = vn->l1index + 1; i < size ; i++) {
                    int temp = vn->l1Buffer->lower32At(i);
                    if (temp != (int)0xffffffff) {
                        lcUpper = temp - 1;
                        break;
                    }
                }
            }
            sp = index + 1;
        } // check for l2lower and l2upper

        if (lcLower != -1) { // have at least one child element
			int temp1 = vn->l2Buffer->upper32At(lcLower);
            int temp2 = vn->l2Buffer->upper32At(lcUpper);
            lcIndex = (lcIndex != -1) ? lcIndex : lcLower;
            while (sp < vn->vtdSize) {
                int s = vn->l2Buffer->upper32At(lcIndex);
                if (sp >= temp1 && sp < temp2) {
                    if (sp == s) {
                        lcIndex++;
						sp = vn->l2Buffer->upper32At(lcIndex) - 1;
                        //boolean b = false;
                        while (vn->getTokenDepth(sp) == 1) {
                        	//b = true;
                            sp--;
                        }
                        //if (b)
                        sp++;
                        //continue; 
                    }
                    if (isText(sp) == true && vn->getTokenDepth(sp)==1 ) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else if (sp < temp1) {
                    if (isText(sp) == true) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else {
                    //if (sp == temp2) { // last child element
                    //} else
                    
                    if (isText(sp) == true && vn->getTokenDepth(sp) == 1){
                    	//System.out.println("depth ->"+vn.getTokenDepth(sp));
                        prevLocation = sp;
                        return sp;
                    } else if ((vn->getTokenType(sp)==TOKEN_STARTING_TAG
                            && vn->getTokenDepth(sp) < 2 ) || vn->getTokenDepth(sp)<1) {
                        break;
                    }
                    sp++;
                }                    
            }
            //prevLocation = vtdSize-1;
            return -1;
        } else { // no child element
            if (sp>=vn->vtdSize) return -1;
            int d = vn->getTokenDepth(sp);
            tokenType type = vn->getTokenType(sp);
            while (sp < vn->vtdSize
                && d >= 1
                && !(d == 1 && type == TOKEN_STARTING_TAG)) {
                if (isText(sp) == true) {
                    prevLocation = sp;
                    return sp;
                }
                sp++;
                d = vn->getTokenDepth(sp);
                type = vn->getTokenType(sp);
                
            }
            //prevLocation = vtdSize-1;
            return -1;
        }
}

int TextIter::handleLevel2(){
	    	int sp;
        if (prevLocation != -1) {
            sp = increment(prevLocation);
        } else {
            // fetch lclower and lcupper
            lcLower = vn->l2Buffer->lower32At(vn->l2index);
            if (lcLower != -1) {
				int i,size;
                lcUpper =  vn->l3Buffer->size - 1;
                size = vn->l2Buffer->size;
                for (i = vn->l2index + 1; i < size ; i++) {
                    int temp = vn->l2Buffer->lower32At(i);
                    if (temp != (int)0xffffffff) {
                        lcUpper = temp - 1;
                        break;
                    }
                }
            }
            sp = index + 1;
        } // check for l3lower and l3upper

        if (lcLower != -1) { // at least one child element
            int temp1 = vn->l3Buffer->intAt(lcLower);
            int temp2 = vn->l3Buffer->intAt(lcUpper);
            lcIndex = (lcIndex != -1) ? lcIndex : lcLower;
            while (sp < vn->vtdSize) {
                int s = vn->l3Buffer->intAt(lcIndex);
                //int s = vn.l2Buffer.upper32At(lcIndex);
                if (sp >= temp1 && sp < temp2) {
                    if (sp == s) {
                        lcIndex++;
                        sp = vn->l3Buffer->intAt(lcIndex) - 1;
                        //boolean b = false;
                        while (vn->getTokenDepth(sp) == 2) {
                            sp--;
                          //  b = true;
                        }
                        //if (b)
                        	sp++;
                        //continue;
                    }
                    if (isText(sp) == true && vn->getTokenDepth(sp)==2) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else if (sp < temp1) {
                    if (isText(sp) == true && vn->getTokenDepth(sp)==2) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else {
                    //if (sp == temp2) { // last child element
                    //} else                 
                    if ( isText(sp) == true && vn->getTokenDepth(sp) == 2) {
                        prevLocation = sp;
                        return sp;
                    } else if ((vn->getTokenType(sp)==TOKEN_STARTING_TAG
                            && vn->getTokenDepth(sp) < 3 ) || vn->getTokenDepth(sp)<2) {
                        break;
                    }
                    sp++;
                }
            }
            //prevLocation = vtdSize-1;
            return -1;
        } else { // no child elements
            if (sp>=vn->vtdSize) return -1;
            int d = vn->getTokenDepth(sp);
            tokenType type = vn->getTokenType(sp);
            while (sp < vn->vtdSize
                && d >= 2
                && !(d == 2 && type == TOKEN_STARTING_TAG)) {
                // the last condition indicates the start of the next sibling element
                if (isText(sp) == true && vn->getTokenDepth(sp)==2) {
                    prevLocation = sp;
                    return sp;
                }
                sp++;
                d = vn->getTokenDepth(sp);
                type = vn->getTokenType(sp);
                
            }
            //prevLocation = vtdSize-1;
            return -1;
        }
}

int TextIter::handleDefault(){	
	int sp = (prevLocation != -1) ? increment(prevLocation): index + 1;
	if (sp>=vn->vtdSize) return -1;
	int d = vn->getTokenDepth(sp);
	tokenType type = vn->getTokenType(sp);
	while (d >= depth
		&& !(d == depth && type == TOKEN_STARTING_TAG)) {
			if (isText(sp) == true && d == depth) {
				prevLocation = sp;
				return sp;
			}
			sp++;
			if(sp >= vn->vtdSize)
				return -1;

			d = vn->getTokenDepth(sp);
			type = vn->getTokenType(sp);                
	}
	return -1;
}

/* create TextIter */
TextIter::TextIter():
vn(NULL),
sel_type(0),
piName(NULL)
{}
/* free TextIter */
TextIter::~TextIter(){
	delete piName;
}
/* Obtain the current navigation position and element info from VTDNav.
* So one can instantiate it once and use it for many different elements */
void TextIter::touch(VTDNav *v){	
	depth = v->context[0];
	if (depth == -1)
		index = 0;
	else 
		index = (depth != 0) ? v->context[depth] : v->rootIndex;

	vn = v;
	prevLocation = -1;
	lcIndex = -1;
	lcUpper = -1;
	lcLower = -1;
}
/* Get the index vals for the text nodes in document order.*/
int TextIter::getNext(){
	if (vn == NULL)
		throw InvalidArgumentException("VTDNav instance can't be null");
	if (vn->shallowDepth){
		switch (depth) {
		case -1: return handleDocumentNode();
		case 0 :
			return handleLevel0();
		case 1 :
			return handleLevel1();
		case 2 :
			return handleLevel2();
		default :
			return handleDefault();
		}
	}else{
		switch (depth) {

			case -1:
				return handleDocumentNode();
			case 0:
				return handleLevel0();
			case 1:
				return handleLevel1();
			case 2:
				return _handleLevel2();
			case 3:
				return handleLevel3();
			case 4:
				return handleLevel4();
			default:
				return handleDefault();
		}
	}
}
/* Ask textIter to return character data or CDATA nodes*/
void TextIter::selectText(){
	sel_type = 0;
}
/*  Ask textIter to return comment nodes*/
void TextIter::selectComment(){
	sel_type = 1;
}
/* Ask TextIter to return processing instruction name 
* no value */
void TextIter::selectPI0(){
	sel_type = 2;
}
/* Ask TextIter to return processing instruction of 
given name */
void TextIter::selectPI1(UCSChar *s){
	sel_type =3;
	piName = s;
}


int TextIter::_handleLevel2(){
      	int sp;
       	VTDNav_L5 *vnl = (VTDNav_L5 *)vn;
        if (prevLocation != -1) {
            sp = increment(prevLocation);
        } else {
            // fetch lclower and lcupper
            lcLower = vnl->l2Buffer->lower32At(vnl->l2index);
            if (lcLower != -1) {
                lcUpper = vnl->l3Buffer->size - 1;
                int size = vnl->l2Buffer->size;
                for (int i = vnl->l2index + 1; i < size ; i++) {
                    int temp = vnl->l2Buffer->lower32At(i);
                    if (temp != (int)0xffffffff) {
                        lcUpper = temp - 1;
                        break;
                    }
                }
            }
            sp = index + 1;
        } // check for l3lower and l3upper

        if (lcLower != -1) { // at least one child element
            int temp1 = vnl->l3Buffer->upper32At(lcLower);
            int temp2 = vnl->l3Buffer->upper32At(lcUpper);
            lcIndex = (lcIndex != -1) ? lcIndex : lcLower;
            while (sp < vnl->vtdSize) {
                int s = vnl->l3Buffer->upper32At(lcIndex);
                //int s = vn.l2Buffer.upper32At(lcIndex);
                if (sp >= temp1 && sp < temp2) {
                    if (sp == s) {
                        lcIndex++;
                        sp = vnl->l3Buffer->upper32At(lcIndex) - 1;
                        //boolean b = false;
                        while (vnl->getTokenDepth(sp) == 2) {
                            sp--;
                          //  b = true;
                        }
                        //if (b)
                        	sp++;
                        //continue;
                    }
                    if (isText(sp) == true && vnl->getTokenDepth(sp)==2) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else if (sp < temp1) {
                    if (isText(sp) == true && vnl->getTokenDepth(sp)==2) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else {
                    //if (sp == temp2) { // last child element
                    //} else                 
                    if ( isText(sp) == true && vnl->getTokenDepth(sp) == 2) {
                        prevLocation = sp;
                        return sp;
                    } else if ((vnl->getTokenType(sp)==TOKEN_STARTING_TAG
                            && vnl->getTokenDepth(sp) < 3 ) || vnl->getTokenDepth(sp)<2) {
                        break;
                    }
                    sp++;
                }
            }
            //prevLocation = vtdSize-1;
            return -1;
        } else { // no child elements
            if (sp>=vn->vtdSize) return -1;
            int d = vn->getTokenDepth(sp);
            int type = vn->getTokenType(sp);
            while (sp < vn->vtdSize
                && d >= 2
                && !(d == 2 && type == TOKEN_STARTING_TAG)) {
                // the last condition indicates the start of the next sibling element
                if (isText(sp) == true && vn->getTokenDepth(sp)==2) {
                    prevLocation = sp;
                    return sp;
                }
                sp++;
                d = vn->getTokenDepth(sp);
                type = vn->getTokenType(sp);
                
            }
            //prevLocation = vtdSize-1;
            return -1;
        }
}
int TextIter::handleLevel3(){
    	
       	int sp;
       	VTDNav_L5* vnl = (VTDNav_L5 *)vn;
        if (prevLocation != -1) {
            sp = increment(prevLocation);
        } else {
            // fetch lclower and lcupper
            lcLower = vnl->l3Buffer->lower32At(vnl->l3index);
            if (lcLower != -1) {
                lcUpper = vnl->l4Buffer->size - 1;
                int size = vnl->l3Buffer->size;
                for (int i = vnl->l3index + 1; i < size ; i++) {
                    int temp = vnl->l3Buffer->lower32At(i);
                    if (temp != (int)0xffffffff) {
                        lcUpper = temp - 1;
                        break;
                    }
                }
            }
            sp = index + 1;
        } // check for l3lower and l3upper
        if (lcLower != -1) { // at least one child element
            int temp1 = vnl->l4Buffer->upper32At(lcLower);
            int temp2 = vnl->l4Buffer->upper32At(lcUpper);
            lcIndex = (lcIndex != -1) ? lcIndex : lcLower;
            while (sp < vn->vtdSize) {
                int s = vnl->l4Buffer->upper32At(lcIndex);
                //int s = vn.l2Buffer.upper32At(lcIndex);
                if (sp >= temp1 && sp < temp2) {
                    if (sp == s) {
                        lcIndex++;
                        sp = vnl->l4Buffer->upper32At(lcIndex) - 1;
                        //boolean b = false;
                        while (vn->getTokenDepth(sp) == 2) {
                            sp--;
                          //  b = true;
                        }
                        //if (b)
                        	sp++;
                        //continue;
                    }
                    if (isText(sp) == true && vn->getTokenDepth(sp)==3) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else if (sp < temp1) {
                    if (isText(sp) == true && vn->getTokenDepth(sp)==3) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else {
                    //if (sp == temp2) { // last child element
                    //} else                 
                    if ( isText(sp) == true && vn->getTokenDepth(sp) == 3) {
                        prevLocation = sp;
                        return sp;
                    } else if ((vn->getTokenType(sp)==TOKEN_STARTING_TAG
                            && vn->getTokenDepth(sp) < 4 ) || vn->getTokenDepth(sp)<3) {
                        break;
                    }
                    sp++;
                }
            }
            //prevLocation = vtdSize-1;
            return -1;
        } else { // no child elements
            if (sp>=vn->vtdSize) return -1;
            int d = vn->getTokenDepth(sp);
            int type = vn->getTokenType(sp);
            while (sp < vn->vtdSize
                && d >= 3
                && !(d == 3 && type == TOKEN_STARTING_TAG)) {
                // the last condition indicates the start of the next sibling element
                if (isText(sp) == true && vn->getTokenDepth(sp)==3) {
                    prevLocation = sp;
                    return sp;
                }
                sp++;
                d = vn->getTokenDepth(sp);
                type = vn->getTokenType(sp);
                
            }
            //prevLocation = vtdSize-1;
            return -1;
        }
}
int TextIter::handleLevel4(){
   	int sp;
    	VTDNav_L5 *vnl = (VTDNav_L5 *)vn;
        if (prevLocation != -1) {
            sp = increment(prevLocation);
        } else {
            // fetch lclower and lcupper
            lcLower = vnl->l4Buffer->lower32At(vnl->l4index);
            if (lcLower != -1) {
                lcUpper = vnl->l5Buffer->size - 1; //5
                int size = vnl->l4Buffer->size; //4
                for (int i = vnl->l4index + 1; i < size ; i++) {//4
                    int temp = vnl->l4Buffer->lower32At(i); //4
                    if (temp != (int)0xffffffff) {
                        lcUpper = temp - 1;
                        break;
                    }
                }
            }
            sp = index + 1;
        } // check for l3lower and l3upper

        if (lcLower != -1) { // at least one child element
            int temp1 = vnl->l5Buffer->intAt(lcLower);
            int temp2 = vnl->l5Buffer->intAt(lcUpper);
            lcIndex = (lcIndex != -1) ? lcIndex : lcLower;
            while (sp < vn->vtdSize) {
                int s = vnl->l5Buffer->intAt(lcIndex);
                //int s = vn.l2Buffer.upper32At(lcIndex);
                if (sp >= temp1 && sp < temp2) {
                    if (sp == s) {
                        lcIndex++;
                        sp = vnl->l5Buffer->intAt(lcIndex) - 1;
                        //boolean b = false;
                        while (vn->getTokenDepth(sp) == 4) {
                            sp--;
                          //  b = true;
                        }
                        //if (b)
                        	sp++;
                        //continue;
                    }
                    if (isText(sp) == true && vn->getTokenDepth(sp)==4) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else if (sp < temp1) {
                    if (isText(sp) == true && vn->getTokenDepth(sp)==4) {
                        prevLocation = sp;
                        return sp;
                    }
                    sp++;
                } else {
                    //if (sp == temp2) { // last child element
                    //} else                 
                    if ( isText(sp) == true && vn->getTokenDepth(sp) == 4) {
                        prevLocation = sp;
                        return sp;
                    } else if ((vn->getTokenType(sp)==TOKEN_STARTING_TAG
                            && vn->getTokenDepth(sp) < 5 ) || vn->getTokenDepth(sp)<4) {
                        break;
                    }
                    sp++;
                }
            }
            //prevLocation = vtdSize-1;
            return -1;
        } else { // no child elements
            if (sp>=vn->vtdSize) return -1;
            int d = vn->getTokenDepth(sp);
            int type = vn->getTokenType(sp);
            while (sp < vn->vtdSize
                && d >= 4
                && !(d == 4 && type == TOKEN_STARTING_TAG)) {
                // the last condition indicates the start of the next sibling element
                if (isText(sp) == true && vn->getTokenDepth(sp)== 4) {
                    prevLocation = sp;
                    return sp;
                }
                sp++;
                d = vn->getTokenDepth(sp);
                type = vn->getTokenType(sp);
                
            }
            //prevLocation = vtdSize-1;
            return -1;
        }
}