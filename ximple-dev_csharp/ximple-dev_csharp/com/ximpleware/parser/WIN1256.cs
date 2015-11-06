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
using System;
namespace com.ximpleware.parser
{
	
	/// <summary> this class contains method to map a windows-1256 char
	/// into a Unicode char
	/// 
	/// </summary>
	public class WIN1256
	{
		//UPGRADE_NOTE: Final was removed from the declaration of 'chars '. "ms-help://MS.VSCC.v80/dv_commoner/local/redirect.htm?index='!DefaultContextWindowIndex'&keyword='jlca1003'"
		internal static readonly char[] chars = new char[0x100];
		public static char decode(byte b)
		{
			return chars[b];
		}
		static WIN1256()
		{
			{
				for (int i = 0; i < 128; i++)
				{
					chars[i] = (char) i;
				}
				for (int i = 128; i < 256; i++)
				{
					chars[i] = (char) (0xfffd);
				}
				chars[0x80] = (char) (0x20AC); // EURO SIGN
				chars[0x81] = (char) (0x067E); // ARABIC LETTER PEH
				chars[0x82] = (char) (0x201A); // SINGLE LOW-9 QUOTATION MARK
				chars[0x83] = (char) (0x0192); // LATIN SMALL LETTER F WITH HOOK
				chars[0x84] = (char) (0x201E); // DOUBLE LOW-9 QUOTATION MARK
				chars[0x85] = (char) (0x2026); // HORIZONTAL ELLIPSIS
				chars[0x86] = (char) (0x2020); // DAGGER
				chars[0x87] = (char) (0x2021); // DOUBLE DAGGER
				chars[0x88] = (char) (0x02C6); // MODIFIER LETTER CIRCUMFLEX ACCENT
				chars[0x89] = (char) (0x2030); // PER MILLE SIGN
				chars[0x8A] = (char) (0x0679); // ARABIC LETTER TTEH
				chars[0x8B] = (char) (0x2039); // SINGLE LEFT-POINTING ANGLE QUOTATION MARK
				chars[0x8C] = (char) (0x0152); // LATIN CAPITAL LIGATURE OE
				chars[0x8D] = (char) (0x0686); // ARABIC LETTER TCHEH
				chars[0x8E] = (char) (0x0698); // ARABIC LETTER JEH
				chars[0x8F] = (char) (0x0688); // ARABIC LETTER DDAL
				chars[0x90] = (char) (0x06AF); // ARABIC LETTER GAF
				chars[0x91] = (char) (0x2018); // LEFT SINGLE QUOTATION MARK
				chars[0x92] = (char) (0x2019); // RIGHT SINGLE QUOTATION MARK
				chars[0x93] = (char) (0x201C); // LEFT DOUBLE QUOTATION MARK
				chars[0x94] = (char) (0x201D); // RIGHT DOUBLE QUOTATION MARK
				chars[0x95] = (char) (0x2022); // BULLET
				chars[0x96] = (char) (0x2013); // EN DASH
				chars[0x97] = (char) (0x2014); // EM DASH
				chars[0x98] = (char) (0x06A9); // ARABIC LETTER KEHEH
				chars[0x99] = (char) (0x2122); // TRADE MARK SIGN
				chars[0x9A] = (char) (0x0691); // ARABIC LETTER RREH
				chars[0x9B] = (char) (0x203A); // SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
				chars[0x9C] = (char) (0x0153); // LATIN SMALL LIGATURE OE
				chars[0x9D] = (char) (0x200C); // ZERO WIDTH NON-JOINER
				chars[0x9E] = (char) (0x200D); // ZERO WIDTH JOINER
				chars[0x9F] = (char) (0x06BA); // ARABIC LETTER NOON GHUNNA
				chars[0xA0] = (char) (0x00A0); // NO-BREAK SPACE
				chars[0xA1] = (char) (0x060C); // ARABIC COMMA
				chars[0xA2] = (char) (0x00A2); // CENT SIGN
				chars[0xA3] = (char) (0x00A3); // POUND SIGN
				chars[0xA4] = (char) (0x00A4); // CURRENCY SIGN
				chars[0xA5] = (char) (0x00A5); // YEN SIGN
				chars[0xA6] = (char) (0x00A6); // BROKEN BAR
				chars[0xA7] = (char) (0x00A7); // SECTION SIGN
				chars[0xA8] = (char) (0x00A8); // DIAERESIS
				chars[0xA9] = (char) (0x00A9); // COPYRIGHT SIGN
				chars[0xAA] = (char) (0x06BE); // ARABIC LETTER HEH DOACHASHMEE
				chars[0xAB] = (char) (0x00AB); // LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
				chars[0xAC] = (char) (0x00AC); // NOT SIGN
				chars[0xAD] = (char) (0x00AD); // SOFT HYPHEN
				chars[0xAE] = (char) (0x00AE); // REGISTERED SIGN
				chars[0xAF] = (char) (0x00AF); // MACRON
				chars[0xB0] = (char) (0x00B0); // DEGREE SIGN
				chars[0xB1] = (char) (0x00B1); // PLUS-MINUS SIGN
				chars[0xB2] = (char) (0x00B2); // SUPERSCRIPT TWO
				chars[0xB3] = (char) (0x00B3); // SUPERSCRIPT THREE
				chars[0xB4] = (char) (0x00B4); // ACUTE ACCENT
				chars[0xB5] = (char) (0x00B5); // MICRO SIGN
				chars[0xB6] = (char) (0x00B6); // PILCROW SIGN
				chars[0xB7] = (char) (0x00B7); // MIDDLE DOT
				chars[0xB8] = (char) (0x00B8); // CEDILLA
				chars[0xB9] = (char) (0x00B9); // SUPERSCRIPT ONE
				chars[0xBA] = (char) (0x061B); // ARABIC SEMICOLON
				chars[0xBB] = (char) (0x00BB); // RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
				chars[0xBC] = (char) (0x00BC); // VULGAR FRACTION ONE QUARTER
				chars[0xBD] = (char) (0x00BD); // VULGAR FRACTION ONE HALF
				chars[0xBE] = (char) (0x00BE); // VULGAR FRACTION THREE QUARTERS
				chars[0xBF] = (char) (0x061F); // ARABIC QUESTION MARK
				chars[0xC0] = (char) (0x06C1); // ARABIC LETTER HEH GOAL
				chars[0xC1] = (char) (0x0621); // ARABIC LETTER HAMZA
				chars[0xC2] = (char) (0x0622); // ARABIC LETTER ALEF WITH MADDA ABOVE
				chars[0xC3] = (char) (0x0623); // ARABIC LETTER ALEF WITH HAMZA ABOVE
				chars[0xC4] = (char) (0x0624); // ARABIC LETTER WAW WITH HAMZA ABOVE
				chars[0xC5] = (char) (0x0625); // ARABIC LETTER ALEF WITH HAMZA BELOW
				chars[0xC6] = (char) (0x0626); // ARABIC LETTER YEH WITH HAMZA ABOVE
				chars[0xC7] = (char) (0x0627); // ARABIC LETTER ALEF
				chars[0xC8] = (char) (0x0628); // ARABIC LETTER BEH
				chars[0xC9] = (char) (0x0629); // ARABIC LETTER TEH MARBUTA
				chars[0xCA] = (char) (0x062A); // ARABIC LETTER TEH
				chars[0xCB] = (char) (0x062B); // ARABIC LETTER THEH
				chars[0xCC] = (char) (0x062C); // ARABIC LETTER JEEM
				chars[0xCD] = (char) (0x062D); // ARABIC LETTER HAH
				chars[0xCE] = (char) (0x062E); // ARABIC LETTER KHAH
				chars[0xCF] = (char) (0x062F); // ARABIC LETTER DAL
				chars[0xD0] = (char) (0x0630); // ARABIC LETTER THAL
				chars[0xD1] = (char) (0x0631); // ARABIC LETTER REH
				chars[0xD2] = (char) (0x0632); // ARABIC LETTER ZAIN
				chars[0xD3] = (char) (0x0633); // ARABIC LETTER SEEN
				chars[0xD4] = (char) (0x0634); // ARABIC LETTER SHEEN
				chars[0xD5] = (char) (0x0635); // ARABIC LETTER SAD
				chars[0xD6] = (char) (0x0636); // ARABIC LETTER DAD
				chars[0xD7] = (char) (0x00D7); // MULTIPLICATION SIGN
				chars[0xD8] = (char) (0x0637); // ARABIC LETTER TAH
				chars[0xD9] = (char) (0x0638); // ARABIC LETTER ZAH
				chars[0xDA] = (char) (0x0639); // ARABIC LETTER AIN
				chars[0xDB] = (char) (0x063A); // ARABIC LETTER GHAIN
				chars[0xDC] = (char) (0x0640); // ARABIC TATWEEL
				chars[0xDD] = (char) (0x0641); // ARABIC LETTER FEH
				chars[0xDE] = (char) (0x0642); // ARABIC LETTER QAF
				chars[0xDF] = (char) (0x0643); // ARABIC LETTER KAF
				chars[0xE0] = (char) (0x00E0); // LATIN SMALL LETTER A WITH GRAVE
				chars[0xE1] = (char) (0x0644); // ARABIC LETTER LAM
				chars[0xE2] = (char) (0x00E2); // LATIN SMALL LETTER A WITH CIRCUMFLEX
				chars[0xE3] = (char) (0x0645); // ARABIC LETTER MEEM
				chars[0xE4] = (char) (0x0646); // ARABIC LETTER NOON
				chars[0xE5] = (char) (0x0647); // ARABIC LETTER HEH
				chars[0xE6] = (char) (0x0648); // ARABIC LETTER WAW
				chars[0xE7] = (char) (0x00E7); // LATIN SMALL LETTER C WITH CEDILLA
				chars[0xE8] = (char) (0x00E8); // LATIN SMALL LETTER E WITH GRAVE
				chars[0xE9] = (char) (0x00E9); // LATIN SMALL LETTER E WITH ACUTE
				chars[0xEA] = (char) (0x00EA); // LATIN SMALL LETTER E WITH CIRCUMFLEX
				chars[0xEB] = (char) (0x00EB); // LATIN SMALL LETTER E WITH DIAERESIS
				chars[0xEC] = (char) (0x0649); // ARABIC LETTER ALEF MAKSURA
				chars[0xED] = (char) (0x064A); // ARABIC LETTER YEH
				chars[0xEE] = (char) (0x00EE); // LATIN SMALL LETTER I WITH CIRCUMFLEX
				chars[0xEF] = (char) (0x00EF); // LATIN SMALL LETTER I WITH DIAERESIS
				chars[0xF0] = (char) (0x064B); // ARABIC FATHATAN
				chars[0xF1] = (char) (0x064C); // ARABIC DAMMATAN
				chars[0xF2] = (char) (0x064D); // ARABIC KASRATAN
				chars[0xF3] = (char) (0x064E); // ARABIC FATHA
				chars[0xF4] = (char) (0x00F4); // LATIN SMALL LETTER O WITH CIRCUMFLEX
				chars[0xF5] = (char) (0x064F); // ARABIC DAMMA
				chars[0xF6] = (char) (0x0650); // ARABIC KASRA
				chars[0xF7] = (char) (0x00F7); // DIVISION SIGN
				chars[0xF8] = (char) (0x0651); // ARABIC SHADDA
				chars[0xF9] = (char) (0x00F9); // LATIN SMALL LETTER U WITH GRAVE
				chars[0xFA] = (char) (0x0652); // ARABIC SUKUN
				chars[0xFB] = (char) (0x00FB); // LATIN SMALL LETTER U WITH CIRCUMFLEX
				chars[0xFC] = (char) (0x00FC); // LATIN SMALL LETTER U WITH DIAERESIS
				chars[0xFD] = (char) (0x200E); // LEFT-TO-RIGHT MARK
				chars[0xFE] = (char) (0x200F); // RIGHT-TO-LEFT MARK
				chars[0xFF] = (char) (0x06D2); // ARABIC LETTER YEH BARREE
			}
		}
	}
}