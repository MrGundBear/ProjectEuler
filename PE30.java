import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;

public class PE30
{	
	boolean debug = false;
	boolean debug2 = true;

	boolean prompt = true ;

	//Solves in 1.51 seconds

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		int num = 5;
		//int deg = 1000;
		int pow = 4;
		long start = System.currentTimeMillis();	
		PE30 pe = new PE30();

		if(pe.prompt)
		{
	        System.out.print("\n\t\t\tWelcome to Problem 30 in Project Euler\n\t\tEnter the length you want:  ");
	        String choice = scanner.nextLine();
	        num = Integer.parseInt(choice);
	        System.out.print("\t\tEnter the powers you want:  ");
	        choice = scanner.nextLine();
	        start = System.currentTimeMillis();
	        pow = Integer.parseInt(choice);
		}
		pe.findPowers(num, pow);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public long findPowers(int length, int power)
	{
		//splitInt(12345);
		//if length = 4, evaulate all 4 digit nums
		int lower = 1;
		long sum = 0;
		for(int i=0; i<length-1; i++)
		{
			lower*=10;
		}
		int upper = lower*10 -1;
		System.out.println("Calcing power for numbers of length "+ length + " (from " + lower + " to " + upper+")");
		for(int i=0; i<upper; i++)
		{
			long temp = calcSum(splitInt(i), power, i);
			if(temp==i)
			{
				System.out.println(i + " is a match");
				if(i>1)sum+=i;
			}
		}
		System.out.println("\nTotal is: " + sum);
		return sum;
	}

	public ArrayList<Integer> splitInt(int split)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int count = split;
		while(count > 0)
		{
			nums.add(count%10);
			count = count/10;
		}
		if(debug)System.out.println(split + ": " + nums);
		return nums;
	}

	public long calcSum(ArrayList<Integer> in, int power, int orig)
	{
		int sum = 0;
		for(int i=0; i<in.size(); i++)
		{
			int num = (int)Math.pow(in.get(i), power);
			sum+= num;
			if(debug)System.out.println("adding " + num);
			if(sum>orig)return orig+1;
		}
		if(debug)System.out.println("sum: " + sum);
		return sum;
	}
}

