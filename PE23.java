import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;

public class PE23
{	
	boolean debug = false;
	boolean debug2 = true;
	int size = 28123;
	ArrayList<Integer> abNums;
	public static void main (String[] args) throws Exception
	{

		long start = System.currentTimeMillis();
		PE23 pe = new PE23();
		pe.findAbundantNums();
		pe.findAbSums();
		System.out.println("TOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
		
	}

	public boolean canBeSum(int num)
	{
		int steps = 0;
		for(int i=0; i<abNums.size(); i++)
		{
			if(abNums.get(i) > num) break;
			for(int j=0; j<abNums.size(); j++)
			{	
				steps++;
				int sum=abNums.get(i)+abNums.get(j);
				if(num == sum) 
				{
					System.out.println(num + " can be expressed as a sum of two abundant numbers (" +abNums.get(i) + " + " + abNums.get(j) + "), steps: " + steps);	
					return true;	
				}
				else if(sum>num)
				{
					//System.out.println("\t\t\t\t\t\t\t\tTOO BIG!");
					break;
				}
			}
			
		}
		System.out.println("\t"+num + " cannot be, steps: " + steps + "                                 &&&&&&&&&&&&&&&&****************");	

		return false;
	}


	public void findAbSums()
	{
		long sum = 0;	//this will hold all numbers that cannot be expressed as sums
		for(int i=0; i<size; i++)
		{

			//boolean found = false;
			boolean choice = canBeSum(i);	//if false then add to sum
			if(choice == false)
			{
				sum += i;
			}
		}
		System.out.println("Final sum is: " + sum);
	}

	public void findAbundantNums()
	{
		abNums  = new ArrayList<Integer>();
		for(int i=0; i<size; i++)
		{
			int sum =0;
			if(debug)System.out.println("\tTesting " + i);
			for(int j=1; j<i; j++)
			{
				if(i%j == 0)
				{
					sum +=j;
					if(debug)System.out.println("Adding " + j + " to sum: " + sum);
				}
				
			}
			if(debug)System.out.println("Num: "+ i + " sumTotal: " + sum);
			if(sum > i) 
			{
				abNums.add(i);
				//if(debug2)System.out.println(i + " is an abundantNumber");
			}
			//else if(sum<i)  System.out.println(i + " is an deficientNumber");
			//else System.out.println(i + " is a perfect number");
		}
		if(debug)System.out.println(abNums);
		System.out.println(abNums.size() + " abundant Sums succesfully loaded, abNums[0] = " + abNums.get(0) + " abNums[" + (abNums.size()-1) + "] = " + abNums.get(abNums.size()-1));
	}


}