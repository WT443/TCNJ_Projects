/**
*  The TwentyQuestions class reads the file of questions, creates the appropriate 
*  tree and starts the game. Also a method to print the tree.
*
*  @author  Warren Smith
*/

package code;

import javafoundations.*;
import java.io.*;
import java.util.Scanner;

public class TwentyQuestions
{
   /** Creates the start of the tree. */
   private LinkedBinaryTree<String> tree;
   
   /**
   *  Constructor for the TwentyQuestions class.
   */
   public TwentyQuestions()
   {
		/** Sole purpose is to create movies object in the Driver class. */
   }

   /**
   *  Reads the file & sets up the 20 Questions tree.
   *
   *  @throws  an Exception is thrown if one is caught within this start process.
   */
   public void createTree() throws Exception
   {
	  File questions = new File("questions.txt"); /** 121 nodes in this tree */
  
	  /** Reads in each question/answer for the tree */
	  Scanner scan = new Scanner(questions);
	  
	  String e1 = scan.nextLine();
	  String e2 = scan.nextLine();
	  String e3 = scan.nextLine();
	  String e4 = scan.nextLine();
	  String e5 = scan.nextLine();
	  String e6 = scan.nextLine();
	  String e7 = scan.nextLine();
	  String e8 = scan.nextLine();
	  String e9 = scan.nextLine();
	  String e10 = scan.nextLine();
	  String e11 = scan.nextLine();
	  String e12 = scan.nextLine();
	  String e13 = scan.nextLine();
	  String e14 = scan.nextLine();
	  String e15 = scan.nextLine();
	  String e16 = scan.nextLine();
	  String e17 = scan.nextLine();
	  String e18 = scan.nextLine();
	  String e19 = scan.nextLine();
	  String e20 = scan.nextLine();
	  String e21 = scan.nextLine();
	  String e22 = scan.nextLine();
	  String e23 = scan.nextLine();
	  String e24 = scan.nextLine();
	  String e25 = scan.nextLine();
	  String e26 = scan.nextLine();
	  String e27 = scan.nextLine();
	  String e28 = scan.nextLine();
	  String e29 = scan.nextLine();
	  String e30 = scan.nextLine();
	  String e31 = scan.nextLine();
	  String e32 = scan.nextLine();
	  String e33 = scan.nextLine();
	  String e34 = scan.nextLine();
	  String e35 = scan.nextLine();
	  String e36 = scan.nextLine();
	  String e37 = scan.nextLine();
	  String e38 = scan.nextLine();
	  String e39 = scan.nextLine();
	  String e40 = scan.nextLine();
	  String e41 = scan.nextLine();
	  String e42 = scan.nextLine();
	  String e43 = scan.nextLine();
	  String e44 = scan.nextLine();
	  String e45 = scan.nextLine();
	  String e46 = scan.nextLine();
	  String e47 = scan.nextLine();
	  String e48 = scan.nextLine();
	  String e49 = scan.nextLine();
	  String e50 = scan.nextLine();
	  String e51 = scan.nextLine();
	  String e52 = scan.nextLine();
	  String e53 = scan.nextLine();
	  String e54 = scan.nextLine();
	  String e55 = scan.nextLine();
	  String e56 = scan.nextLine();
	  String e57 = scan.nextLine();
	  String e58 = scan.nextLine();
	  String e59 = scan.nextLine();
	  String e60 = scan.nextLine();
	  String e61 = scan.nextLine();
	  String e62 = scan.nextLine();
	  String e63 = scan.nextLine();
	  String e64 = scan.nextLine();
	  String e65 = scan.nextLine();
	  String e66 = scan.nextLine();
	  String e67 = scan.nextLine();
	  String e68 = scan.nextLine();
	  String e69 = scan.nextLine();
	  String e70 = scan.nextLine();
	  String e71 = scan.nextLine();
	  String e72 = scan.nextLine();
	  String e73 = scan.nextLine();
	  String e74 = scan.nextLine();
	  String e75 = scan.nextLine();
	  String e76 = scan.nextLine();
	  String e77 = scan.nextLine();
	  String e78 = scan.nextLine();
	  String e79 = scan.nextLine();
	  String e80 = scan.nextLine();
	  String e81 = scan.nextLine();
	  String e82 = scan.nextLine();
	  String e83 = scan.nextLine();
	  String e84 = scan.nextLine();
	  String e85 = scan.nextLine();
	  String e86 = scan.nextLine();
	  String e87 = scan.nextLine();
	  String e88 = scan.nextLine();
	  String e89 = scan.nextLine();
	  String e90 = scan.nextLine();
	  String e91 = scan.nextLine();
	  String e92 = scan.nextLine();
	  String e93 = scan.nextLine();
	  String e94 = scan.nextLine();
	  String e95 = scan.nextLine();
	  String e96 = scan.nextLine();
	  String e97 = scan.nextLine();
	  String e98 = scan.nextLine();
	  String e99 = scan.nextLine();
	  String e100 = scan.nextLine();
	  String e101 = scan.nextLine();
	  String e102 = scan.nextLine();
	  String e103 = scan.nextLine();
	  String e104 = scan.nextLine();
	  String e105 = scan.nextLine();
	  String e106 = scan.nextLine();
	  String e107 = scan.nextLine();
	  String e108 = scan.nextLine();
	  String e109 = scan.nextLine();
	  String e110 = scan.nextLine();
	  String e111 = scan.nextLine();
	  String e112 = scan.nextLine();
	  String e113 = scan.nextLine();
	  String e114 = scan.nextLine();
	  String e115 = scan.nextLine();
	  String e116 = scan.nextLine();
	  String e117 = scan.nextLine();
	  String e118 = scan.nextLine();
	  String e119 = scan.nextLine();
	  String e120 = scan.nextLine();
	  String e121 = scan.nextLine();

	  /** Creates nodes for tree */
      LinkedBinaryTree<String> n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20, n21, n22, n23, n24, n25, n26, n27, n28, n29, n30, n31, n32, n33, n34, n35, n36, n37, n38, n39, n40, n41, n42, n43, n44, n45, n46, n47, n48, n49, n50, n51, n52, n53, n54, n55, n56, n57, n58, n59, n60, n61, n62, n63, n64, n65, n66, n67, n68, n69, n70, n71, n72, n73, n74, n75, n76, n77, n78, n79, n80, n81, n82, n83, n84, n85, n86, n87, n88, n89, n90, n91, n92, n93, n94, n95, n96, n97, n98, n99, n100, n101, n102, n103, n104, n105 ,n106, n107, n108, n109, n110, n111, n112, n113, n114, n115, n116, n117, n118, n119, n120, n121;
      
	  /** Sets up and creates the tree in its proper shape */
	  n121 = new LinkedBinaryTree<String>(e121);
	  n120 = new LinkedBinaryTree<String>(e120);
	  
	  n119 = new LinkedBinaryTree<String>(e119);
	  n118 = new LinkedBinaryTree<String>(e118);
	  n117 = new LinkedBinaryTree<String>(e117, n120, n121);
	  n116 = new LinkedBinaryTree<String>(e116);
	  
	  n115 = new LinkedBinaryTree<String>(e115, n118, n119);
	  n114 = new LinkedBinaryTree<String>(e114);
	  n113 = new LinkedBinaryTree<String>(e113);
	  n112 = new LinkedBinaryTree<String>(e112, n116, n117);
	  
	  n111 = new LinkedBinaryTree<String>(e111, n114, n115);
	  n110 = new LinkedBinaryTree<String>(e110, n112, n113);
	  n109 = new LinkedBinaryTree<String>(e109);
	  n108 = new LinkedBinaryTree<String>(e108);
	  
	  n107 = new LinkedBinaryTree<String>(e107, n110, n111);
	  n106 = new LinkedBinaryTree<String>(e106, n108, n109);
	  n105 = new LinkedBinaryTree<String>(e105);
	  n104 = new LinkedBinaryTree<String>(e104);
	  
	  n103 = new LinkedBinaryTree<String>(e103, n106, n107);
	  n102 = new LinkedBinaryTree<String>(e102);
	  n101 = new LinkedBinaryTree<String>(e101);
	  n100 = new LinkedBinaryTree<String>(e100, n104, n105);
	  
	  n99 = new LinkedBinaryTree<String>(e99, n102, n103);
	  n98 = new LinkedBinaryTree<String>(e98, n100, n101);
	  n97 = new LinkedBinaryTree<String>(e97);
	  n96 = new LinkedBinaryTree<String>(e96);
	  
	  n95 = new LinkedBinaryTree<String>(e95, n98, n99);
	  n94 = new LinkedBinaryTree<String>(e94);
	  n93 = new LinkedBinaryTree<String>(e93);
	  n92 = new LinkedBinaryTree<String>(e92, n96, n97);
	  n91 = new LinkedBinaryTree<String>(e91);
	  n90 = new LinkedBinaryTree<String>(e90);
	  
	  n89 = new LinkedBinaryTree<String>(e89);
	  n88 = new LinkedBinaryTree<String>(e88);
	  n87 = new LinkedBinaryTree<String>(e87, n94, n95);
	  n86 = new LinkedBinaryTree<String>(e86, n92, n93);
	  n85 = new LinkedBinaryTree<String>(e85);
	  n84 = new LinkedBinaryTree<String>(e84, n90, n91);
	  
	  n83 = new LinkedBinaryTree<String>(e83, n88, n89);
	  n82 = new LinkedBinaryTree<String>(e82);
	  n81 = new LinkedBinaryTree<String>(e81, n86, n87);
	  n80 = new LinkedBinaryTree<String>(e80);
	  n79 = new LinkedBinaryTree<String>(e79, n84, n85);
	  n78 = new LinkedBinaryTree<String>(e78);
	  
	  n77 = new LinkedBinaryTree<String>(e77);
	  n76 = new LinkedBinaryTree<String>(e76, n82, n83);
	  n75 = new LinkedBinaryTree<String>(e75);
	  n74 = new LinkedBinaryTree<String>(e74);
	  n73 = new LinkedBinaryTree<String>(e73);
	  n72 = new LinkedBinaryTree<String>(e72);
	  n71 = new LinkedBinaryTree<String>(e71, n80, n81);
	  n70 = new LinkedBinaryTree<String>(e70, n78, n79);
	  
	  n69 = new LinkedBinaryTree<String>(e69);
	  n68 = new LinkedBinaryTree<String>(e68);
	  n67 = new LinkedBinaryTree<String>(e67);
	  n66 = new LinkedBinaryTree<String>(e66);
	  n65 = new LinkedBinaryTree<String>(e65, n76, n77);
	  n64 = new LinkedBinaryTree<String>(e64, n74, n75);
	  n63 = new LinkedBinaryTree<String>(e63);
	  n62 = new LinkedBinaryTree<String>(e62);
	  n61 = new LinkedBinaryTree<String>(e61, n72, n73);
	  n60 = new LinkedBinaryTree<String>(e60, n70, n71);
	  n59 = new LinkedBinaryTree<String>(e59);
	  n58 = new LinkedBinaryTree<String>(e58);
	  
	  n57 = new LinkedBinaryTree<String>(e57, n68, n69);
	  n56 = new LinkedBinaryTree<String>(e56);
	  n55 = new LinkedBinaryTree<String>(e55);
	  n54 = new LinkedBinaryTree<String>(e54);
	  n53 = new LinkedBinaryTree<String>(e53);
	  n52 = new LinkedBinaryTree<String>(e52, n66, n67);
	  n51 = new LinkedBinaryTree<String>(e51);
	  n50 = new LinkedBinaryTree<String>(e50);
	  n49 = new LinkedBinaryTree<String>(e49, n64, n65);
	  n48 = new LinkedBinaryTree<String>(e48);
	  n47 = new LinkedBinaryTree<String>(e47);
	  n46 = new LinkedBinaryTree<String>(e46, n62, n63);
	  n45 = new LinkedBinaryTree<String>(e45, n60, n61);
	  n44 = new LinkedBinaryTree<String>(e44);
	  n43 = new LinkedBinaryTree<String>(e43, n58, n59);
	  n42 = new LinkedBinaryTree<String>(e42);
	  
	  n41 = new LinkedBinaryTree<String>(e41, n56, n57);
      n40 = new LinkedBinaryTree<String>(e40, n54, n55);
	  n39 = new LinkedBinaryTree<String>(e39);
	  n38 = new LinkedBinaryTree<String>(e38, n52, n53);
	  n37 = new LinkedBinaryTree<String>(e37);
	  n36 = new LinkedBinaryTree<String>(e36);
	  n35 = new LinkedBinaryTree<String>(e35, n50, n51);
	  n34 = new LinkedBinaryTree<String>(e34);
      n33 = new LinkedBinaryTree<String>(e33);
	  n32 = new LinkedBinaryTree<String>(e32, n48, n49);
	  n31 = new LinkedBinaryTree<String>(e31);
	  n30 = new LinkedBinaryTree<String>(e30, n46, n47);
	  n29 = new LinkedBinaryTree<String>(e29, n44, n45);
	  n28 = new LinkedBinaryTree<String>(e28, n42, n43);
	  
	  n27 = new LinkedBinaryTree<String>(e27, n40, n41);
	  n26 = new LinkedBinaryTree<String>(e26);
	  n25 = new LinkedBinaryTree<String>(e25, n38, n39);
	  n24 = new LinkedBinaryTree<String>(e24, n36, n37);
	  n23 = new LinkedBinaryTree<String>(e23);
	  n22 = new LinkedBinaryTree<String>(e22, n34, n35);
	  n21 = new LinkedBinaryTree<String>(e21);
	  n20 = new LinkedBinaryTree<String>(e20, n32, n33);
	  n19 = new LinkedBinaryTree<String>(e19, n30, n31);
      n18 = new LinkedBinaryTree<String>(e18, n28, n29);

	  n17 = new LinkedBinaryTree<String>(e17);
	  n16 = new LinkedBinaryTree<String>(e16, n26, n27);
	  n15 = new LinkedBinaryTree<String>(e15);
	  n14 = new LinkedBinaryTree<String>(e14, n24, n25);
	  n13 = new LinkedBinaryTree<String>(e13, n22, n23);
      n12 = new LinkedBinaryTree<String>(e12, n20, n21);
      n11 = new LinkedBinaryTree<String>(e11);
      n10 = new LinkedBinaryTree<String>(e10, n18, n19);
	  
	  n9 = new LinkedBinaryTree<String>(e9, n16, n17);
	  n8 = new LinkedBinaryTree<String>(e8, n14, n15);
	  n7 = new LinkedBinaryTree<String>(e7, n12, n13);
	  n6 = new LinkedBinaryTree<String>(e6, n10, n11);
      
	  n5 = new LinkedBinaryTree<String>(e5, n8, n9);
      n4 = new LinkedBinaryTree<String>(e4, n6, n7);
	  
	  n3 = new LinkedBinaryTree<String>(e3, n4, n5);
	  n2 = new LinkedBinaryTree<String>(e2);

      tree = new LinkedBinaryTree<String>(e1, n2, n3);
   }

   /**
   *  Goes through the game using the LinkedBinaryTree class 
   *  and prints out the appropriate response at the end. 
   */
   public void playGame()
   {
      int reward = -1;
	  Scanner scan2 = new Scanner(System.in);
	  LinkedBinaryTree<String> current = tree;

      System.out.println ("It's time to play 20 Questions!!"); 
	  System.out.println ("  Type Y for yes and N for no"); 
	  System.out.println ("** Invalid input = yes answer **");
	  System.out.println ("");
      while (current.size() > 1)
      {
        System.out.println (current.getRootElement());
		if (scan2.nextLine().equalsIgnoreCase("N"))
		{
           current = current.getLeft();
	       reward++;
		}
        else
	    {
           current = current.getRight();
	       reward++;
		}
      }

      System.out.println (current.getRootElement());
	  if (reward == 0)
	  {
		System.out.println ("You automatically lose for trying to cheat.");
		System.out.println ("Player, your total point count is: " + reward + " (Disqualified)");
	  }
	  else
	  {
		System.out.println ("Yes that's it! CPU, you got the answer!");
		System.out.println ("Player, your total point count is: " + reward);
	  }	
   }
   
   /**
   *  Prints Tree at bgininng of program and what it is after it 
   *  is created at the end.
   */
   public void printTree()
   {
		LinkedBinaryTree<String> ptree = tree;
		
		if (ptree == null)
		{
			System.out.println ("This is a printout of the tree at the start of the program:");
			System.out.println ("Tree not created yet. It will be now to start game.");
			System.out.println ("");
			System.out.println ("");
		}
		else
		{
			System.out.println ("");
			System.out.println ("");
			System.out.println ("This is a printout of the tree now that it's been created:");
			System.out.println (ptree.toString());
		}
   }
}



