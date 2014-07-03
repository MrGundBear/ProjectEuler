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
		System.out.println("Count: " + pe.calcNumOfWays(num));
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}

	public long calcNumOfWays(int money)
	{
		long count = 0;
		int sum = 0;
		for(int i=0; i<=money/1; i++)	//for 1p piece
		{
			if(i%3==0)System.out.print(".");
			sum=i;
			for(int j=0; j<=money/2; j++)	//for 2p piece
			{
				sum = i+j*2;
				if(sum>money)break;
				for(int k=0; k<=money/5; k++)	//for 5p piece
				{
					sum = i + 2*j + k*5;
					if(sum>money)break;
					for(int l=0; l<=money/10; l++)	//for 10p piece
					{
						sum = i + 2*j + k*5 + l*10;
						if(sum>money)break;
						for(int m=0; m<=money/20; m++)	//for 20p piece
						{
							sum = i + 2*j + k*5 + l*10 + m*20;
							if(sum>money)break;
							for(int n=0; n<=money/50; n++)	//for 50p piece
							{
								sum = i + 2*j + k*5 + l*10 + m*20 + n*50;
								if(sum>money)break;
								for(int o=0; o<=money/100; o++)	//for 100p piece
								{
									sum = i + 2*j + k*5 + l*10 + m*20 + n*50 + o*100;
									if(sum>money)break;
									for(int p=0; p<=money/200; p++)	//for 200p piece
									{
										sum = i + 2*j + k*5 + l*10 + m*20 + n*50 + o*100 + p*200;
										if(sum>money)break;
										else if(sum == money)
										{
											if(debug)System.out.println("1p: " + i + "  2p: " + j + "  5p: " + k + "  10p: " + l + "  20p: " + m + "  50p: " + n + "  100p: " + o +  "  200p: " + p);
											count++;
										}
									}	
								}	
							}						
						}
					}
				}
			}
		}
		return count;
	}
}

