/**
*  EmptyCollectionException represents the situation in which a collection is empty.
*
*  @author  Warren Smith/Java Foundations
*/

package javafoundations.exceptions;

public class EmptyCollectionException extends RuntimeException
{
  /**
  *  Sets up this exception with an appropriate message.
  *
  *  @param  String message
  */
  public EmptyCollectionException(String message)
  {
    super (message);
  }
}

