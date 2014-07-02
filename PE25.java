import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PE25
{	
	boolean debug = false;
	boolean debug2 = true;
	public static void main (String[] args) throws Exception
	{

		long start = System.currentTimeMillis();
		PE25 pe = new PE25();

		System.out.println(pe.findFibOfLength(1000));
		System.out.println("\nTOOK " + ((System.currentTimeMillis() - start) / 1000.0) + " SECONDS");
		
	}


	public BigInteger findFibOfLength(int length)	
	{
		int i = 4780;
		while(true)
		{

			BigInteger num = binetFib(i);
			System.out.println("fib(" + i + ") = " + num);
			int numLength = (num+"").length();
			if(numLength>=length)
			{
				System.out.println("fib(" + i + ") = " + num);
				 return num;
			}
			i++;
		}
	}

	public BigInteger binetFib(int num)
	{
		BigDecimal gold  =  BigDecimal.valueOf((1.00+Math.sqrt(5))/2);
		BigDecimal result = (gold.pow(num).subtract((BigDecimal.valueOf(-1.00)).divide(gold,RoundingMode.HALF_UP).pow(num))).divide(BigDecimal.valueOf(Math.sqrt(5)),RoundingMode.HALF_UP);
		return result.toBigInteger();
	}
}