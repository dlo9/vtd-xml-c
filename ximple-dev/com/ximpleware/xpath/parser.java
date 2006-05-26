/* 
 * Copyright (C) 2002-2006 XimpleWare, info@ximpleware.com
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

package com.ximpleware.xpath;

import java_cup.runtime.*;
import com.ximpleware.*;
import java.util.*;

/** CUP v0.10k generated parser.
  * @version Sat May 20 17:05:38 PDT 2006
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\102\000\002\006\003\000\002\002\004\000\002\007" +
    "\003\000\002\007\005\000\002\011\003\000\002\011\005" +
    "\000\002\010\003\000\002\010\005\000\002\010\005\000" +
    "\002\012\003\000\002\012\005\000\002\012\005\000\002" +
    "\012\005\000\002\012\005\000\002\013\003\000\002\013" +
    "\005\000\002\013\005\000\002\014\003\000\002\014\005" +
    "\000\002\014\005\000\002\014\005\000\002\015\003\000" +
    "\002\015\004\000\002\020\003\000\002\020\005\000\002" +
    "\016\003\000\002\016\003\000\002\016\005\000\002\016" +
    "\005\000\002\017\003\000\002\017\004\000\002\022\003" +
    "\000\002\022\005\000\002\022\003\000\002\022\003\000" +
    "\002\022\003\000\002\004\006\000\002\021\002\000\002" +
    "\021\003\000\002\021\005\000\002\023\003\000\002\024" +
    "\003\000\002\024\003\000\002\033\003\000\002\033\004" +
    "\000\002\033\003\000\002\032\003\000\002\032\005\000" +
    "\002\032\003\000\002\030\005\000\002\030\003\000\002" +
    "\027\003\000\002\027\003\000\002\037\002\000\002\037" +
    "\004\000\002\025\003\000\002\025\003\000\002\026\002" +
    "\000\002\026\003\000\002\031\003\000\002\031\003\000" +
    "\002\034\004\000\002\035\005\000\002\036\005\000\002" +
    "\003\004\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\141\000\036\005\045\006\021\007\017\010\042\012" +
    "\016\025\004\026\006\035\037\036\032\037\036\040\024" +
    "\041\uffc8\042\uffc8\043\043\001\002\000\062\002\uffd6\004" +
    "\uffd6\005\uffd6\006\021\007\017\010\042\011\uffd6\013\uffd6" +
    "\015\uffd6\016\uffd6\017\uffd6\020\uffd6\021\uffd6\022\uffd6\023" +
    "\uffd6\024\uffd6\027\uffd6\030\uffd6\031\uffd6\032\uffd6\033\uffd6" +
    "\041\uffc8\042\uffc8\043\043\001\002\000\032\002\ufffb\011" +
    "\ufffb\013\ufffb\015\ufffb\016\120\017\117\020\122\021\121" +
    "\022\ufffb\023\ufffb\031\ufffb\032\ufffb\001\002\000\016\006" +
    "\021\007\017\010\042\041\uffc8\042\uffc8\043\043\001\002" +
    "\000\046\002\uffd4\004\uffd4\005\uffd4\011\uffd4\013\uffd4\015" +
    "\uffd4\016\uffd4\017\uffd4\020\uffd4\021\uffd4\022\uffd4\023\uffd4" +
    "\024\uffd4\027\uffd4\030\uffd4\031\uffd4\032\uffd4\033\uffd4\001" +
    "\002\000\054\002\uffde\004\uffde\005\uffde\011\uffde\013\uffde" +
    "\014\uffde\015\uffde\016\uffde\017\uffde\020\uffde\021\uffde\022" +
    "\uffde\023\uffde\024\uffde\025\uffde\026\uffde\027\uffde\030\uffde" +
    "\031\uffde\032\uffde\033\uffde\001\002\000\016\002\uffff\011" +
    "\uffff\013\uffff\015\uffff\031\132\032\uffff\001\002\000\006" +
    "\041\136\042\134\001\002\000\006\041\uffc9\042\uffc9\001" +
    "\002\000\014\002\001\011\001\013\001\015\001\032\130" +
    "\001\002\000\022\002\ufffd\011\ufffd\013\ufffd\015\ufffd\022" +
    "\114\023\115\031\ufffd\032\ufffd\001\002\000\036\005\045" +
    "\006\021\007\017\010\042\012\016\025\004\026\006\035" +
    "\037\036\032\037\036\040\024\041\uffc8\042\uffc8\043\043" +
    "\001\002\000\052\002\uffc5\004\uffc5\005\uffc5\011\uffc5\013" +
    "\uffc5\015\uffc5\016\uffc5\017\uffc5\020\uffc5\021\uffc5\022\uffc5" +
    "\023\uffc5\024\uffc5\025\uffc5\026\uffc5\027\uffc5\030\uffc5\031" +
    "\uffc5\032\uffc5\033\uffc5\001\002\000\046\002\uffd7\004\uffd7" +
    "\005\uffd7\011\uffd7\013\uffd7\015\uffd7\016\uffd7\017\uffd7\020" +
    "\uffd7\021\uffd7\022\uffd7\023\uffd7\024\uffd7\027\uffd7\030\uffd7" +
    "\031\uffd7\032\uffd7\033\uffd7\001\002\000\052\002\uffc6\004" +
    "\uffc6\005\uffc6\011\uffc6\013\uffc6\015\uffc6\016\uffc6\017\uffc6" +
    "\020\uffc6\021\uffc6\022\uffc6\023\uffc6\024\uffc6\025\uffc6\026" +
    "\uffc6\027\uffc6\030\uffc6\031\uffc6\032\uffc6\033\uffc6\001\002" +
    "\000\036\002\ufff8\004\107\005\106\011\ufff8\013\ufff8\015" +
    "\ufff8\016\ufff8\017\ufff8\020\ufff8\021\ufff8\022\ufff8\023\ufff8" +
    "\031\ufff8\032\ufff8\001\002\000\044\002\ufff0\004\ufff0\005" +
    "\ufff0\011\ufff0\013\ufff0\015\ufff0\016\ufff0\017\ufff0\020\ufff0" +
    "\021\ufff0\022\ufff0\023\ufff0\024\ufff0\027\ufff0\030\ufff0\031" +
    "\ufff0\032\ufff0\001\002\000\004\012\uffc0\001\002\000\004" +
    "\012\077\001\002\000\052\002\uffd3\004\uffd3\005\uffd3\011" +
    "\uffd3\013\uffd3\015\uffd3\016\uffd3\017\uffd3\020\uffd3\021\uffd3" +
    "\022\uffd3\023\uffd3\024\uffd3\025\074\026\073\027\uffd3\030" +
    "\uffd3\031\uffd3\032\uffd3\033\uffd3\001\002\000\046\002\uffe8" +
    "\004\uffe8\005\uffe8\011\uffe8\013\uffe8\015\uffe8\016\uffe8\017" +
    "\uffe8\020\uffe8\021\uffe8\022\uffe8\023\uffe8\024\uffe8\027\uffe8" +
    "\030\uffe8\031\uffe8\032\uffe8\033\uffe8\001\002\000\054\002" +
    "\uffe4\004\uffe4\005\uffe4\011\uffe4\013\uffe4\014\uffe4\015\uffe4" +
    "\016\uffe4\017\uffe4\020\uffe4\021\uffe4\022\uffe4\023\uffe4\024" +
    "\uffe4\025\uffe4\026\uffe4\027\uffe4\030\uffe4\031\uffe4\032\uffe4" +
    "\033\uffe4\001\002\000\046\002\uffea\004\uffea\005\uffea\011" +
    "\uffea\013\uffea\015\uffea\016\uffea\017\uffea\020\uffea\021\uffea" +
    "\022\uffea\023\uffea\024\uffea\027\uffea\030\uffea\031\uffea\032" +
    "\uffea\033\071\001\002\000\054\002\uffdf\004\uffdf\005\uffdf" +
    "\011\uffdf\013\uffdf\014\uffdf\015\uffdf\016\uffdf\017\uffdf\020" +
    "\uffdf\021\uffdf\022\uffdf\023\uffdf\024\uffdf\025\uffdf\026\uffdf" +
    "\027\uffdf\030\uffdf\031\uffdf\032\uffdf\033\uffdf\001\002\000" +
    "\054\002\uffe2\004\uffe2\005\uffe2\011\uffe2\013\uffe2\014\uffe2" +
    "\015\uffe2\016\uffe2\017\uffe2\020\uffe2\021\uffe2\022\uffe2\023" +
    "\uffe2\024\uffe2\025\uffe2\026\uffe2\027\uffe2\030\uffe2\031\uffe2" +
    "\032\uffe2\033\uffe2\001\002\000\054\002\uffe7\004\uffe7\005" +
    "\uffe7\011\uffe7\013\uffe7\014\064\015\uffe7\016\uffe7\017\uffe7" +
    "\020\uffe7\021\uffe7\022\uffe7\023\uffe7\024\uffe7\025\063\026" +
    "\062\027\uffe7\030\uffe7\031\uffe7\032\uffe7\033\uffe7\001\002" +
    "\000\004\002\060\001\002\000\054\002\uffe0\004\uffe0\005" +
    "\uffe0\011\uffe0\013\uffe0\014\uffe0\015\uffe0\016\uffe0\017\uffe0" +
    "\020\uffe0\021\uffe0\022\uffe0\023\uffe0\024\uffe0\025\uffe0\026" +
    "\uffe0\027\uffe0\030\uffe0\031\uffe0\032\uffe0\033\uffe0\001\002" +
    "\000\004\042\057\001\002\000\046\002\uffd1\004\uffd1\005" +
    "\uffd1\011\uffd1\013\uffd1\015\uffd1\016\uffd1\017\uffd1\020\uffd1" +
    "\021\uffd1\022\uffd1\023\uffd1\024\uffd1\027\uffd1\030\uffd1\031" +
    "\uffd1\032\uffd1\033\uffd1\001\002\000\052\002\uffcf\004\uffcf" +
    "\005\uffcf\011\uffcf\013\uffcf\015\uffcf\016\uffcf\017\uffcf\020" +
    "\uffcf\021\uffcf\022\uffcf\023\uffcf\024\uffcf\025\uffcf\026\uffcf" +
    "\027\uffcf\030\uffcf\031\uffcf\032\uffcf\033\uffcf\001\002\000" +
    "\006\041\uffc7\042\uffc7\001\002\000\006\041\uffca\042\uffca" +
    "\001\002\000\044\002\uffec\004\uffec\005\uffec\011\uffec\013" +
    "\uffec\015\uffec\016\uffec\017\uffec\020\uffec\021\uffec\022\uffec" +
    "\023\uffec\024\uffec\027\uffec\030\uffec\031\uffec\032\uffec\001" +
    "\002\000\036\005\045\006\021\007\017\010\042\012\016" +
    "\025\004\026\006\035\037\036\032\037\036\040\024\041" +
    "\uffc8\042\uffc8\043\043\001\002\000\044\002\ufff3\004\ufff3" +
    "\005\ufff3\011\ufff3\013\ufff3\015\ufff3\016\ufff3\017\ufff3\020" +
    "\ufff3\021\ufff3\022\ufff3\023\ufff3\024\051\027\052\030\050" +
    "\031\ufff3\032\ufff3\001\002\000\046\002\uffd8\004\uffd8\005" +
    "\uffd8\011\uffd8\013\uffd8\015\uffd8\016\uffd8\017\uffd8\020\uffd8" +
    "\021\uffd8\022\uffd8\023\uffd8\024\uffd8\027\uffd8\030\uffd8\031" +
    "\uffd8\032\uffd8\033\uffd8\001\002\000\036\005\045\006\021" +
    "\007\017\010\042\012\016\025\004\026\006\035\037\036" +
    "\032\037\036\040\024\041\uffc8\042\uffc8\043\043\001\002" +
    "\000\036\005\045\006\021\007\017\010\042\012\016\025" +
    "\004\026\006\035\037\036\032\037\036\040\024\041\uffc8" +
    "\042\uffc8\043\043\001\002\000\036\005\045\006\021\007" +
    "\017\010\042\012\016\025\004\026\006\035\037\036\032" +
    "\037\036\040\024\041\uffc8\042\uffc8\043\043\001\002\000" +
    "\044\002\uffee\004\uffee\005\uffee\011\uffee\013\uffee\015\uffee" +
    "\016\uffee\017\uffee\020\uffee\021\uffee\022\uffee\023\uffee\024" +
    "\uffee\027\uffee\030\uffee\031\uffee\032\uffee\001\002\000\044" +
    "\002\uffef\004\uffef\005\uffef\011\uffef\013\uffef\015\uffef\016" +
    "\uffef\017\uffef\020\uffef\021\uffef\022\uffef\023\uffef\024\uffef" +
    "\027\uffef\030\uffef\031\uffef\032\uffef\001\002\000\044\002" +
    "\uffed\004\uffed\005\uffed\011\uffed\013\uffed\015\uffed\016\uffed" +
    "\017\uffed\020\uffed\021\uffed\022\uffed\023\uffed\024\uffed\027" +
    "\uffed\030\uffed\031\uffed\032\uffed\001\002\000\044\002\uffeb" +
    "\004\uffeb\005\uffeb\011\uffeb\013\uffeb\015\uffeb\016\uffeb\017" +
    "\uffeb\020\uffeb\021\uffeb\022\uffeb\023\uffeb\024\uffeb\027\uffeb" +
    "\030\uffeb\031\uffeb\032\uffeb\001\002\000\054\002\uffc1\004" +
    "\uffc1\005\uffc1\011\uffc1\013\uffc1\014\uffc1\015\uffc1\016\uffc1" +
    "\017\uffc1\020\uffc1\021\uffc1\022\uffc1\023\uffc1\024\uffc1\025" +
    "\uffc1\026\uffc1\027\uffc1\030\uffc1\031\uffc1\032\uffc1\033\uffc1" +
    "\001\002\000\004\002\000\001\002\000\054\002\uffe3\004" +
    "\uffe3\005\uffe3\011\uffe3\013\uffe3\014\uffe3\015\uffe3\016\uffe3" +
    "\017\uffe3\020\uffe3\021\uffe3\022\uffe3\023\uffe3\024\uffe3\025" +
    "\uffe3\026\uffe3\027\uffe3\030\uffe3\031\uffe3\032\uffe3\033\uffe3" +
    "\001\002\000\016\006\021\007\017\010\042\041\uffc8\042" +
    "\uffc8\043\043\001\002\000\016\006\021\007\017\010\042" +
    "\041\uffc8\042\uffc8\043\043\001\002\000\036\005\045\006" +
    "\021\007\017\010\042\012\016\025\004\026\006\035\037" +
    "\036\032\037\036\040\024\041\uffc8\042\uffc8\043\043\001" +
    "\002\000\004\015\066\001\002\000\054\002\uffc2\004\uffc2" +
    "\005\uffc2\011\uffc2\013\uffc2\014\uffc2\015\uffc2\016\uffc2\017" +
    "\uffc2\020\uffc2\021\uffc2\022\uffc2\023\uffc2\024\uffc2\025\uffc2" +
    "\026\uffc2\027\uffc2\030\uffc2\031\uffc2\032\uffc2\033\uffc2\001" +
    "\002\000\046\002\uffe6\004\uffe6\005\uffe6\011\uffe6\013\uffe6" +
    "\015\uffe6\016\uffe6\017\uffe6\020\uffe6\021\uffe6\022\uffe6\023" +
    "\uffe6\024\uffe6\027\uffe6\030\uffe6\031\uffe6\032\uffe6\033\uffe6" +
    "\001\002\000\046\002\uffe5\004\uffe5\005\uffe5\011\uffe5\013" +
    "\uffe5\015\uffe5\016\uffe5\017\uffe5\020\uffe5\021\uffe5\022\uffe5" +
    "\023\uffe5\024\uffe5\027\uffe5\030\uffe5\031\uffe5\032\uffe5\033" +
    "\uffe5\001\002\000\034\006\021\007\017\010\042\012\016" +
    "\025\004\026\006\035\037\036\032\037\036\040\024\041" +
    "\uffc8\042\uffc8\043\043\001\002\000\044\002\uffe9\004\uffe9" +
    "\005\uffe9\011\uffe9\013\uffe9\015\uffe9\016\uffe9\017\uffe9\020" +
    "\uffe9\021\uffe9\022\uffe9\023\uffe9\024\uffe9\027\uffe9\030\uffe9" +
    "\031\uffe9\032\uffe9\001\002\000\016\006\021\007\017\010" +
    "\042\041\uffc8\042\uffc8\043\043\001\002\000\016\006\021" +
    "\007\017\010\042\041\uffc8\042\uffc8\043\043\001\002\000" +
    "\046\002\uffd2\004\uffd2\005\uffd2\011\uffd2\013\uffd2\015\uffd2" +
    "\016\uffd2\017\uffd2\020\uffd2\021\uffd2\022\uffd2\023\uffd2\024" +
    "\uffd2\027\uffd2\030\uffd2\031\uffd2\032\uffd2\033\uffd2\001\002" +
    "\000\046\002\uffc3\004\uffc3\005\uffc3\011\uffc3\013\uffc3\015" +
    "\uffc3\016\uffc3\017\uffc3\020\uffc3\021\uffc3\022\uffc3\023\uffc3" +
    "\024\uffc3\027\uffc3\030\uffc3\031\uffc3\032\uffc3\033\uffc3\001" +
    "\002\000\040\005\045\006\021\007\017\010\042\012\016" +
    "\013\uffdc\025\004\026\006\035\037\036\032\037\036\040" +
    "\024\041\uffc8\042\uffc8\043\043\001\002\000\004\013\105" +
    "\001\002\000\006\011\103\013\uffdb\001\002\000\006\011" +
    "\uffd9\013\uffd9\001\002\000\040\005\045\006\021\007\017" +
    "\010\042\012\016\013\uffdc\025\004\026\006\035\037\036" +
    "\032\037\036\040\024\041\uffc8\042\uffc8\043\043\001\002" +
    "\000\004\013\uffda\001\002\000\054\002\uffdd\004\uffdd\005" +
    "\uffdd\011\uffdd\013\uffdd\014\uffdd\015\uffdd\016\uffdd\017\uffdd" +
    "\020\uffdd\021\uffdd\022\uffdd\023\uffdd\024\uffdd\025\uffdd\026" +
    "\uffdd\027\uffdd\030\uffdd\031\uffdd\032\uffdd\033\uffdd\001\002" +
    "\000\036\005\045\006\021\007\017\010\042\012\016\025" +
    "\004\026\006\035\037\036\032\037\036\040\024\041\uffc8" +
    "\042\uffc8\043\043\001\002\000\036\005\045\006\021\007" +
    "\017\010\042\012\016\025\004\026\006\035\037\036\032" +
    "\037\036\040\024\041\uffc8\042\uffc8\043\043\001\002\000" +
    "\044\002\ufff2\004\ufff2\005\ufff2\011\ufff2\013\ufff2\015\ufff2" +
    "\016\ufff2\017\ufff2\020\ufff2\021\ufff2\022\ufff2\023\ufff2\024" +
    "\051\027\052\030\050\031\ufff2\032\ufff2\001\002\000\044" +
    "\002\ufff1\004\ufff1\005\ufff1\011\ufff1\013\ufff1\015\ufff1\016" +
    "\ufff1\017\ufff1\020\ufff1\021\ufff1\022\ufff1\023\ufff1\024\051" +
    "\027\052\030\050\031\ufff1\032\ufff1\001\002\000\004\013" +
    "\113\001\002\000\054\002\uffe1\004\uffe1\005\uffe1\011\uffe1" +
    "\013\uffe1\014\uffe1\015\uffe1\016\uffe1\017\uffe1\020\uffe1\021" +
    "\uffe1\022\uffe1\023\uffe1\024\uffe1\025\uffe1\026\uffe1\027\uffe1" +
    "\030\uffe1\031\uffe1\032\uffe1\033\uffe1\001\002\000\036\005" +
    "\045\006\021\007\017\010\042\012\016\025\004\026\006" +
    "\035\037\036\032\037\036\040\024\041\uffc8\042\uffc8\043" +
    "\043\001\002\000\036\005\045\006\021\007\017\010\042" +
    "\012\016\025\004\026\006\035\037\036\032\037\036\040" +
    "\024\041\uffc8\042\uffc8\043\043\001\002\000\032\002\ufff9" +
    "\011\ufff9\013\ufff9\015\ufff9\016\120\017\117\020\122\021" +
    "\121\022\ufff9\023\ufff9\031\ufff9\032\ufff9\001\002\000\036" +
    "\005\045\006\021\007\017\010\042\012\016\025\004\026" +
    "\006\035\037\036\032\037\036\040\024\041\uffc8\042\uffc8" +
    "\043\043\001\002\000\036\005\045\006\021\007\017\010" +
    "\042\012\016\025\004\026\006\035\037\036\032\037\036" +
    "\040\024\041\uffc8\042\uffc8\043\043\001\002\000\036\005" +
    "\045\006\021\007\017\010\042\012\016\025\004\026\006" +
    "\035\037\036\032\037\036\040\024\041\uffc8\042\uffc8\043" +
    "\043\001\002\000\036\005\045\006\021\007\017\010\042" +
    "\012\016\025\004\026\006\035\037\036\032\037\036\040" +
    "\024\041\uffc8\042\uffc8\043\043\001\002\000\036\002\ufff4" +
    "\004\107\005\106\011\ufff4\013\ufff4\015\ufff4\016\ufff4\017" +
    "\ufff4\020\ufff4\021\ufff4\022\ufff4\023\ufff4\031\ufff4\032\ufff4" +
    "\001\002\000\036\002\ufff5\004\107\005\106\011\ufff5\013" +
    "\ufff5\015\ufff5\016\ufff5\017\ufff5\020\ufff5\021\ufff5\022\ufff5" +
    "\023\ufff5\031\ufff5\032\ufff5\001\002\000\036\002\ufff6\004" +
    "\107\005\106\011\ufff6\013\ufff6\015\ufff6\016\ufff6\017\ufff6" +
    "\020\ufff6\021\ufff6\022\ufff6\023\ufff6\031\ufff6\032\ufff6\001" +
    "\002\000\036\002\ufff7\004\107\005\106\011\ufff7\013\ufff7" +
    "\015\ufff7\016\ufff7\017\ufff7\020\ufff7\021\ufff7\022\ufff7\023" +
    "\ufff7\031\ufff7\032\ufff7\001\002\000\032\002\ufffa\011\ufffa" +
    "\013\ufffa\015\ufffa\016\120\017\117\020\122\021\121\022" +
    "\ufffa\023\ufffa\031\ufffa\032\ufffa\001\002\000\036\005\045" +
    "\006\021\007\017\010\042\012\016\025\004\026\006\035" +
    "\037\036\032\037\036\040\024\041\uffc8\042\uffc8\043\043" +
    "\001\002\000\016\002\ufffe\011\ufffe\013\ufffe\015\ufffe\031" +
    "\132\032\ufffe\001\002\000\036\005\045\006\021\007\017" +
    "\010\042\012\016\025\004\026\006\035\037\036\032\037" +
    "\036\040\024\041\uffc8\042\uffc8\043\043\001\002\000\022" +
    "\002\ufffc\011\ufffc\013\ufffc\015\ufffc\022\114\023\115\031" +
    "\ufffc\032\ufffc\001\002\000\054\002\uffce\004\uffce\005\uffce" +
    "\011\uffce\013\uffce\014\uffce\015\uffce\016\uffce\017\uffce\020" +
    "\uffce\021\uffce\022\uffce\023\uffce\024\uffce\025\uffce\026\uffce" +
    "\027\uffce\030\uffce\031\uffce\032\uffce\033\uffce\001\002\000" +
    "\054\002\uffcc\004\uffcc\005\uffcc\011\uffcc\013\uffcc\014\064" +
    "\015\uffcc\016\uffcc\017\uffcc\020\uffcc\021\uffcc\022\uffcc\023" +
    "\uffcc\024\uffcc\025\uffcc\026\uffcc\027\uffcc\030\uffcc\031\uffcc" +
    "\032\uffcc\033\uffcc\001\002\000\054\002\uffcd\004\uffcd\005" +
    "\uffcd\011\uffcd\013\uffcd\014\uffcd\015\uffcd\016\uffcd\017\uffcd" +
    "\020\uffcd\021\uffcd\022\uffcd\023\uffcd\024\uffcd\025\uffcd\026" +
    "\uffcd\027\uffcd\030\uffcd\031\uffcd\032\uffcd\033\uffcd\001\002" +
    "\000\054\002\uffcc\004\uffcc\005\uffcc\011\uffcc\013\uffcc\014" +
    "\064\015\uffcc\016\uffcc\017\uffcc\020\uffcc\021\uffcc\022\uffcc" +
    "\023\uffcc\024\uffcc\025\uffcc\026\uffcc\027\uffcc\030\uffcc\031" +
    "\uffcc\032\uffcc\033\uffcc\001\002\000\052\002\uffd0\004\uffd0" +
    "\005\uffd0\011\uffd0\013\uffd0\015\uffd0\016\uffd0\017\uffd0\020" +
    "\uffd0\021\uffd0\022\uffd0\023\uffd0\024\uffd0\025\uffd0\026\uffd0" +
    "\027\uffd0\030\uffd0\031\uffd0\032\uffd0\033\uffd0\001\002\000" +
    "\052\002\uffcb\004\uffcb\005\uffcb\011\uffcb\013\uffcb\015\uffcb" +
    "\016\uffcb\017\uffcb\020\uffcb\021\uffcb\022\uffcb\023\uffcb\024" +
    "\uffcb\025\uffcb\026\uffcb\027\uffcb\030\uffcb\031\uffcb\032\uffcb" +
    "\033\uffcb\001\002\000\046\002\uffc4\004\uffc4\005\uffc4\011" +
    "\uffc4\013\uffc4\015\uffc4\016\uffc4\017\uffc4\020\uffc4\021\uffc4" +
    "\022\uffc4\023\uffc4\024\uffc4\027\uffc4\030\uffc4\031\uffc4\032" +
    "\uffc4\033\uffc4\001\002\000\046\002\uffd5\004\uffd5\005\uffd5" +
    "\011\uffd5\013\uffd5\015\uffd5\016\uffd5\017\uffd5\020\uffd5\021" +
    "\uffd5\022\uffd5\023\uffd5\024\uffd5\027\uffd5\030\uffd5\031\uffd5" +
    "\032\uffd5\033\uffd5\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\141\000\062\003\032\004\007\005\024\006\034\007" +
    "\013\010\014\011\010\012\004\013\021\014\045\015\022" +
    "\016\030\017\033\020\043\022\027\024\026\025\011\026" +
    "\012\030\025\031\040\032\046\033\017\034\006\035\037" +
    "\001\001\000\016\025\011\026\012\030\025\031\040\032" +
    "\142\035\037\001\001\000\002\001\001\000\016\025\011" +
    "\026\012\030\025\031\040\032\141\035\037\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\027\134\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\062\003\032\004\007\005\024\006\111" +
    "\007\013\010\014\011\010\012\004\013\021\014\045\015" +
    "\022\016\030\017\033\020\043\022\027\024\026\025\011" +
    "\026\012\030\025\031\040\032\046\033\017\034\006\035" +
    "\037\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\036\060\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\044\003\032\004\007\005\024\015\055\016" +
    "\030\017\033\020\043\022\027\024\026\025\011\026\012" +
    "\030\025\031\040\032\046\033\017\034\006\035\037\001" +
    "\001\000\002\001\001\000\002\001\001\000\044\003\032" +
    "\004\007\005\024\015\054\016\030\017\033\020\043\022" +
    "\027\024\026\025\011\026\012\030\025\031\040\032\046" +
    "\033\017\034\006\035\037\001\001\000\044\003\032\004" +
    "\007\005\024\015\053\016\030\017\033\020\043\022\027" +
    "\024\026\025\011\026\012\030\025\031\040\032\046\033" +
    "\017\034\006\035\037\001\001\000\044\003\032\004\007" +
    "\005\024\015\052\016\030\017\033\020\043\022\027\024" +
    "\026\025\011\026\012\030\025\031\040\032\046\033\017" +
    "\034\006\035\037\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\016\025\011\026" +
    "\012\030\025\031\040\032\067\035\037\001\001\000\016" +
    "\025\011\026\012\030\025\031\040\032\066\035\037\001" +
    "\001\000\062\003\032\004\007\005\024\006\064\007\013" +
    "\010\014\011\010\012\004\013\021\014\045\015\022\016" +
    "\030\017\033\020\043\022\027\024\026\025\011\026\012" +
    "\030\025\031\040\032\046\033\017\034\006\035\037\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\042\003\032\004\007\005\024\016" +
    "\030\017\033\020\071\022\027\024\026\025\011\026\012" +
    "\030\025\031\040\032\046\033\017\034\006\035\037\001" +
    "\001\000\002\001\001\000\016\025\011\026\012\030\025" +
    "\031\040\032\075\035\037\001\001\000\016\025\011\026" +
    "\012\030\025\031\040\032\074\035\037\001\001\000\002" +
    "\001\001\000\002\001\001\000\066\003\032\004\007\005" +
    "\024\006\101\007\013\010\014\011\010\012\004\013\021" +
    "\014\045\015\022\016\030\017\033\020\043\021\077\022" +
    "\027\023\100\024\026\025\011\026\012\030\025\031\040" +
    "\032\046\033\017\034\006\035\037\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\066\003\032" +
    "\004\007\005\024\006\101\007\013\010\014\011\010\012" +
    "\004\013\021\014\045\015\022\016\030\017\033\020\043" +
    "\021\103\022\027\023\100\024\026\025\011\026\012\030" +
    "\025\031\040\032\046\033\017\034\006\035\037\001\001" +
    "\000\002\001\001\000\002\001\001\000\046\003\032\004" +
    "\007\005\024\014\110\015\022\016\030\017\033\020\043" +
    "\022\027\024\026\025\011\026\012\030\025\031\040\032" +
    "\046\033\017\034\006\035\037\001\001\000\046\003\032" +
    "\004\007\005\024\014\107\015\022\016\030\017\033\020" +
    "\043\022\027\024\026\025\011\026\012\030\025\031\040" +
    "\032\046\033\017\034\006\035\037\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\052\003\032\004\007\005\024\012\126\013\021\014" +
    "\045\015\022\016\030\017\033\020\043\022\027\024\026" +
    "\025\011\026\012\030\025\031\040\032\046\033\017\034" +
    "\006\035\037\001\001\000\052\003\032\004\007\005\024" +
    "\012\115\013\021\014\045\015\022\016\030\017\033\020" +
    "\043\022\027\024\026\025\011\026\012\030\025\031\040" +
    "\032\046\033\017\034\006\035\037\001\001\000\002\001" +
    "\001\000\050\003\032\004\007\005\024\013\125\014\045" +
    "\015\022\016\030\017\033\020\043\022\027\024\026\025" +
    "\011\026\012\030\025\031\040\032\046\033\017\034\006" +
    "\035\037\001\001\000\050\003\032\004\007\005\024\013" +
    "\124\014\045\015\022\016\030\017\033\020\043\022\027" +
    "\024\026\025\011\026\012\030\025\031\040\032\046\033" +
    "\017\034\006\035\037\001\001\000\050\003\032\004\007" +
    "\005\024\013\123\014\045\015\022\016\030\017\033\020" +
    "\043\022\027\024\026\025\011\026\012\030\025\031\040" +
    "\032\046\033\017\034\006\035\037\001\001\000\050\003" +
    "\032\004\007\005\024\013\122\014\045\015\022\016\030" +
    "\017\033\020\043\022\027\024\026\025\011\026\012\030" +
    "\025\031\040\032\046\033\017\034\006\035\037\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\056\003\032\004\007" +
    "\005\024\010\014\011\130\012\004\013\021\014\045\015" +
    "\022\016\030\017\033\020\043\022\027\024\026\025\011" +
    "\026\012\030\025\031\040\032\046\033\017\034\006\035" +
    "\037\001\001\000\002\001\001\000\054\003\032\004\007" +
    "\005\024\010\132\012\004\013\021\014\045\015\022\016" +
    "\030\017\033\020\043\022\027\024\026\025\011\026\012" +
    "\030\025\031\040\032\046\033\017\034\006\035\037\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\036\136" +
    "\037\137\001\001\000\002\001\001\000\006\036\136\037" +
    "\140\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  
  public Hashtable ht;
  Step tempStep;
  NodeTest tempNt;
  LocationPathExpr tempLPExpr;
  
  public parser (java.io.Reader input) {
    super(new Yylex(input));
    ht = null;
  }
  
  public parser (java.io.InputStream input) {
    super(new Yylex(input));
  }

  public static void main(String args[]){
    try {
      parser p = new parser(System.in);
      Object result = p.parse().value;
      //System.out.println(((Expr)result).evalNumber(null));
      System.out.println(((Expr)result));
    }
    catch (Exception e) {
		System.out.println("caught: "+e);
    }
  }
 
  public void report_error(String message, Object info) {
	//throw new XPathParseException("Syntax error during parsing");
  }

  public void report_fatal_error(String message, Object info) throws XPathParseException{
	throw new XPathParseException("Syntax error during parsing: "+ message);
  }

  public void syntax_error(Symbol cur_token) {
	
  }
  
  public void unrecovered_syntax_error(Symbol cur_token) throws XPathParseException{
	throw new XPathParseException("XPath Syntax error: "+cur_token);
  }
 
}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 65: // FunctionName ::= FNAME 
            {
              FuncName RESULT = null;
		int fnleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int fnright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		FuncName fn = (FuncName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = fn; 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*FunctionName*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 64: // VariableReference ::= DOLLAR NAME 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(1/*VariableReference*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 63: // Predicate ::= LB Expr RB 
            {
              Predicate RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Expr e = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
			RESULT = new Predicate();
   		        RESULT.expr= e; 
		
              CUP$parser$result = new java_cup.runtime.Symbol(28/*Predicate*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 62: // AbbreviatedRelativeLocationPath ::= Step DSLASH RelativeLocationPath 
            {
              Step RESULT = null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Step s = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int rlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step rlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Step();
		  RESULT.setAxisType(AxisType.DESCENDANT_OR_SELF);
		  parser.tempNt = new NodeTest();
					  
		  parser.tempNt.setTestType(NodeTest.NODE);
		  RESULT.setNodeTest(parser.tempNt);
		  s.setNextStep(RESULT);
		  RESULT.setPrevStep(s);
		  RESULT.setNextStep(rlp);
		  rlp.setPrevStep(RESULT);
		  RESULT = s;
		
              CUP$parser$result = new java_cup.runtime.Symbol(27/*AbbreviatedRelativeLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 61: // AbbreviatedAbsoluteLocationPath ::= DSLASH RelativeLocationPath 
            {
              Step RESULT = null;
		int rlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int rlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step rlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
		  RESULT = new Step();
		  RESULT.setAxisType(AxisType.DESCENDANT_OR_SELF);
		  parser.tempNt = new NodeTest();
		  parser.tempNt.setTestType(NodeTest.NODE);
		  RESULT.setNodeTest(parser.tempNt);
		  RESULT.setNextStep(rlp);
		  rlp.setPrevStep(RESULT);
		
              CUP$parser$result = new java_cup.runtime.Symbol(26/*AbbreviatedAbsoluteLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 60: // AbbreviatedStep ::= DDOT 
            {
              Step RESULT = null;
		  RESULT = new Step();
		    parser.tempNt = new NodeTest();
  		    parser.tempNt.setTestType(NodeTest.NODE);
		    RESULT.setAxisType(AxisType.PARENT);
		    RESULT.setNodeTest(parser.tempNt);
		
              CUP$parser$result = new java_cup.runtime.Symbol(23/*AbbreviatedStep*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 59: // AbbreviatedStep ::= DOT 
            {
              Step RESULT = null;
		  RESULT = new Step();
		    parser.tempNt = new NodeTest();
  		    parser.tempNt.setTestType(NodeTest.NODE);
		    RESULT.setAxisType(AxisType.SELF);
		    RESULT.setNodeTest(parser.tempNt);				 
		
              CUP$parser$result = new java_cup.runtime.Symbol(23/*AbbreviatedStep*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 58: // AbbreviatedAxisSpecifier ::= AT 
            {
              AxisType RESULT = null;
		 RESULT = new AxisType(); RESULT.i = AxisType.ATTRIBUTE; 
              CUP$parser$result = new java_cup.runtime.Symbol(20/*AbbreviatedAxisSpecifier*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 57: // AbbreviatedAxisSpecifier ::= 
            {
              AxisType RESULT = null;
		 RESULT = new AxisType(); RESULT.i = AxisType.CHILD; 
              CUP$parser$result = new java_cup.runtime.Symbol(20/*AbbreviatedAxisSpecifier*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 56: // AxisSpecifier ::= AbbreviatedAxisSpecifier 
            {
              AxisType RESULT = null;
		int aasleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aasright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		AxisType aas = (AxisType)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		  RESULT = aas; 
              CUP$parser$result = new java_cup.runtime.Symbol(19/*AxisSpecifier*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 55: // AxisSpecifier ::= AXISNAME 
            {
              AxisType RESULT = null;
		int anleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int anright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		AxisType an = (AxisType)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		  RESULT = an; 
              CUP$parser$result = new java_cup.runtime.Symbol(19/*AxisSpecifier*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 54: // PredicateList ::= Predicate PredicateList 
            {
              Predicate RESULT = null;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Predicate p = (Predicate)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int plleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int plright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Predicate pl = (Predicate)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		  p.nextP = pl;
		    RESULT = p;
		
              CUP$parser$result = new java_cup.runtime.Symbol(29/*PredicateList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 53: // PredicateList ::= 
            {
              Predicate RESULT = null;
		 RESULT = null;
	      	
              CUP$parser$result = new java_cup.runtime.Symbol(29/*PredicateList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 52: // nodetest ::= NTEST 
            {
              NodeTest RESULT = null;
		int n2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int n2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Ntest n2 = (Ntest)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new NodeTest();
		  RESULT.setTestType(n2.i);				
		
              CUP$parser$result = new java_cup.runtime.Symbol(21/*nodetest*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 51: // nodetest ::= NAME 
            {
              NodeTest RESULT = null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		NameType n = (NameType)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new NodeTest();
	 	   RESULT.setTestType(NodeTest.NAMETEST);
		   RESULT.setNodeName(n.qname);
		   if (n.localname!=null){
		   	 RESULT.setNodeNameNS(n.prefix,n.localname);
		   	 if (parser.ht==null || parser.ht.get(n.prefix) ==null)
		   	    throw new XPathParseException("No URL found for prefix:"+n.prefix);
		   	 RESULT.URL = (String) parser.ht.get(n.prefix);
		   }
		
              CUP$parser$result = new java_cup.runtime.Symbol(21/*nodetest*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 50: // Step ::= AbbreviatedStep 
            {
              Step RESULT = null;
		int absleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int absright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step abs = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = abs; /*System.out.println(" step 4");*/ 
		
              CUP$parser$result = new java_cup.runtime.Symbol(22/*Step*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 49: // Step ::= AxisSpecifier nodetest PredicateList 
            {
              Step RESULT = null;
		int asleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int asright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		AxisType as = (AxisType)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int ntleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int ntright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		NodeTest nt = (NodeTest)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int plleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int plright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Predicate pl = (Predicate)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Step();
      	   RESULT.setAxisType(as.i);
      	   RESULT.setNodeTest(nt);
		   RESULT.setPredicate(pl);	
		   //System.out.println(" Step 3 ");
		
              CUP$parser$result = new java_cup.runtime.Symbol(22/*Step*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 48: // RelativeLocationPath ::= AbbreviatedRelativeLocationPath 
            {
              Step RESULT = null;
		int arlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int arlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step arlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = arlp;	
              CUP$parser$result = new java_cup.runtime.Symbol(24/*RelativeLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // RelativeLocationPath ::= Step SLASH RelativeLocationPath 
            {
              Step RESULT = null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Step s = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int rlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step rlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 //if (s == rlp) throw new XPathParseException("$1 = $3!!!!");
		   s.nextS = rlp;						
		   rlp.prevS = s;							 
		   RESULT= s;
		
              CUP$parser$result = new java_cup.runtime.Symbol(24/*RelativeLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // RelativeLocationPath ::= Step 
            {
              Step RESULT = null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step s = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = s; 
              CUP$parser$result = new java_cup.runtime.Symbol(24/*RelativeLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // AbsoluteLocationPath ::= AbbreviatedAbsoluteLocationPath 
            {
              Step RESULT = null;
		int aalpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aalpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step aalp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		  RESULT = aalp;   
              CUP$parser$result = new java_cup.runtime.Symbol(25/*AbsoluteLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // AbsoluteLocationPath ::= SLASH RelativeLocationPath 
            {
              Step RESULT = null;
		int rlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int rlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step rlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		  RESULT = rlp;   
              CUP$parser$result = new java_cup.runtime.Symbol(25/*AbsoluteLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // AbsoluteLocationPath ::= SLASH 
            {
              Step RESULT = null;
		  RESULT = null; 
              CUP$parser$result = new java_cup.runtime.Symbol(25/*AbsoluteLocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // LocationPath ::= AbsoluteLocationPath 
            {
              LocationPathExpr RESULT = null;
		int alpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int alpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step alp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new LocationPathExpr();
		   RESULT.setPathType(LocationPathExpr.ABSOLUTE_PATH);
		   //System.out.println(" absolute ");
		   RESULT.setStep(alp);
		   //startStep = currentStep=null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(18/*LocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // LocationPath ::= RelativeLocationPath 
            {
              LocationPathExpr RESULT = null;
		int rlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int rlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step rlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new LocationPathExpr();
		   RESULT.setStep(rlp); 
		
              CUP$parser$result = new java_cup.runtime.Symbol(18/*LocationPath*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // Argument ::= Expr 
            {
              Expr RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr e = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = e; 
              CUP$parser$result = new java_cup.runtime.Symbol(17/*Argument*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // ArgumentList ::= Argument COMMA ArgumentList 
            {
              Alist RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr a = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int alleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int alright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Alist al = (Alist)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Alist();
		   RESULT.e = a;
		   RESULT.next = al;
		
              CUP$parser$result = new java_cup.runtime.Symbol(15/*ArgumentList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // ArgumentList ::= Argument 
            {
              Alist RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr a = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Alist();
		   RESULT.e = a; 
              CUP$parser$result = new java_cup.runtime.Symbol(15/*ArgumentList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // ArgumentList ::= 
            {
              Alist RESULT = null;
		 RESULT = null; 
              CUP$parser$result = new java_cup.runtime.Symbol(15/*ArgumentList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // FunctionCall ::= FunctionName LP ArgumentList RP 
            {
              FuncExpr RESULT = null;
		int fnleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int fnright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		FuncName fn = (FuncName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int alleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int alright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Alist al = (Alist)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new FuncExpr(fn.i, al); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*FunctionCall*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // PrimaryExpr ::= FunctionCall 
            {
              Expr RESULT = null;
		int fcleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int fcright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		FuncExpr fc = (FuncExpr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = fc; 
              CUP$parser$result = new java_cup.runtime.Symbol(16/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // PrimaryExpr ::= NUMBER 
            {
              Expr RESULT = null;
		int neleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int neright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Double ne = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new NumExpr(ne.doubleValue()); 
              CUP$parser$result = new java_cup.runtime.Symbol(16/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // PrimaryExpr ::= LITERAL 
            {
              Expr RESULT = null;
		int leleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int leright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String le = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new LiteralExpr(le); 
              CUP$parser$result = new java_cup.runtime.Symbol(16/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // PrimaryExpr ::= LP Expr RP 
            {
              Expr RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Expr e = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = e; 
              CUP$parser$result = new java_cup.runtime.Symbol(16/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // PrimaryExpr ::= VariableReference 
            {
              Expr RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(16/*PrimaryExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // FilterExpr ::= FilterExpr Predicate 
            {
              Expr RESULT = null;
		int feleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int feright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Expr fe = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Predicate p = (Predicate)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new FilterExpr(fe, p);
              CUP$parser$result = new java_cup.runtime.Symbol(13/*FilterExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // FilterExpr ::= PrimaryExpr 
            {
              Expr RESULT = null;
		int peleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int peright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr pe = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = pe; 
              CUP$parser$result = new java_cup.runtime.Symbol(13/*FilterExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // PathExpr ::= FilterExpr DSLASH RelativeLocationPath 
            {
              Expr RESULT = null;
		int feleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int feright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr fe = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int rlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step rlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		   parser.tempStep = new Step();

		     parser.tempStep.setAxisType(AxisType.DESCENDANT_OR_SELF);
		     parser.tempNt = new NodeTest();
		     parser.tempNt.setTestType(NodeTest.NODE);

		     parser.tempStep.setNodeTest(parser.tempNt);

		     parser.tempStep.setNextStep(rlp);
		     rlp.setPrevStep(parser.tempStep);
		     
		     /*parser.tempStep2 = new Step();
		     parser.tempNt = new NodeTest();
		     parser.tempStep2.setAxisType(AxisType.SELF);
		     parser.tempNt.setTestType(NodeTest.NODE);

		     parser.tempStep2.setNodeTest(parser.tempNt);
	
  		     parser.tempStep2.setNextStep(parser.tempStep);
		     parser.tempStep.setPrevStep(parser.tempStep2);*/

		     parser.tempLPExpr = new LocationPathExpr();
		     parser.tempLPExpr.setStep(parser.tempStep);
		     RESULT = new PathExpr(fe, parser.tempLPExpr);
		
              CUP$parser$result = new java_cup.runtime.Symbol(12/*PathExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // PathExpr ::= FilterExpr SLASH RelativeLocationPath 
            {
              Expr RESULT = null;
		int feleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int feright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr fe = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rlpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int rlpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Step rlp = (Step)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		   parser.tempLPExpr = new LocationPathExpr();
		     parser.tempLPExpr.setStep(rlp);
		     RESULT = new PathExpr(fe, parser.tempLPExpr);	
		
              CUP$parser$result = new java_cup.runtime.Symbol(12/*PathExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // PathExpr ::= FilterExpr 
            {
              Expr RESULT = null;
		int feleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int feright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr fe = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		  RESULT = fe; 
              CUP$parser$result = new java_cup.runtime.Symbol(12/*PathExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // PathExpr ::= LocationPath 
            {
              Expr RESULT = null;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		LocationPathExpr lp = (LocationPathExpr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		  RESULT = lp; 
              CUP$parser$result = new java_cup.runtime.Symbol(12/*PathExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // UnionExpr ::= PathExpr UNION UnionExpr 
            {
              UnionExpr RESULT = null;
		int peleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int peright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr pe = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int uneleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int uneright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		UnionExpr une = (UnionExpr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
   		   RESULT = new UnionExpr(pe);
   		   RESULT.next = une;
		
              CUP$parser$result = new java_cup.runtime.Symbol(14/*UnionExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // UnionExpr ::= PathExpr 
            {
              UnionExpr RESULT = null;
		int peleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int peright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr pe = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT =  new UnionExpr(pe); 
		
              CUP$parser$result = new java_cup.runtime.Symbol(14/*UnionExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // UnaryExpr ::= SUB UnaryExpr 
            {
              Expr RESULT = null;
		int ueleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int ueright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ue = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new UnaryExpr( BinaryExpr.SUB, ue); 
              CUP$parser$result = new java_cup.runtime.Symbol(11/*UnaryExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // UnaryExpr ::= UnionExpr 
            {
              Expr RESULT = null;
		int ueleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int ueright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		UnionExpr ue = (UnionExpr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = ue; 
              CUP$parser$result = new java_cup.runtime.Symbol(11/*UnaryExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // MultiplicativeExpr ::= MultiplicativeExpr MOD UnaryExpr 
            {
              Expr RESULT = null;
		int meleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int meright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr me = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int ueleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int ueright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ue = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(me, BinaryExpr.MOD, ue); 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*MultiplicativeExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // MultiplicativeExpr ::= MultiplicativeExpr DIV UnaryExpr 
            {
              Expr RESULT = null;
		int meleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int meright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr me = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int ueleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int ueright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ue = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(me, BinaryExpr.DIV, ue); 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*MultiplicativeExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // MultiplicativeExpr ::= MultiplicativeExpr MULT UnaryExpr 
            {
              Expr RESULT = null;
		int meleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int meright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr me = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int ueleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int ueright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ue = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(me, BinaryExpr.MULT, ue); 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*MultiplicativeExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // MultiplicativeExpr ::= UnaryExpr 
            {
              Expr RESULT = null;
		int ueleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int ueright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ue = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = ue; 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*MultiplicativeExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // AdditiveExpr ::= AdditiveExpr SUB MultiplicativeExpr 
            {
              Expr RESULT = null;
		int aeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr ae = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int meleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int meright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr me = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(ae, BinaryExpr.SUB, me); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*AdditiveExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // AdditiveExpr ::= AdditiveExpr ADD MultiplicativeExpr 
            {
              Expr RESULT = null;
		int aeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr ae = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int meleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int meright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr me = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(ae, BinaryExpr.ADD, me); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*AdditiveExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // AdditiveExpr ::= MultiplicativeExpr 
            {
              Expr RESULT = null;
		int meleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int meright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr me = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = me; 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*AdditiveExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // RelationalExpr ::= RelationalExpr GE AdditiveExpr 
            {
              Expr RESULT = null;
		int releft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int reright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr re = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ae = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(re, BinaryExpr.GE, ae); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*RelationalExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // RelationalExpr ::= RelationalExpr LE AdditiveExpr 
            {
              Expr RESULT = null;
		int releft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int reright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr re = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ae = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(re, BinaryExpr.LE, ae);  
              CUP$parser$result = new java_cup.runtime.Symbol(8/*RelationalExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // RelationalExpr ::= RelationalExpr GT AdditiveExpr 
            {
              Expr RESULT = null;
		int releft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int reright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr re = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ae = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(re, BinaryExpr.GT, ae); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*RelationalExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // RelationalExpr ::= RelationalExpr LT AdditiveExpr 
            {
              Expr RESULT = null;
		int releft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int reright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr re = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ae = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(re, BinaryExpr.LT, ae); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*RelationalExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // RelationalExpr ::= AdditiveExpr 
            {
              Expr RESULT = null;
		int aeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ae = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = ae; 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*RelationalExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EqualityExpr ::= EqualityExpr NE RelationalExpr 
            {
              Expr RESULT = null;
		int eeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr ee = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int releft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int reright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr re = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(ee, BinaryExpr.NE, re); 
              CUP$parser$result = new java_cup.runtime.Symbol(6/*EqualityExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EqualityExpr ::= EqualityExpr EQ RelationalExpr 
            {
              Expr RESULT = null;
		int eeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr ee = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int releft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int reright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr re = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(ee, BinaryExpr.EQ, re); 
              CUP$parser$result = new java_cup.runtime.Symbol(6/*EqualityExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // EqualityExpr ::= RelationalExpr 
            {
              Expr RESULT = null;
		int releft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int reright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr re = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = re; 
              CUP$parser$result = new java_cup.runtime.Symbol(6/*EqualityExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // AndExpr ::= AndExpr AND EqualityExpr 
            {
              Expr RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr a = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int eeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ee = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(a, BinaryExpr.AND, ee); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*AndExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // AndExpr ::= EqualityExpr 
            {
              Expr RESULT = null;
		int eeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int eeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr ee = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = ee; 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*AndExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // OrExpr ::= OrExpr OR AndExpr 
            {
              Expr RESULT = null;
		int oleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Expr o = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr a = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new BinaryExpr(o,BinaryExpr.OR,a);
              CUP$parser$result = new java_cup.runtime.Symbol(5/*OrExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // OrExpr ::= AndExpr 
            {
              Expr RESULT = null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr a = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = a; 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*OrExpr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Expr EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Expr start_val = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Expr ::= OrExpr 
            {
              Expr RESULT = null;
		int oleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Expr o = (Expr)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = o; 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*Expr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

