import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.HashSet;

public class PE33
{	
	boolean debug = false;
	boolean debug2 = true;

	boolean prompt = true ;

	HashSet hash;
	ArrayList<Pair> solutions = new ArrayList<Pair>();

	//Solves in 0.199 seconds

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println((new Pair(100, 200)).reduce());
		int num = 5;
		int pick = 5;
		long start = System.currentTimeMillis();	
		PE33 pe = new PE33();

		pe.hash = new HashSet();

		if(pe.prompt)
		{
	        System.out.print("\n\t\t\tWelcome to Problem 33 in Project Euler\n\t\tEnter limit for numerator/denominator (default is 99):  ");
	        String choice = scanner.nextLine();
	        num = Integer.parseInt(choice);
	        start = System.currentTimeMillis();	

		}
		pe.testVals(num);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public void testVals(int limit)
	{
		for(int i=10; i<limit; i++)
		{
			for(int j=10; j<limit; j++)
			{
				if(i<j)
				{
					Pair p = new Pair(i,j);
					for(int k=1; k<10; k++)
					{
						Pair temp = p.removeNum(k);
						if(p.getFrac().equals(temp.getFrac()) && (p.one != temp.one || p.one != temp.one))
						{
							if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0))
								System.out.println("found match for " + p);
							if(debug)System.out.println(p + " " + p.getFrac() + " : remove: " + k + " " + temp + " " +temp.getFrac());
							solutions.add(p);
						}

					}	
				}
			}
		}
		System.out.println(solutions.size()+" results found, multiplying together to be: " +testSolutions());
	}

	public Pair testSolutions()
	{
		Pair sum = new Pair(1,1);
		for(int i=0; i<solutions.size(); i++)
		{
			sum = (sum.mult(solutions.get(i))).reduce();
		}
		return sum;
	}

}



class Pair
{
	int one, two;
	Double value=0.0;
	public Pair(int a, int b)
	{
		one = a;
		two = b;
	}
	public Double getFrac()
	{
		if(two==0)return -1.0;
		if(value==0)value = one/(two+0.0);
		return value;
	}
	public String toString()
	{
		return one + "/" + two;
	}

	public Pair removeNum(int num)
	{
		//this will remove one num from Pair
		int a = one;
		int b = two;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(a>0)
		{
			list.add(a%10);
			//System.out.println("  " + a%10);
			a = a/10;
		}
		while(list.contains(num))
		{
			list.remove(new Integer(num));
		}
		//System.out.println("list: " + list);
		a=0;
		for(int i=0; i<list.size(); i++)
		{
			a += list.get(i)*Math.pow(10, i);
		}
		list.clear();
		while(b>0)
		{
			list.add(b%10);
			b = b/10;
		}
		while(list.contains(num))
		{
			list.remove(new Integer(num));
		}
		b=0;
		for(int i=0; i<list.size(); i++)
		{
			b += list.get(i)*Math.pow(10, i);
		}
		list.clear();
		return new Pair(a,b);
	}

	public Pair mult(Pair pair)
	{
		//System.out.println("Multing " + one*pair.one + " / " + two*pair.two);
		return new Pair(one*pair.one, two*pair.two);
	}

	public Pair reduce()
	{
		int a = one;
		int b = two;
		while(b%a==0 && a>1)
		{
			//System.out.println(a+ " , " + b);
			int t = a;
			a = a/a;
			b = b/t;
			//System.out.println(a+ " , " + b);
		}
		return new Pair(a,b);
	}

}

