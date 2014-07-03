import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PE27
{	
	boolean debug = false;
	boolean debug2 = true;
	boolean prompt = true;
	int deg = 1000;

	ArrayList<Integer> primesMain;

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		int num = 500000;
		//int deg = 1000;



		long start = System.currentTimeMillis();	
		PE27 pe = new PE27();

		if(pe.prompt)
		{
	        System.out.print("\n\t\t\tWelcome to Problem 27 in Project Euler\n\t\tEnter the number of prime numbers you want to generate:  ");
	        String choice = scanner.nextLine();
	        start = System.currentTimeMillis();
	        num = Integer.parseInt(choice);
			pe.primesMain = pe.makePrimes(num);
			System.out.println("Done Loading " + pe.primesMain.size() + " primes under " + num+ ",  took " + ((System.currentTimeMillis() - start) / 1000.0) + " seconds");
	        System.out.print("\t\tEnter the limits you want on your 'a' and 'b' variables:  ");
	       	choice = scanner.nextLine();
	        pe.deg = Integer.parseInt(choice);		
		}
		start = System.currentTimeMillis();

		//System.out.println(pe.primesMain);
		//System.out.println("\n"+pe.eqTestPrimes(1,41,39));
		if(pe.deg%2==0)pe.deg++;
		pe.loopValues(pe.deg);

		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");


	}

	public void loopValues(int limit)
	{
		String passes = "";
		int count =0;
		int bestN = 1;
		int bestA = 0,bestB=0;
		for(int a=-limit; a<limit; a+=2)
		{
			if(debug2 && a%13==0)System.out.print(".");
			for(int b=-limit; b<limit; b+=2)
			{
				if(isPrime(b) == true && a*2+b<deg)
				{
					int max = 0;
					for(int n=bestN; n<limit; n++)
					{
						boolean test = eqTestPrimes(a,b,n);
						//System.out.print(test);

						if(test == true)
						{
							if(n>max)
							{
								if(max>bestN)
								{
									//bestN = max;
									bestA = a;
									bestB = b;
								}
								max = n;
							}
						}
						else break;
					}
					if(max>bestN)
					{
						bestN=max;
						count++;
						passes+="\nn^2 + " +a+"n" + " + " +b +" from n=0 to n="+max;

					}
				}
				

			}
		}
		System.out.println("PASSING FORMULAS "+count+" equations "+passes);
		System.out.println("\nBest is: " + "n^2 + " +bestA+"n" + " + " +bestB +" from n=0 to n="+bestN);
		System.out.println(getSequence(bestA, bestB, bestN));
	}

	public boolean eqTestPrimes(int a, int b, int n)
	{
		// n^2 + a*n + b for n=0->n
		if(debug)System.out.println("\t\tn^2 + " +a+"n + " +b);
		
		for(int i=0; i<n; i++)
		{
			int result = i*i + a*i + b;
			boolean test = isPrime(result);
			if(debug)System.out.print(result+ ",");
			//if(test==true)System.out.println("n: " + i+ "    "  + i+"^2 + " + a + "*" +i+" + " + b + " = " + result + "  prime? : " + test);
			if(test == false)return false;
		}
		if(debug)System.out.print(" from n=0 to n="+n+"\n");
		return true;
	}

	public boolean isPrime(int num)
	{
		for(int i=2; i<20; i++)
		{
			if(num%i==0 && num>1)return false;
		}

		for(int i=0; i<primesMain.size(); i++)
		{
			if(primesMain.get(i) == num)return true;
		}
		return false;

		//return primesMain.contains(new Integer(num));
	}


	public ArrayList<Integer> makePrimes(int degree)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=2; i<degree;i++)
		{
			if(i%2!=0 && i%3!=0 && i%4!=0 &&i%5!=0|| i==2)
			{
				result.add(i);

			}
		}
		for(int i=2; i<degree/2; i++)
		{
			//for i, remove all array values that are multiples of i
		    //ex: for 2, remove value of 2,4, 6, 8    for 3 remove 3,6,9,
			for(int j=2; j<result.size()/j; j++)
			{
				if(j%2 != 0&& i%3!=0 && i%4!=0 &&i%5!=0)
				{
			    	result.remove(new Integer(j*i));

				}
			}
		}
		return result;
	}

	public String getSequence(int a, int b,int n)
	{
		String result = "";
		for(int i=0; i<n;i++)
		{
			result+= i*i + a*i + b + ", ";
		}
		return result;
	}
}

