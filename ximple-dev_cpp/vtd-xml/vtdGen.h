/* 
* Copyright (C) 2002-2010 XimpleWare, info@ximpleware.com
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
#pragma once
#ifndef VTDGEN_H
#define VTDGEN_H
#include "customTypes.h"
//#include <new>
//#include <iostream>

#include "fastLongBuffer.h"
#include "fastIntBuffer.h"
#include "vtdNav.h"

#include "indexHandler.h"
namespace com_ximpleware {
	//class VTDNav;
	class VTDGen {	
		friend class IndexHandler;

	private:
		typedef enum {
			STATE_LT_SEEN,
			STATE_START_TAG,
			STATE_END_TAG,
			STATE_ATTR_NAME,
			STATE_ATTR_VAL,
			STATE_TEXT,
			STATE_DOC_START,
			STATE_DOC_END,
			STATE_PI_TAG,
			STATE_PI_VAL,
			STATE_DEC_ATTR_NAME,
			STATE_COMMENT,
			STATE_CDATA, 
			STATE_DOCTYPE,
			STATE_END_COMMENT,
			STATE_END_PI
		}pState ;

		bool ns,is_ns;
		int VTDDepth;
		encoding_t encoding;
		int last_depth;
		int last_l1_index;
		int last_l2_index;
		int last_l3_index;

		int increment;
		bool BOM_detected;
		bool must_utf_8;
		int ch;
		int ch_temp;
		int offset;
		bool ws;
		int temp_offset;
		int length1, length2;
		int depth;

		int prev_offset;
		int rootIndex;
		UByte* XMLDoc; // byte buffer containing
		int docLen; // length of XML (can be a segment of XMLDoc)
		int bufLen; // length of XMLDoc (possibly bigger than docLen)

		// buffers
		FastLongBuffer *VTDBuffer;
		FastLongBuffer *l1Buffer;
		FastLongBuffer *l2Buffer;
		FastIntBuffer *l3Buffer;
		FastIntBuffer *nsBuffer1;
		FastLongBuffer *nsBuffer2;
		FastLongBuffer *nsBuffer3;
		Long currentElementRecord;

		bool br;//buffer reuse flag
		bool stateTransfered; // indicate whether VTDNav has received all LC and VTD buffers

		int endOffset;
		Long* tag_stack;
		Long* attr_name_array;
		int attr_count;
		Long* prefixed_attr_name_array;
		int* prefix_URL_array;
		int prefixed_attr_count;
		int anaLen;
		int panaLen;
		int docOffset;

		int  entityIdentifier();
		void printLineNumber();
		int getChar();
		bool skip4OtherEncoding(int ch1);
		int handleOtherEncoding();
		int handle_16le();
		int handle_16be();
		int handle_utf8(int temp);
		void matchISOEncoding();
		void matchCPEncoding();
		void matchWindowsEncoding();
		void matchUTFEncoding();
		bool skipUTF8(int temp,int ch);
		bool skip_16be(int ch);
		bool skip_16le(int ch);
		int getCharAfterSe();
		int getCharAfterS();
		bool skipChar(int ch);
		void writeVTD(int offset, int length, tokenType token_type, int depth);
		void finishUp();

		void decide_encoding();
		pState process_end_pi();
		pState process_end_comment();
		pState process_comment();
		pState process_doc_type();
		pState process_cdata();
		pState process_pi_val();
		pState process_pi_tag();
		pState process_dec_attr();
		//void throwInvalidEncodingException();
		pState process_start_doc();
		pState process_end_doc();
		pState process_qm_seen();
		pState process_ex_seen();
		//void addWhiteSpaceRecord();
		void addWhiteSpaceRecord();
		void qualifyAttributes();
		void qualifyElement();
		bool matchXML(int byte_offset);
		bool matchURL(int bos1, int len1, int bos2, int len2);
		int identifyNsURL(int byte_offset, int length);
		int getCharUnit(int byte_offset);
		void disallow_xmlns(int byte_offset);
		void checkQualifiedAttributeUniqueness();
		bool checkPrefix(int os, int len);
		bool checkPrefix2(int os, int len);
		void checkAttributeUniqueness();
		Long _getCharResolved(int byte_offset);
		Long _getChar(int byte_offset);
		int decode(int byte_offset);
		Long _handle_16be(int byte_offset);
		Long _handle_16le(int byte_offset);
		Long _handle_utf8(int c,int offset);
		Long _handleOtherEncoding(int byte_offset);
		void handleOtherTextChar2(int ch);
		void handleOtherTextChar(int ch);


		int getPrevOffset();
		void throwInvalidEncodingException (){
			throw ParseException("Parse exception in parse()\n"\
				"XML decl error: Invalid Encoding");
		}


	public:


		/*writeIndex writes VTD+XML into a file
		This function throws index_write_exception*/


		const static int ATTR_NAME_ARRAY_SIZE= 16;
		const static int TAG_STACK_SIZE= 256;
		const static int MAX_DEPTH= 254;
		const static int MAX_TOKEN_LENGTH=((1<<20)-1);
		const static int MAX_PREFIX_LENGTH=((1<<9)-1);
		const static int MAX_QNAME_LENGTH=((1<<11)-1);

		VTDGen();
		virtual ~VTDGen();
		// clear the internal state of VTDGen so it can process 
		// the next XML file
		void clear();
		// Returns the VTDNav object after parsing, it also cleans 
		// internal state so VTDGen can process the next file.
		VTDNav *getNav();

		UByte *getXML(){ return XMLDoc;}
		// Generating VTD tokens and Location cache info.
		// One specifies whether the parsing is namespace aware or not.
		void parse(bool ns);
		// Generating VTD tokens and Location cache info for an XML file

		bool parseFile(bool ns, char* fileName);
		// Set the XMLDoc container.
		void setDoc(UByte *byteArray, int arrayLen);
		// Set the XMLDoc container.Also set the offset and len of the document 

		void setDoc(char *charArray, int arrayLen){
			setDoc((UByte*) charArray, arrayLen);
		}
		void setDoc(UByte *byteArray, int arrayLen, int offset, int docLen);
		void setDoc(char *charArray, int arrayLen, int offset, int docLen){
			setDoc((UByte *)charArray, arrayLen, offset, docLen);
		}
		// set the XML Doc container and turn on buffer reuse

		void setDoc_BR(UByte *byteArray, int arrayLen);
		//Set the XMLDoc container.Also set the offset and len of the document 
		void setDoc_BR(char *charArray, int arrayLen){
			setDoc_BR((UByte*) charArray, arrayLen);
		}

		void setDoc_BR(UByte *byteArray, int arrayLen, int offset, int docLen);
		void setDoc_BR(char *charArray, int arrayLen, int offset, int docLen){
			setDoc_BR((UByte*) charArray, arrayLen, offset, docLen);
		}
		/* Load VTD+XML from a FILE pointer */
		VTDNav* loadIndex(FILE *f); 
		/* load VTD+XML from a byte array */
		VTDNav* loadIndex(UByte* ba,int len);
		/* Write VTD+XML into a FILE pointer */

		bool writeIndex(FILE *f); 
		/* Write VTD+XML into a file of given name, this file will be created on hard disk */

		bool writeIndex(char *fileName);
		/* Pre-calculate the integrated VTD+XML index size without generating the actual index */

		Long getIndexSize();
		/* Write the VTDs and LCs into an file*/

		void writeSeparateIndex(char *vtdIndexFile);
		/* Load the separate VTD index and XmL file.*/

		VTDNav* loadSeparateIndex(char *XMLFile, char *VTDIndexFile);
		/* configure the VTDGen to enable or disable (disabled by default) white space nodes */

		void enableIgnoredWhiteSpace(bool b);

	};

	inline void VTDGen::enableIgnoredWhiteSpace( bool b){
		ws = b;
	}

	inline int VTDGen::getChar(){
		int temp = 0;
		if (offset >= endOffset){
			throw EOFException(
				"Parse exception in getChar \n"\
				"Premature EOF reached, XML document incomplete");			
		}
		switch (encoding) {
			case FORMAT_ASCII :
				temp = XMLDoc[offset];
				offset++;
				return temp;
			case FORMAT_ISO_8859_1 :
				temp = XMLDoc[offset];
				offset++;
				return temp;
			case FORMAT_UTF8 :

				temp = XMLDoc[offset];
				if (temp <128) {
					offset++;
					return temp;
				}
				//temp = temp & 0xff;
				return handle_utf8(temp);


			case FORMAT_UTF_16BE :
				// implement UTF-16BE to UCS4 conversion
				return handle_16be();

			case FORMAT_UTF_16LE :
				return handle_16le();


			default :
				return handleOtherEncoding();
		}


		//done

	}
	inline int VTDGen::getCharAfterS(){
		int n, k;
		n = k = 0;
		do{
			n = getChar();
			if (n == ' ' || n == '\n' || n == '\t' || n == '\r') {
			} else
				return n;
			n = getChar();
			if (n == ' ' || n == '\n' || n == '\t' || n == '\r') {
			} else
				return n;
		}while (true);
	}
	//done
	inline bool VTDGen::skipChar(int ch){
		int temp = 0;
		if (offset >= endOffset){
			throw ParseException(
				"Parse exception in parse() \n"\
				"Premature EOF reached, XML document incomplete");
		}	
		switch (encoding) {
			case FORMAT_ASCII :
				temp = XMLDoc[offset];
				if (temp>127){
					throw ParseException(
						"Parse exception in parse() \n"\
						"Invalid char for ASCII encoding");
				}
				if (ch == temp) {
					offset++;
					return true;
				} else {
					return false;
				}
			case FORMAT_ISO_8859_1 :
				temp = XMLDoc[offset];
				if (temp == ch) {
					offset++;
					return true;
				} else {
					return false;
				}
			case FORMAT_UTF8 :
				temp = XMLDoc[offset];
				if (temp <128) {
					if (ch == temp) {
						offset++;
						return true;
					} else {
						return false;
					}
				}
				return skipUTF8(temp,ch);

			case FORMAT_UTF_16BE :
				return skip_16be(ch);

			case FORMAT_UTF_16LE :
				return skip_16le(ch);

			default :
				return skip4OtherEncoding(ch);
		}
	}

}

#endif
