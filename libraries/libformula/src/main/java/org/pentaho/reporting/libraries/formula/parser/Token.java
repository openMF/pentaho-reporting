/*
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
* Foundation.
*
* You should have received a copy of the GNU Lesser General Public License along with this
* program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
* or from the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU Lesser General Public License for more details.
*
* Copyright (c) 2006 - 2017 Hitachi Vantara and Contributors.  All rights reserved.
*/

package org.pentaho.reporting.libraries.formula.parser;

/**
 * Describes the input token stream.
 */

public class Token {

  /**
   * An integer that describes the kind of this token.  This numbering system is determined by JavaCCParser, and a table
   * of these numbers is stored in the file ...Constants.java.
   */
  public int kind;

  /**
   * beginLine and beginColumn describe the position of the first character of this token; endLine and endColumn
   * describe the position of the last character of this token.
   */
  public int beginLine;
  public int beginColumn;
  public int endLine;
  public int endColumn;

  /**
   * The string image of the token.
   */
  public String image;

  /**
   * A reference to the next regular (non-special) token from the input stream.  If this is the last token from the
   * input stream, or if the token manager has not read tokens beyond this one, this field is set to null.  This is true
   * only if this token is also a regular token.  Otherwise, see below for a description of the contents of this field.
   */
  public Token next;

  /**
   * This field is used to access special tokens that occur prior to this token, but after the immediately preceding
   * regular (non-special) token. If there are no such special tokens, this field is set to null. When there are more
   * than one such special token, this field refers to the last of these special tokens, which in turn refers to the
   * next previous special token through its specialToken field, and so on until the first special token (whose
   * specialToken field is null). The next fields of special tokens refer to other special tokens that immediately
   * follow it (without an intervening regular token).  If there is no such token, this field is null.
   */
  public Token specialToken;

  public Token() {
  }

  /**
   * Returns the image.
   */
  public String toString() {
    return image;
  }

  /**
   * Returns a new Token object, by default. However, if you want, you can create and return subclass objects based on
   * the value of ofKind. Simply add the cases to the switch for all those special cases. For example, if you have a
   * subclass of Token called IDToken that you want to create if ofKind is ID, simlpy add something like :
   * <p/>
   * case MyParserConstants.ID : return new IDToken();
   * <p/>
   * to the following switch statement. Then you can cast matchedToken variable to the appropriate type and use it in
   * your lexical actions.
   */
  public static Token newToken( final int ofKind ) {
    switch( ofKind ) {
      default:
        return new Token();
    }
  }

}
