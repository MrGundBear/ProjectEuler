import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;

public class PE29
{	
	boolean debug = false;
	boolean debug2 = true;
	boolean prompt = true ;

	//Solves in 0.35 seconds

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		int num = 5;
		//int deg = 1000;

		long start = System.currentTimeMillis();	
		PE29 pe = new PE29();

		if(pe.prompt)
		{
	        System.out.print("\n\t\t\tWelcome to Problem 29 in Project Euler\n\t\tEnter the limit on a / b you want:  ");
	        String choice = scanner.nextLine();
	        start = System.currentTimeMillis();
	        num = Integer.parseInt(choice);
		}
		System.out.println("count: " + pe.makeCounts(num));
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public int makeCounts(int limit)
	{
		ArrayList<BigInteger> nums = new ArrayList<BigInteger>();
		for(int a=2; a<=limit; a++)
		{
		    if(a%3==0)System.out.print(".");
			for(int b=2; b<=limit; b++)
			{
				BigInteger num = (BigInteger.valueOf(a)).pow(b);
				if(nums.contains(num) == false)
				{
					nums.add(num);
				}
			}
		}
		return nums.size();
	}
}

