import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;

public class PE24
{	
	boolean debug = false;
	boolean debug2 = true;
	public static void main (String[] args) throws Exception
	{

		long start = System.currentTimeMillis();
		
		PE24 pe = new PE24();
		pe.newLexo(9);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
		
	}

	public void newLexo(int limit)
	{
		ArrayList<Long> nums = new ArrayList<Long>();
		for(long i=0123456; i<100000000L; i++)
		{
			if(i%1000==0)System.out.print(".");
			boolean valid = true;
			int total=0;
			for(int j=0; j<=limit; j++)
			{
				
				if( countOccurs(i+"", j, limit) == 1)
				{
					total++;
				}
				
			}
			//System.out.println(i + " has " + total + " matches");
			if(total==limit+1)System.out.println(i);
		}
	}

	public int countOccurs(String in, int val, int limit)
	{
		while(in.length()<=limit)
		{
			in = "0"+in;
		}
		int count = 0;
		for(int i=0; i<in.length(); i++)
		{
			if((in.charAt(i)+"").equals(val+""))count++;
		}
		//System.out.println("count of " + val + " in " + in + " is " + count);
		return count;
	}

	public void findLexo(int limit)
	{
		ArrayList<Long> nums = new ArrayList<Long>();
		
		String start = "";
		for(int i=0; i<=limit; i++)
		{
			start+=i;
		}
		String walk = start;
		
		System.out.println(walk);

		int length = walk.length();
		for(int i=0; i<length-1; i++)
		{
			//swap, ABC -> CAB
			walk = swapVals(walk, 0, length-1);
			
			nums.add(Long.parseLong(walk));
			System.out.println("\tswap: " + walk);
			for(int j=0; j<length-1; j++)
			{
				//Push down: CAB -> CBA -> ABC
				walk = swapVals(walk, length-j-1, length-j-2);
				System.out.println("push: " +walk);
				nums.add(Long.parseLong(walk));

			}
			
		}
		Collections.sort(nums);
		System.out.println(nums);

		//System.out.println("num: " + nums.get(10);

	}



	public String swapVals(String in, int swap1, int swap2)
	{
		char[] temp = in.toCharArray();
		char t = temp[swap1];
		temp[swap1]=temp[swap2];
		temp[swap2]=t;
		String result = new String(temp);
		return result;
	}

}

