import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;

public class PE32
{	
	boolean debug = false;
	boolean debug2 = true;

	boolean prompt = true ;

	//Solves in 0.199 seconds

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		int num = 5;
		int pick = 5;
		long start = System.currentTimeMillis();	
		PE32 pe = new PE32();


		if(pe.prompt)
		{
	        System.out.print("\n\t\t\tWelcome to Problem 32 in Project Euler\n\t\tFind pandigital multiplicants of length:  ");
	        String choice = scanner.nextLine();
	        num = Integer.parseInt(choice)+1;
	        System.out.print("\t\tEnter number limits for a / b:  ");
	        choice = scanner.nextLine();
	        pick = Integer.parseInt(choice);
	        start = System.currentTimeMillis();	
		}
		pe.bruteForce(num, pick);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public void bruteForce(int in, int max)
	{
		long sum = 0;
		ArrayList<Integer> sums = new ArrayList<Integer>();
		for(int i=0; i<max; i++)
		{
			if(i%51==0)System.out.print(".");
			for(int j=0; j<max; j++)
			{
				if(containsDoubles(j, max) == true)break;
				//if(countInt(i) + countInt(j) > max/2-1) break;
				if(checkNums(i,j, in))
				{
					if(sums.contains(new Integer(i*j)) == false)sums.add(i*j);
				}
			}
		}
		for(int i=0; i<sums.size(); i++)
		{
			sum += sums.get(i);
		}
		System.out.println("Total is: " + sum);
	}

	public boolean checkNums(int a, int b, int limit)
	{
		int count=0;
		int tempA=a;
		int tempB=b;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1; i<limit; i++)
		{
			nums.add(i);
		}
		while(tempA>0)
		{
			if(debug)System.out.println("found a " + tempA%10);
			if(nums.contains(tempA%10)) nums.remove(new Integer(tempA%10));
			else return false;
			count++;
			tempA = tempA/10;
		}
		while(tempB>0)
		{
			if(debug)System.out.println("found a " + tempB%10);
			if(nums.contains(tempB%10))nums.remove(new Integer(tempB%10));
			else return false;

			count++;
			tempB = tempB/10;
		}
		tempA = a*b;

		while(tempA>0)
		{
			if(debug)System.out.println("found a " + tempA%10);
			if(nums.contains(tempA%10))nums.remove(new Integer(tempA%10));
			else return false;
			count++;
			tempA = tempA/10;
		}

		if(debug)System.out.println(nums);
		if(nums.size() ==0)
		{
			System.out.println("FOUND: " + a + " * " + b + " = " + a*b);
			return true;
		}
		return false;
	}

	public boolean containsDoubles(int num, int limit)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1; i<limit; i++)
		{
			nums.add(i);
		}
		while(num>0)
		{
			//System.out.println("contains: " + num%10 + ": " + nums.contains(num%10));
			if(nums.contains(num%10)==true)nums.remove(new Integer(num%10));
			else return true;
			num = num/10;
		}
		return false;
	
	}

	public int countInt(int num)
	{
		int count = 0;
		while(num>0)
		{
			count++;
			num = num/10;
		}
		return count;
	}
}

