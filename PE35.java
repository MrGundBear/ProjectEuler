import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class PE35
{	
	//takes

    Map<Integer, Boolean> map;

    
	boolean debug = false;
	boolean debug2 = true;

	boolean prompt = true ;

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		int num = 5;
		int pick = 5;
		long start = System.currentTimeMillis();	
		PE35 pe = new PE35();

		if(pe.prompt)
		{
			System.out.println("\nThe number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.\nThere are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.\nHow many circular primes are there below one million?\n");
	        System.out.print("\n\t\t\tWelcome to Problem 35 in Project Euler\n\t\tEnter limit for numbers to check:  ");
	        String choice = scanner.nextLine();
	        num = Integer.parseInt(choice);
	        start = System.currentTimeMillis();	

		}	
		pe.makePrimes(num);
		pe.doLoops(num);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public boolean makeRotations(int num)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		String val = num+"";
		boolean check = true;
		for(int i=0; i<val.length(); i++)
		{
			String mod = val.substring(i)+val.substring(0,i);
			if(isPrime(Integer.parseInt(mod)) == false)
			{
				check=false;
				break;
			}
			//System.out.println(mod + " isPrime: " + isPrime(Integer.parseInt(mod)));
		}
		return check;
		
	}

	public boolean isPrime(int num)
	{
		return map.get(num);
	}

	public void doLoops(int limit)
	{
		int i=2;
		int count =0;
		while(i<limit)
		{
			if(map.containsKey(i))
			{
				if(map.get(i))
				{
					if(makeRotations(i))
					{
						System.out.println(i);
						count++;

					}
					//System.out.println(i + ": " + map.get(i));
				}
			}
			
			i++;
		}
		System.out.println("count: " + count);
	}

	public void makePrimes(int limit)
	{
		map = new HashMap<Integer, Boolean>(limit/2);

		for(int i=2; i<limit; i++)
		{
			map.put(new Integer(i), Boolean.TRUE);
		}
		for(int i=2; i<limit/2; i++)
		{
			//here find the next non crossed out prime
			while(map.get(i) == false && i<limit/2)
			{
				i++;
			}
			//System.out.println("Now removing mults of: " + i);
			for(int j=i; j<=limit/i; j++)
			{
				if(i*j != 2 && map.containsKey(i*j))
				{

					map.put(new Integer(i*j), Boolean.FALSE);
				}
				
			}
		}
		//System.out.println(map + " count: " + map.size());
	}

}