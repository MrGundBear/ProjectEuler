import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PE28
{	
	boolean debug = false;
	boolean debug2 = true;
	boolean prompt = true ;

	public static void main (String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		int num = 5;
		//int deg = 1000;



		long start = System.currentTimeMillis();	
		PE28 pe = new PE28();

		if(pe.prompt)
		{
	        System.out.print("\n\t\t\tWelcome to Problem 28 in Project Euler\n\t\tEnter the size of number spiral you want:  ");
	        String choice = scanner.nextLine();
	        start = System.currentTimeMillis();
	        num = Integer.parseInt(choice);
			//System.out.println("Done Loading " + pe.primesMain.size() + " primes under " + num+ ",  took " + ((System.currentTimeMillis() - start) / 1000.0) + " seconds");
	        //System.out.print("\t\tEnter the limits you want on your 'a' and 'b' variables:  ");
	       	//choice = scanner.nextLine();	
		}
		pe.calcQuickSum(num);
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");

	}
	
	//This fast solution solves in 0.1 seconds
	public long calcQuickSum(int width)
	{
	    int curr = 1;
	    long sum = 1;
	    int count = 1;
	    while(curr<width*width)
	    {
	        for(int i =0; i<4; i++)//four corners
	        {
	            int mult = count*2;
	            curr += mult;
	            System.out.println("adding "+ mult + " sum+=" + curr);
	            
	            sum+=curr;
	        }
	        count++;
	    }
	    System.out.println("sum is: " + sum);
	    return sum;
	}
	
	//Below is slow, easy to understand solution, takes around 10 seconds to solve 1001x1001
	
	public String makeSpiral(int width)
	{
		//max must be perfect square
		int val = width*width;
		Integer[][] spiral = new Integer[width][width];
		spiral[0][width-1]=val;
		int xCurr = width-1, yCurr=0;
		while(val>1)
		{
            while(xCurr>0)
            {
                if(spiral[yCurr][xCurr-1] == null)
                {
                    val--;
                    xCurr--;
                    spiral[yCurr][xCurr] = val;
                }
                else break;
            }
            while(yCurr<width-1)
            {
                if(spiral[yCurr+1][xCurr] == null)
                {
                    val--;
                    yCurr++;
                    spiral[yCurr][xCurr] = val;
                }
                else break;
            }
            while(xCurr<width-1)
            {
                if(spiral[yCurr][xCurr+1] == null)
                {
                    val--;
                    xCurr++;
                    spiral[yCurr][xCurr] = val;
                }
                else break;
            }
            while(yCurr>0)
            {
                if(spiral[yCurr-1][xCurr] == null)
                {
                    val--;
                    yCurr--;
                    spiral[yCurr][xCurr] = val;
                }
                else break;
            }

		}
		printSpiral(spiral);
		return "";
	}
	
	public void printSpiral(Integer[][] array)
	{
	    String diags = "";
	    long sum = 0;
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array.length; j++)
            {
                System.out.print(array[i][j]+ "\t");
            }
            System.out.println();
        }
        int j=0;
        for(int i=0; i<array.length; i++)
        {
            diags += array[i][j] + ", ";
            sum+=array[i][j];
            j++;
        }
        j--;
        for(int i=0; i<array.length; i++)
        {
            if(array[i][j]!=1)
            {
                diags += array[i][j] + ", ";
                sum+=array[i][j];
            }
            j--;
        }
        System.out.println(diags + ": sum " + sum);
        
	}
}

