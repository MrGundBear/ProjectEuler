import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class PE36
{	
	//takes

    Map<String, Boolean> map;

    
	boolean debug = false;
	boolean debug2 = true;

	boolean prompt = true ;

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		int num = 5;
		int pick = 5;
		long start = System.currentTimeMillis();	
		PE36 pe = new PE36();

		if(pe.prompt)
		{
			System.out.println("\nThe decimal number, 585 = 10010010012 (binary), is palindromic in both bases.\nFind the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.\n(Please note that the palindromic number, in either base, may not include leading zeros.)\n");
	        System.out.print("\n\t\t\tWelcome to Problem 36 in Project Euler\n\t\tEnter limit for numbers to check:  ");
	        String choice = scanner.nextLine();
	        num = Integer.parseInt(choice);
	        start = System.currentTimeMillis();	

		}	
		pe.map = new HashMap<String, Boolean>(num);
		pe.doLoops(num);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
	}
	public void doLoops(int limit)
	{
		long sum = 0;
		for(int i=1; i<limit; i+=2)
		{
			//System.out.println("*Checking " + i);
			String bin = Integer.toBinaryString(i);
			String norm = ""+i;
			if(bin.charAt(0)=='1')
			{
				if(isPali(bin))
				{
					if(isPali(norm))
					{
						sum+=i;
					System.out.println("Match for " + norm + " in binary form: " + bin + " isPali(bin: " + isPali(bin) + " isPali(norm) " + isPali(norm));
				
					}
				}
			}
			
			//else System.out.println("\tReject for " + norm + " in binary form: " + bin + " isPali(bin: " + isPali(bin) + " isPali(norm) " + isPali(norm));

		}
		System.out.println("Sum is: " + sum);
	}

	public boolean isPali(String pal)
	{
		if(map.containsKey(pal))
		{
			//System.out.println("Returning cached " + pal + " " + map.get(pal));
			return map.get(pal);
		}
		ArrayList<String> minis = new ArrayList<String>();
		//System.out.println("\tChecking "+ pal );
		for(int i=0; i<pal.length()/2; i++)
		{
			String mini="chocaaa";
			mini=pal.substring(i, pal.length()-i);
			if(map.containsKey(mini))
			{
				//System.out.println("Returning cached mini:" + mini + " " + map.get(mini));

				return map.get(mini);
			}
			if(debug)System.out.println("adding mini: " + mini);
			if(mini.length()<pal.length() || mini.length()==1)minis.add(mini);
		
			if(pal.charAt(i) != pal.charAt(pal.length()-i-1)) 
			{
				map.put(pal,Boolean.FALSE);
				for(int j=0; j<minis.size(); j++)
				{
					if(minis.get(j).length()>1)map.put(minis.get(j), Boolean.FALSE);
				}			
				return false;
			}
		}
		map.put(pal, Boolean.TRUE);
		for(int i=0; i<minis.size(); i++)
		{
			map.put(minis.get(i), Boolean.TRUE);
		}
		return true;
	}
}