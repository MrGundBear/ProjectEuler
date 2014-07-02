import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*output
Longest is: 982 for 1/983

TOOK 2.551 SECONDS
*/

public class PE26
{	
	boolean debug = true;
	boolean debug2 = true;

	int res = 2000;

	public static void main (String[] args) throws Exception
	{
		long start = System.currentTimeMillis();	
		PE26 pe = new PE26();
		//pe.makePrimes(1000);
		
		int to =  1000;
		int longest = 0;
		int chosen = 0;
		ArrayList<Integer> zeroes = new ArrayList<Integer>();
		//ArrayList<Integer> primes = pe.makePrimes(to);

		int evens = 0, odds =0;

		for (int i=1; i<to; i+=2)
		{
			if(i%5!=0)
			{
				long start2 = System.currentTimeMillis();
				int num2 = pe.returnRepeats(i);
				if(i %2 == 0)evens+=num2;
				else odds+=num2;
				if(num2 > longest)
				{
					longest = num2;
					chosen = i;
				}
				if(num2 == 0)
				{
					zeroes.add(i);
				}
				System.out.println("\t" + num2 +" repeating digits - Time Taken: " +((System.currentTimeMillis() - start2) / 1000.0)+" seconds.");				
			}

		}
		System.out.println("\nLongest is: " + longest +" for 1/" + chosen);
		//System.out.println("Odds: " + odds + "/" + to + "=" +odds/to);
		//System.out.println("Evens: " + evens + "/" + to + "=" +evens/to);

		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
		System.out.println(zeroes);
	}

	public int returnRepeats(int numerator)
	{
		System.out.println("\n1/" + numerator);
		BigDecimal temp = makeDiv(numerator);
		//returns length of repeating digits
		String num =(""+temp).substring(2);

		//get x chars from string
		//do a regex check to see how many instances appear in string
		//If regex <repeatingDigits>{4} we know it is a repeating string

		boolean found = false;
		String regex = "\\d";
		boolean valid=true;
		String longest = "";
		int steps =0;

		String oldLongest = "";


		for(int j=0; j<20; j++)
		{
			oldLongest = longest;

			if(longest.length()>1)break;
		    longest = "";
		    steps = 0;
		    for(int i=0; i<(num.length()-j)/2; i++)
	        {
	        	
				
	            //here, if we know longest has length of x, we know we can start at 0+j, i+j+longest.length
	            regex = num.substring(0+j,i+j+longest.length());
	            if(regex.length() < longest.length())break;

	            if(regex.contains(longest) && longest.equals("")==false)break;

	            Pattern pattern =  Pattern.compile(regex);
	            Matcher matcher = pattern.matcher(num);
	            int start = 0;
	            if(matcher.find() == true) start = matcher.start();
	            else start = 0;
	            
	            valid = true;
	            String match = "";
	            steps++;
	            int count=0;
	            while (matcher.find())
	            {
	            	if(count>4)
	            	{
	            		break;
	            	}
	            	else count++;
	                start+=regex.length();
	                //System.out.println("start: "+ start + "  end: " + matcher.start());
	                if(matcher.start()==start)
	                {
	                    match = matcher.group();
	                    if(match.length()>longest.length())
	                    {
	                    	if((longest.equals("")||match.indexOf(longest) == -1))
	                    	{
	                    		longest = match;
	                    	}
	                    }
	                    else break;
	                }
	                else break;
	            }
	        }
		}
		if(debug)System.out.println("\t\tValid: " + valid + " Steps: " + steps);
		if(debug)System.out.println(temp+ "\t\t\t\"" + longest+"\"");
		return longest.length();
		
	}

	public BigDecimal makeDiv(long div)
	{
		return (new BigDecimal(1.0)).divide(new BigDecimal(div+0.0),res, RoundingMode.HALF_UP);
	}
}

