/***********************************************************
*  Driver.java
*  - Main class that runs the system
*
*  @author  Warren Smith
***********************************************************/

import java.io.*;
import java.util.*;

public class Driver
{
	/** Main driver method that runs the whole system */
	public static void main(String[] args) throws IOException
	{
		// Print out start up messages
		System.out.println("\n" + "\n" + "Welcome to the Keyword Search System");
		System.out.println("------------------------------------");
		System.out.println("");
		
		// Prompts for entering a file
		Scanner sc1 = new Scanner(System.in);
		System.out.print("First, enter your file name (.txt only): ");
		System.out.flush();
		String filename = sc1.nextLine();
		
		//Reads in entire file to variable "txt"
		FileReader fileReader = new FileReader(filename);
		String txt = "";
		int j;
		while((j =  fileReader.read())!=-1)
		{
			char ch = (char)j;
			txt = txt + ch; 
		}
		
		//Prompts for # of keywords to be entered
		System.out.println("");
		Scanner sc2 = new Scanner(System.in);
		System.out.print("How many keywords would you like to search for? ");
		int key = sc2.nextInt(); 
		System.out.println("" + "\n");
		
		// Creates a new SubStringSearch object for the calculations
		SubStringSearch run = new SubStringSearch();
		
		//Loops to calculate for each keyword entered
		for(int i = 0; i < key; i++)
		{
			int num = i+1;
			
			Scanner sc3 = new Scanner(System.in);
			System.out.print("Enter keyword #" + num + " (case sensitive): ");
			System.out.flush();
			String ptn = sc3.nextLine();
			
			double n = txt.length();	//get the lenght of the given text
			int m = ptn.length();	//get the lenght of the pattern given
			int hashOfPatt = ptn.hashCode(); 	//get the hash value of the pattern
		
			run.search(txt,ptn,n,m,hashOfPatt);
			run.calc(n);
		} 
		
		//Prompts and runs final verdict
		System.out.println("=========================================================");
		System.out.println("Calculating usage percentage of keyword(s) in the file...");
		System.out.println("");
		run.verdict();
		System.out.println("");
		System.out.println("Goodbye!" + "\n");
	}
}

