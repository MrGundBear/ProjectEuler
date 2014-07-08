import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class PE34
{	


    Map<Long, Long> map =new HashMap<Long, Long>();

    
	boolean debug = false;
	boolean debug2 = true;

	boolean prompt = true ;

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);



		int num = 5;
		int pick = 5;
		long start = System.currentTimeMillis();	
		PE34 pe = new PE34();

		pe.map.put(0L, 1L);

		System.out.println(pe.map);
		if(pe.prompt)
		{
			System.out.println("\n145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.\nFind the sum of all numbers which are equal to the sum of the factorial of their digits.\nNote: as 1! = 1 and 2! = 2 are not sums they are not included.\n");
	        System.out.print("\n\t\t\tWelcome to Problem 34 in Project Euler\n\t\tEnter limit for numbers to test :  ");
	        String choice = scanner.nextLine();
	        num = Integer.parseInt(choice);
	        start = System.currentTimeMillis();	

		}	
		pe.doLoops(num);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public void doLoops(long limit)
	{
		for(long i=10; i<=limit; i++)
		{
			if(debug)System.out.println("evaluating " + i);
			String temp = i+"";
			long sum = 0;
			for(int j=0; j<temp.length(); j++)
			{
				long val = Long.parseLong(temp.substring(j, j+1));
				long num;
				if(map.containsKey(val)) num = map.get(val);
				else num = fact(val);
				if(debug)System.out.println("\t" +val + "! = " + num);

				sum+=num;
			}
			if(sum == i)System.out.println("MATCH FOUND FOR NUM: " + i);
			if(debug)System.out.println(i + " -> " + sum);
			//System.out.println(i + "! = "  + fact(i));
			//System.out.println(i + "! = "  + factSlow(i));
		}
	}

	public long fact(long deg)
	{
		long curr = deg;

		while(map.containsKey(curr) == false)
		{
			curr--;
		}
		long base = map.get(curr);
		while(curr<deg)
		{
			curr++;
			base = base*curr;
			map.put(curr, base);
		}
		return base;
	}
}