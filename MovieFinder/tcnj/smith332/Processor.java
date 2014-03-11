/**
   Warren Smith, David Piccolella & Kamal Jain
   CSC230-01
   Lab 8
   Processor Class
*/

package tcnj.smith332;

import javafoundations.*;
import java.util.Scanner;

public class Processor
{
   private LinkedBinaryTree<String> tree;

   /**-----------------------------------------------------------------
       Sets up the movie question tree. 
   ------------------------------------------------------------------*/ 
   public Processor()
   {
	  String e1 = "Do you want to watch a serious movie?";
	  String e2 = "Do you want to watch a family movie?";
	  String e3 = "Do you want to watch a drama?";
	  String e4 = "Do you want to watch a popular comedy?";
	  String e5 = "Do you want to watch an animated movie?";
	  String e6 = "Do you want to watch a horror?";
	  String e7 = "Do you want to watch a courtroom drama?";
	  String e8 = "Do you want to watch a movie with ice cube?";
	  String e9 = "Do you want to watch a movie made after 2000?";
	  String e10 = "Do you want to watch a movie with a dog?";
	  String e11 = "Do you want to watch a claymation movie?";
	  String e12 = "Do you want to watch a thriller?";
	  String e13 = "Do you want to watch a movie involving aliens?";
	  String e14 = "Do you want to watch a coming of age story?";
	  String e15 = "Do you want to watch a military movie?";
	  String e16 = "You should watch 'The Hottie & The Nottie'";
	  String e17 = "You should watch 'Are We Done Yet'";
	  String e18 = "You should watch 'Animal House'";
	  String e19 = "You should watch 'The Hangover'";
	  String e20 = "You should watch 'MXP: Most Extreme Primate'";
	  String e21 = "You should watch 'Air Bud'";
	  String e22 = "You should watch 'Bambi'";
	  String e23 = "You should watch 'The Nightmare Before Christmas'";
	  String e24 = "You should watch 'The Man With The Iron Fists'";
	  String e25 = "You should watch 'Taken'";
	  String e26 = "You should watch 'The Blair Witch Project'";
	  String e27 = "You should watch 'Alien'";
	  String e28 = "Would you like to watch a Social Drama?";
	  String e29 = "Would you like to watch an Action Drama?";
	  String e30 = "You should watch 'Chinatown'";
	  String e31 = "You should watch 'A Few Good Men'";
	  String e32 = "You should watch 'The Alamo'";
	  String e33 = "You should watch 'The Grapes of Wrath'";
	  String e34 = "You should watch 'Pretty In Pink'";
	  String e35 = "You should watch 'Top Gun'";

      LinkedBinaryTree<String> n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20, n21, n22, n23, n24, n25, n26, n27, n28, n29, n30, n31, n32, n33, n34, n35;
      
	  n16 = new LinkedBinaryTree<String>(e16);
	  n17 = new LinkedBinaryTree<String>(e17);
	  n18 = new LinkedBinaryTree<String>(e18);
	  n19 = new LinkedBinaryTree<String>(e19);
	  n8 = new LinkedBinaryTree<String>(e8, n16, n17);
	  n9 = new LinkedBinaryTree<String>(e9, n18, n19);
      n4 = new LinkedBinaryTree<String>(e4, n8, n9);
     
	  n20 = new LinkedBinaryTree<String>(e20);
	  n21 = new LinkedBinaryTree<String>(e21);
	  n22 = new LinkedBinaryTree<String>(e22);
	  n23 = new LinkedBinaryTree<String>(e23);
	  n10 = new LinkedBinaryTree<String>(e10, n20, n21);
	  n11 = new LinkedBinaryTree<String>(e11, n22, n23);
      n5 = new LinkedBinaryTree<String>(e5, n10, n11);

	  n24 = new LinkedBinaryTree<String>(e24);
	  n25 = new LinkedBinaryTree<String>(e25);
	  n26 = new LinkedBinaryTree<String>(e26);
	  n27 = new LinkedBinaryTree<String>(e27);
	  n12 = new LinkedBinaryTree<String>(e12, n24, n25);
      n13 = new LinkedBinaryTree<String>(e13, n26, n27);
      n6 = new LinkedBinaryTree<String>(e6, n12, n13);
      
	  n30 = new LinkedBinaryTree<String>(e30);
	  n31 = new LinkedBinaryTree<String>(e31);
	  n32 = new LinkedBinaryTree<String>(e32);
	  n33 = new LinkedBinaryTree<String>(e33);
	  n34 = new LinkedBinaryTree<String>(e34);
	  n35 = new LinkedBinaryTree<String>(e35);
	  n29 = new LinkedBinaryTree<String>(e29, n34, n35);
	  n28 = new LinkedBinaryTree<String>(e28, n32, n33);
	  n14 = new LinkedBinaryTree<String>(e14, n28, n29);
      n15 = new LinkedBinaryTree<String>(e15, n30, n31);
      n7 = new LinkedBinaryTree<String>(e7, n14, n15);
	  
	  n2 = new LinkedBinaryTree<String>(e2, n4, n5);
      n3 = new LinkedBinaryTree<String>(e3, n6, n7);

      tree = new LinkedBinaryTree<String>(e1, n2, n3);
   }

   /**-----------------------------------------------------------------
       Follows the movie tree based on user responses.
   ------------------------------------------------------------------*/
   public void examine()
   {
      Scanner scan = new Scanner(System.in);
      LinkedBinaryTree<String> current = tree;

      System.out.println ("So you need to find a movie huh...");
      while (current.size() > 1)
      {
         System.out.println (current.getRootElement());
         if (scan.nextLine().equalsIgnoreCase("N"))
            current = current.getLeft();
         else
            current = current.getRight();
      }

      System.out.println (current.getRootElement());
   }
}


