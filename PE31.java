import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;

public class PE31
{	
	boolean debug = false;
	boolean debug2 = true;

	boolean prompt = true ;

	//Solves in 0.199 seconds

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		int num = 5;

		long start = System.currentTimeMillis();	
		PE31 pe = new PE31();

		if(pe.prompt)
		{
	        System.out.print("\n\t\t\tWelcome to Problem 31 in Project Euler\n\t\tEnter the amount of money:  ");
	        String choice = scanner.nextLine();
	        num = Integer.parseInt(choice);
	        start = System.currentTimeMillis();	
		}
		System.out.println("Count: " + pe.calcNumOfWaysQuick2(num));
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public long calcNumOfWaysQuick(int money)
	{
		long ways = 0;
		for (int a = money; a >= 0; a -= 200) {
		    for (int b = a; b >= 0; b -= 100) {
		        for (int c = b; c >= 0; c -= 50) {
		            for (int d = c; d >= 0; d -= 20) {
		                for (int e = d; e >= 0; e -= 10) {
		                    for (int f = e; f >= 0; f -= 5) {
		                        for (int g = f; g >= 0; g -= 2) {
		                            ways++;
		                        }
		                    }
		                }
		            }
		        }
		    }
		}
		return ways;
	}

	public long calcNumOfWaysQuick2(int money)
	{
		int target = money;
		int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
		long[] ways = new long[target+1];
		ways[0] = 1;
		 
		for (int i = 0; i < coinSizes.length; i++) {
		    for (int j = coinSizes[i]; j <= target; j++) {
		        ways[j] += ways[j - coinSizes[i]];
		    }
		}

		return ways[target];
	}


}

