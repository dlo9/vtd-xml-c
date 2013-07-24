/* 
 * Copyright (C) 2002-2013 XimpleWare, info@ximpleware.com
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
/*VTD-XML is protected by US patent 7133857, 7260652, an 7761459*/
package com.ximpleware.extended;
/**
 * This exception is thrown when an error occured during
 * the construction of XPathExpr.
 * It is adapted to support extended VTD (256 max file size) 
 *
 */
public class XPathParseExceptionHuge extends VTDExceptionHuge{
	public XPathParseExceptionHuge(String s){
		super(s);
	}
	int offset;
	public XPathParseExceptionHuge(String s, int i){
		super(s);
		offset = i;
	}
	public int getOffset(){
		return offset;
	}
}

