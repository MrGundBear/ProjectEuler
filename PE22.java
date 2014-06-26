import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;

public class PE22
{
	
	public static void main (String[] args) throws Exception
	{
		PE22 pe = new PE22();
		ArrayList<String> array = pe.scanFile();
		long total = 0;
		for(int i=0; i<array.size(); i++)
		{
			int val = pe.calcNameScore(array.get(i), i+1);
			total+=val;

			if(i==937)
			{	
				System.out.println(array.get(i) + ": " + val);

			}
		}
		System.out.println("Final num is: " + total);
		
	}

	public int calcNameScore(String name, int rank)
	{
		int total =0;
		name = name.toLowerCase();
		for(int i=0; i<name.length(); i++)
		{
			int val = name.charAt(i)-96;
			//System.out.println(name.charAt(i) + ": " + val);
			total+=val;
		}
		return total*rank;
	}

	public ArrayList<String> scanFile() throws Exception
	{
		//returns sorted array
		Scanner sc = new Scanner(new File("names.txt"));
     	String[] names = sc.next().split("\",\"");	//whole file split
     	names[0]=names[0].substring(1);
     	names[names.length-1]=names[names.length-1].substring(0,names[names.length-1].length()-1);

     	ArrayList<String> sorted = new ArrayList<String>();

    	for(int i=0; i<names.length; i++)
     	{	
     		sorted.add(names[i]);
     		System.out.println(names[i]);
     	}
     	Collections.sort(sorted);
     	return sorted;
	}

}