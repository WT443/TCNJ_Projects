/**
*  The Driver class is used to kick start the program by creating the 
*  a TwentyQuestions "movies" object and then calling the playGame()
*  and printTree() methods within its own main method. 
*
*  @author  Warren Smith
*/

package code;

import javafoundations.*;
import java.io.*;

public class Driver
{
   /** Prints/creates tree & plays this version of the 20 Questions game. */
   public static void main (String[] args) throws Exception
   {
      TwentyQuestions movies = new TwentyQuestions();
	  movies.printTree(); 
	  movies.createTree();
      movies.playGame();
	  movies.printTree();
   }
}