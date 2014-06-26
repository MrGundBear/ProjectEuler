import java.util.ArrayList;

public class PE21
{
	
	public static void main (String[] args)
	{
		PE21 pe = new PE21();
		System.out.println("num: " + pe.calcSum(10000));
	}

	public long calcSum(int limit)
	{
		//first find pairs, where d(a) = n   and d(n)=a
		long sum =0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<limit; i++)
		{
			int temp = calcAmicNum(i);
			if(calcAmicNum(temp) == i && temp!=i)
			{
				if(temp%2==0 && i%2!=0)System.out.println("found differents!");
				System.out.println("amicNum: " + i + "   t: " + temp);
				sum+=i;
			}
		}
		return sum;
	}

	public int calcAmicNum(int num)
	{
		int sum = 0;
		for(int i=1; i<num; i++)
		{
			if(num % i == 0)
			{
				//System.out.println(i+" is a proper divisor for " + num);
				sum+= i;
			}
		}
		return sum;
	}
}