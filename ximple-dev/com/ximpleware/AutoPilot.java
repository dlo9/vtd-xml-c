package com.ximpleware;

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
/**
 * XimpleWare's AutoPilot implementation.
 * Currently it emulates the behavior of DOM's document-order node iterator.
 * When the element name is specified, an instance of this class automatically
 * moves the cursor across element nodes that satify the criteria (e.g. specified name).
 * Creation date: (11/24/03 2:36:21 PM)
 * 
 */
public class AutoPilot {
    private int depth;
    // the depth of the element at the starting point will determine when to stop iteration
    private int iter_type; // see selectElement
    private VTDNav vn; // the navigator object
    private int startIndex;
    private boolean ft; // a helper variable for 

    private String elementName; // Store element name after selectElement
    private String localName; // Store local name after selectElemntNS
    private String URL; // Store URL name after selectElementNS
    // defines the type of "iteration"
    protected final static int UNDEFINED = 0;
    // set the mode corresponding to DOM's getElemetnbyName(string)
    protected final static int SIMPLE = 1;
    // set the mode corresponding to DOM's getElementbyNameNS(string)
    protected final static int SIMPLE_NS = 2;
/**
 * AutoPilot constructor comment.
 * @exception IllegalArgumentException If the VTDNav object is null 
 */
public AutoPilot(VTDNav v) {
    if (v == null)
        throw new IllegalArgumentException(" instance of VTDNav can't be null ");
    elementName = null;
    vn = v;
    //depth = v.getCurrentDepth();
    iter_type = UNDEFINED; // not defined
    ft = true;
}
/**
 * Iterate over all the selected element nodes.
 * Creation date: (12/4/03 5:25:42 PM)
 * @return boolean
 * @exception com.ximpleware.NavException See description in method toElement() in VTDNav class.
 */
public boolean iterate() throws PilotException, NavException {
    switch (iter_type) {
        case SIMPLE :
            if (elementName == null)
                throw new PilotException(" Element name not set ");
            if (ft == false)
                return vn.iterate(depth, elementName);
            else {
                if (vn.matchElement(elementName)) {
                    ft = false;
                    return true;
                } else
                    return vn.iterate(depth, elementName);
            }
        case SIMPLE_NS :
            if (localName == null) //|| URL == null)
                throw new PilotException(" URL or Localname not set properly");

            if (ft == false)
                return vn.iterateNS(depth, URL, localName);
            else {
                if (vn.matchElementNS(URL, localName)) {
                    ft = false;
                    return true;
                } else
                    return vn.iterateNS(depth, URL, localName);
            }
        default :
            throw new PilotException(" iteration action type undefined");
    }
}
/**
 * Select the element name before iterating.
 * "*" matches every element
 * Creation date: (12/4/03 5:51:31 PM)
 * @param en java.lang.String
 */
	public void selectElement(String en) {
		iter_type = SIMPLE;
		depth = vn.getCurrentDepth();
		startIndex = vn.getCurrentIndex();
		elementName = en;
		ft = true;
	}
/**
 * Select the element name (name space version) before iterating. URL, if set to *,
 * matches every namespace URL, if set to null, indicates the namespace is
 * undefined. localname, if set to *, matches any localname Creation date:
 * (12/4/03 6:05:19 PM)
 * 
 * @param URL
 *            java.lang.String
 * @param ln
 *            java.lang.String
 */
public void selectElementNS(String ns_URL, String ln) {
    iter_type = SIMPLE_NS;
    depth = vn.getCurrentDepth();
    startIndex = vn.getCurrentIndex();
    localName = ln;
    URL = ns_URL;
    ft = true;
}
}
