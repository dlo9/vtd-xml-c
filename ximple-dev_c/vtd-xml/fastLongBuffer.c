/* 
 * Copyright (C) 2002-2004 XimpleWare, info@ximpleware.com
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
#include "fastLongBuffer.h"

// create FastLongBuffer with default page size of 1024 longs 
FastLongBuffer *createFastLongBuffer(){
	exception e;
	FastLongBuffer *flb = NULL;
	ArrayList *al= createArrayList();
	if (al==NULL) {
		e.et = out_of_mem;
		e.msg = "FastLongBuffer allocation failed ";
		Throw e;
	}

	flb = (FastLongBuffer *)malloc(sizeof(FastLongBuffer));
	if (flb==NULL) {
		freeArrayList(al); 
		e.et = out_of_mem;
		e.msg = "FastLongBuffer allocation failed ";
		Throw e;	
	}

	flb->size = 0;
	flb->capacity = 0;
	flb->pageSize = 1<<10;
	flb->exp = 10;
	flb->r = 1023;
	flb->al = al;

	return flb;
}
// create FastLongBuffer with page size of (1<<e) longs
FastLongBuffer *createFastLongBuffer2(int exp){
	exception e;
	FastLongBuffer *flb = NULL;
	ArrayList *al= createArrayList();
	if (al==NULL){
		e.et = out_of_mem;
		e.msg = "FastLongBuffer allocation failed ";
		Throw e;
	}

	flb = (FastLongBuffer *)malloc(sizeof(FastLongBuffer));
	if (flb==NULL) {
		freeArrayList(al); 
		e.et = out_of_mem;
		e.msg = "FastLongBuffer allocation failed ";
		Throw e;
	}

	flb->size = 0;
	flb->capacity = 0;
	flb->pageSize = 1<<exp;
	flb->exp = exp;
	flb->r = (1<<exp)-1;
	flb->al = al;

	return flb;
}
// create FastLongBuffer with page size of (1<<e) longs and initial capciaty of c longs
FastLongBuffer *createFastLongBuffer3(int exp, int c){
	exception e;
	FastLongBuffer *flb = NULL;
	ArrayList *al= createArrayList(c);
	if (al==NULL){
		e.et = out_of_mem;
		e.msg = "FastLongBuffer allocation failed ";
		Throw e;
	}

	flb = (FastLongBuffer *)malloc(sizeof(FastLongBuffer));
	if (flb==NULL) {
		free(al); 
		e.et = out_of_mem;
		e.msg = "FastLongBuffer allocation failed ";
		Throw e;
	}

	flb->size = 0;
	flb->capacity = 0;
	flb->pageSize = 1<<exp;
	flb->exp = exp;
	flb->r = (1<<exp)-1;
	flb->al = al;

	return flb;
}
// free FastLongBuffer 
void freeFastLongBuffer(FastLongBuffer *flb){
	if (flb != NULL) 
		freeArrayList(flb->al);
	free(flb);
}
// append a long array to the end of FastLongBuffer
void appendLongArray(FastLongBuffer *flb, Long *longArray, int len){
	exception e;
	Long *lastBuffer = NULL;
	

	if (longArray == NULL || len <0) {
		e.et = invalid_argument;
		e.msg = "invalid argument for appendLongArray /n";
		Throw e;
        //throw new NullPointerException();
    }
    // no additional buffer space needed

    //long[] lastBuffer;
    /*if (bufferArrayList.size() == 0) {
        lastBuffer = new long[pageSize];
        bufferArrayList.add(lastBuffer);
        capacity = pageSize;
    } else {
        lastBuffer = (long[]) bufferArrayList.get(bufferArrayList.size() - 1);
    }*/
	if (flb->al->size == 0)
	{
		lastBuffer = (Long *) malloc(sizeof(Long)<< flb->exp);
		if (lastBuffer == NULL){
			e.et = out_of_mem;
			e.msg = " appendLongArray failed to allocate mem ";
			Throw e;
		}
	}else {
		lastBuffer = (Long *)get(flb->al, flb->al->size -1);
	}


    //if ((this.size + long_array.length) < this.capacity) {
	if ((flb->size + len)< flb->capacity){
        //get the last buffer from the bufferListArray
        //obtain the starting offset in that buffer to which the data is to be copied
        //update length

        /*System.arraycopy(
            long_array,
            0,
            lastBuffer,
			// size % pageSize,
            size& r,
            long_array.length); */
		memcpy(lastBuffer + (flb->size & flb->r),
			longArray,
			len << 3);
        flb->size += len;
    } else // new buffers needed
        {
		int i;
		Long *newBuffer = NULL;
        // compute the number of additional buffers needed
//        int n =
//            ((int) ((long_array.length + size) / pageSize))
//                + (((long_array.length + size) % pageSize) > 0 ? 1 : 0)
//                - (int) (capacity / pageSize);
    	/*int n = ((long_array.length + size) >> exp)
                + (((long_array.length + size)&r) > 0 ? 1 : 0)
                -  (capacity >> exp);*/

		int n = ((len + flb->size) >> flb->exp) 
			+(((len + flb->size) & flb->r)> 0 ? 1 : 0)
			- (flb->capacity >>flb->exp);
        // create these buffers
        // add to bufferArrayList
        //System.arraycopy(long_array, 0, lastBuffer, size % pageSize, capacity - size);
        //System.arraycopy(long_array, 0, lastBuffer, size & r, capacity - size);
		memcpy(lastBuffer + (flb->size & flb->r),
			longArray,
			(flb->capacity - flb->size)<<3);

        for (i = 0; i < n; i++) {
            //long[] newBuffer = new long[pageSize];
			newBuffer = (Long *)malloc(sizeof(Long)<<flb->exp);
			if (newBuffer == NULL){
				e.et = out_of_mem;
				e.msg = " appendLongArray failed to allocate mem ";
				Throw e;
			}
            if (i < n - 1) {
                // full copy 
                /*System.arraycopy(
                    long_array,
                    pageSize * i + capacity - size,
                    newBuffer,
                    0,
                    pageSize);*/
				memcpy( newBuffer,
					longArray + (i<<flb->exp) + flb->capacity - flb->size,
					flb->pageSize << 3);

            } else {
                // last page
                /*System.arraycopy(
                    long_array,
                    pageSize * i + capacity - size,
                    newBuffer,
                    0,
                    long_array.length+ size - pageSize*i - capacity);*/
				memcpy(newBuffer,
					longArray + (i<<flb->exp) + flb->capacity - flb->size,
					(len + flb->size - (i<< flb->exp) - flb->capacity)<<3);
            }
            //bufferArrayList.add(newBuffer);
			add(flb->al,newBuffer);
        }
        // update length
        //size += long_array.length;
		flb->size += len;
        // update capacity
        //capacity += n * pageSize;
		flb->capacity += (n << flb->exp);
        // update
    }
}

// append a long to the end of FastLongBuffer
void appendLong(FastLongBuffer *flb, Long i){
	exception e;
	//long[] lastBuffer;
	Long *lastBuffer = NULL;

	/*if (bufferArrayList.size() == 0) {
        lastBuffer = new long[pageSize];
        bufferArrayList.add(lastBuffer);
        capacity = pageSize;
    } else {
        lastBuffer = (long[]) bufferArrayList.get(bufferArrayList.size() - 1);
    }*/

	if (flb->al->size == 0) {
		lastBuffer = (Long *)malloc(sizeof(Long)<<flb->exp);
		if (lastBuffer == NULL){
			e.et = out_of_mem;
			e.msg = "AppendLong failed to allocate mem";
			Throw e;
		}
		add(flb->al,lastBuffer);
		flb->capacity = flb->pageSize;
	}else{
		lastBuffer = (Long *)get(flb->al, flb->al->size -1);
	}
    /*if ((this.size + 1) <= this.capacity) {
        //get the last buffer from the bufferListArray
        //obtain the starting offset in that buffer to which the data is to be copied
        //update length
        //System.arraycopy(long_array, 0, lastBuffer, size % pageSize, long_array.length);
        //lastBuffer[size % pageSize] = i;
        lastBuffer[size & r] = i;
        size += 1;
    } else // new buffers needed
        {
        long[] newBuffer = new long[pageSize];
        size++;
        capacity += pageSize;
        bufferArrayList.add(newBuffer);
        newBuffer[0] = i;
    }*/
	if (flb->size < flb->capacity){
		lastBuffer[flb->size & flb->r] = i;
		flb->size ++;
	}else {
		Long *newBuffer = (Long *)malloc(sizeof(Long)<<flb->exp);
		if (newBuffer == NULL){
			e.et = out_of_mem;
			e.msg = "AppendLong failed to allocate mem";
			Throw e;
		}
		
		flb->size ++;
		flb->capacity += flb->pageSize;
		add(flb->al, newBuffer);
		newBuffer[0]=i;
	}
}


// get the capacity of FastLongBuffer
/*int getCapacityFLB(FastLongBuffer *flb){
	return flb->capacity;
}*/


// Return a selected chuck of long buffer as a long array.
Long *getLongArray(FastLongBuffer *flb, int offset, int len){
	exception e;
	Long *result = NULL;
	int first_index, last_index;
	if (flb->size <= 0 
		|| offset < 0 
		|| len <0 
		|| offset + len > flb->size) {
			e.et  = invalid_argument;
			e.msg = "Invalid argument for getLongArray in FastLongBuffer";
			Throw e;
		}
    /*if ((startingOffset + len) > size()) {
        throw (new IndexOutOfBoundsException());
    }*/

    //long[] result = new long[len]; // allocate result array
	result = (Long *)malloc(sizeof(Long)*len);

	if (result == NULL){
		e.et = out_of_mem;
		e.msg = " getLongArray failed to allocate mem in FastLongBuffer";
		Throw e;
	}
    //int first_index =  (startingOffset >> exp);
    //int last_index = ((startingOffset + len) >>exp);

	first_index = offset >> flb->exp;
	last_index = (offset+len) >> flb->exp;

    //if ((startingOffset + len) % pageSize == 0) {
    //if (((startingOffset + len) & r) == 0) {
    //   last_index--;
    //}

	if (((offset + len) & flb->r)== 0){
		last_index--;
	}

    if (first_index == last_index) {
        // to see if there is a need to go across buffer boundry
        /*System.arraycopy(
            (long[]) (bufferArrayList.get(first_index)),
//            startingOffset % pageSize,
			startingOffset & r,
            result,
            0,
            len);*/
		memcpy(result, 
			(Long *)get(flb->al, first_index) + (offset & flb->r),
			len <<3);
    } else {
        int long_array_offset = 0;
		int i;
		Long *currentChunk;
        for (i = first_index; i <= last_index; i++) {
            //long[] currentChunk = (long[]) bufferArrayList.get(i);
			currentChunk = (Long *)get(flb->al, i);
            if (i == first_index) // first section
                {
                /*System.arraycopy(
                    currentChunk,
//                  startingOffset % pageSize,
        			startingOffset & r,
                    result,
                    0,
//                  pageSize - (startingOffset % r));
					pageSize - (startingOffset & r)); */
				memcpy(result,
					currentChunk + (offset & flb->r),
					(flb->pageSize - (offset& flb->r))<<3);
                //long_array_offset += pageSize - (startingOffset & r);
				long_array_offset += flb->pageSize - (offset & flb->r);
            } else if (i == last_index) // last sections
                {
                /*System.arraycopy(
                    currentChunk,
                    0,
                    result,
                    long_array_offset,
                    len - long_array_offset);*/
				memcpy(result + long_array_offset,
					currentChunk,
					(len - long_array_offset) <<3);


            } else {
                //System.arraycopy(currentChunk, 0, result, long_array_offset, pageSize);
                memcpy( result + long_array_offset,
					currentChunk,
					flb->pageSize <<3 );
				//long_array_offset += pageSize;
				long_array_offset += flb->pageSize;
            }
		}
	}
		return result;
}




// get the page size of FastLongBuffer
// changed in macro
/*int getPageSizeFLB(FastLongBuffer *flb){
	return flb->pageSize;
}*/


// get the long at the index position from FastLongBuffer
// inlined in .h
/*Long longAt(FastLongBuffer *flb, int index){
	int pageNum = (index >>flb->exp);
    // int offset = index % r;
    int offset = index & flb->r;
    //return ((Long[]) bufferArrayList.get(pageNum))[offset];
	return ((Long *)get(flb->al,pageNum))[offset];
}*/


// get the lower 32 bits from the index position from FastLongBuffer
// inlined in .h
/*int lower32At(FastLongBuffer *flb, int index){
	exception e;
	int pageNum,offset;
    if (index < 0 || index > flb->size) {
		e.et = invalid_argument;
		e.msg = " invalid index range";
        //throw new IndexOutOfBoundsException();
		Throw e;
    }
    pageNum =  (index >> flb->exp);
    // int offset = index % pageSize;
    offset = index & flb->r;
    //return (int) ((Long[]) bufferArrayList.get(pageNum))[offset];
	return (int)((Long *)get(flb->al,pageNum))[offset];
//	return 0;
}*/


// get the upper 32 bits from the index position from FastLongBuffer 
// inlined in .h
/*int upper32At(FastLongBuffer *flb, int index){
	exception e;
	int pageNum, offset;
    if (index < 0 || index > flb->size) {
		e.et = invalid_argument;
		e.msg = " invalid index range";
        //throw new IndexOutOfBoundsException();
		Throw e;
    }
    pageNum = (index >>flb->exp);
    offset = index & flb->r;
    //return (int)
    //    ((((long[]) bufferArrayList.get(pageNum))[offset] & (0xffffffffL << 32)) >> 32);
	return (int) ((((Long *)get(flb->al,pageNum))[offset] & (0xffffffffL<<32))>>32);
//	return 0;
}*/

// replace the entry at the index position of FastLongBuffer with l
// inlined in .h
/*void modifyEntryFLB(FastLongBuffer *flb, int index, Long l){
	exception e;
	//int pageNum, offset;
    if (index < 0 || index > flb->size) {
		e.et = invalid_argument;
		e.msg = " invalid index range";
        //throw new IndexOutOfBoundsException();
		Throw e;
    }
    //((long[]) bufferArrayList.get((int) (index / pageSize)))[index % pageSize] =
    //((long[]) bufferArrayList.get(index >> exp))[index & r] = l;
	((Long *)get(flb->al,index>>flb->exp))[index & flb->r] = l;
}*/


// convert FastLongBuffer into a Long array 
Long* toLongArray(FastLongBuffer *flb){
	exception e;
	Long *resultArray = NULL;
	int i;
    if (flb->size > 0) {
	// if (size()>0) {
        //long[] resultArray = new long[size];
		int k;
        int array_offset = 0;
		resultArray = (Long *)malloc(sizeof(Long)*flb->size);
		if (resultArray == NULL){
			e.et = out_of_mem;
			e.msg = "toLongArray failed to allocate mem";
			Throw e;
		}
        //copy all the content int into the resultArray

		k = flb->al->size;
        //for (i = 0; i < bufferArrayList.size(); i++) {
		for (i=0; i< k;i++){
            /*System.arraycopy(
                (int[]) bufferArrayList.get(i),
                0,
                resultArray,
                array_offset,
                //(i == (bufferArrayList.size() - 1)) ? size - ((size>>exp)<<exp) : pageSize);
                (i == (bufferArrayList.size() - 1)) ? (size & r) : pageSize); */
			memcpy(resultArray + array_offset,
				(Long *)get(flb->al, i),
				((i == (flb->al->size - 1) ) ? ( flb->size & flb->r) : flb->pageSize )<<3); 
            array_offset += flb->pageSize;
        }
        return resultArray;
    }
    return NULL;
}