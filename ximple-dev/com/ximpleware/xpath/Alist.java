/* 
 * Copyright (C) 2002-2015 XimpleWare, info@ximpleware.com
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
/*All licenses to any parties in litigation with XimpleWare have been expressly terminated. No new license, and no renewal of any revoked license, 
 * is granted to those parties as a result of re-downloading software from this or any other website*/
package com.ximpleware.xpath;
import com.ximpleware.*;
/**
 * 
 * This class implements the argumentList for FuncExpr
 * which is basically a linked-list of expressions
 */
public class Alist {

	public Expr e;
	public Alist next;
	public Alist (){
		next = null;
	}
	final public String toString(){
		Alist temp = this;
		String s = "";
		while(temp!=null){
			s = s+temp.e;
			temp = temp.next;
			if (temp!=null)
				s = s+" ,";
		}
		return s;
	}

	final public void reset(VTDNav vn){
		Alist temp = this;
		while(temp!=null){
			temp.e.reset(vn);
			temp = temp.next;
		}
	}
	
}
