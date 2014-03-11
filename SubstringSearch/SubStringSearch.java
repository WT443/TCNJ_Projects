/*****************************************************************
*  SubStringSearch.java
*  - Defines substring search algorithm & calculations
*
*  @author  Warren Smith
*****************************************************************/

import java.text.*;

/** Class defines substring search algorithm & calculations */
class SubStringSearch
{
	double count = 0;
	double totPer = 0;

	SubStringSearch()
	{
		//Default constructor
	}
	
	/** Substring search algorithm */
	public void search(String txt, String ptn, double n, int m, int hashOfPatt)
	{	
		// Loop runs to initiate substring search
		for(int i = 0; i < n; i++)
		{
			if(i+m+1 <= n)
			{
				String sub = txt.substring(i,i+m);	// Split the text consecutively by length of the pattern

				int hashOfSub = sub.hashCode(); 	// Check hash of the text and hash of the pattern match each other

				if(hashOfPatt == hashOfSub)
				{ 	
					// If the pattern and text tallies, then start character by character checking
					int k = 0;
					boolean d = true;

					// Loop runs through both the selected parts to check whether a match of each other
					for(int j = i; j < i+m; j++)
					{ 
						if(txt.charAt(j) == ptn.charAt(k))
						{ 
							k++;
						}
						else
						{
							d = false;
							break; // End of loop when an unmatchable part found
						}
					}
				
					if(d)
					{
						count++;
					}
				}
			}
		}
	}
	
	/** Method that counts the # of times keywords used, percentage, and total percentage */
	public void calc(double n)
	{
		double per = (count/n)*100; //calculates percentage
		System.out.println("This keyword is found " + (int)count + " times within the file.");
		System.out.println(""); 
		
		count = 0; // Resets count after each keyword
		totPer = totPer + per; //calculate total percentage of all keywords combined
	}
	
	
	/** Method that gives final verdict on keyword calculations */
	public void verdict()
	{
		double limit = 0.10; // Sets limit for what total percentage needs to be to give a "YES" or "NO"
		DecimalFormat df = new DecimalFormat("#.##");
		
		if(totPer >= limit)
		{
			System.out.println("The keyword(s) entered count for " + df.format(totPer) + "% of this document.");
			System.out.println("Based on that: YES, keyword(s) sufficiently present.");
		}
		else
		{
			System.out.println("The keyword(s) entered count for " + df.format(totPer) + "% of this document.");
			System.out.println("Based on that: NO, keyword(s) not sufficiently present.");
		}
	}
}

