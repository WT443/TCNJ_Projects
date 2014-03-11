/**
*  ElementNotFoundException represents the situation in which a target 
*  element is not present in a collection.
*
*  @author  Warren Smith/Java Foundations
*/

package javafoundations.exceptions;

public class ElementNotFoundException extends RuntimeException
{
  /**
  *  Sets up this exception with an appropriate message.
  *
  *  @param  String message
  */
  public ElementNotFoundException(String message)
  {
    super (message);
  }
}

