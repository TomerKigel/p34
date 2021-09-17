import java.util.*;

public class p61 {
	public static void main(String[] args) {
		Vector<Integer> Inputs = new Vector<Integer>();
		Vector<Integer> outputs = new Vector<Integer>();
		
		Inputs.add(100);
		outputs.add(0);
		
		Inputs.add(5000);
		outputs.add(145);
		
		Inputs.add(10000);
		outputs.add(145);
		
		Inputs.add(100000);
		outputs.add(40730);
		
		Test(Inputs,outputs);
		System.out.println("Answer is: " + p33(100000));
	}

	public static long p33(long bound)
	{
		long [] f_numbers = new long[10];
		long total = 0;
		digit_factor_worth(f_numbers);
		for (long i = 3; i < bound; i++)
		{
			long sum = 0;
			long t_num = i;
			while(t_num/10 >= 1)
			{
				sum += f_numbers[(int)(t_num % 10)];
				t_num /= 10;
			}
			sum += f_numbers[(int)(t_num % 10)];


			if(sum == i)
			{
				total += sum;
			}
		}
		return total;
	}
	public static int factor(int num)
	{
		if(num <= 1)
			return 1;
		return factor(num-1) * num;
	}
	static long [] digit_factor_worth(long f_numbers[])
	{
		for (int i = 0; i < 10; i++)
		{
			f_numbers[i] = factor(i);
		}
		return f_numbers;
	}
	
	public static void Test(Vector<Integer> Inputs,Vector<Integer> Excpected_Outputs)
	{
		int i = 1;
		for (Integer num : Inputs) {
			System.out.print("Test number" + i +":");
			if(p33(num) == Excpected_Outputs.elementAt(i-1))
				System.out.println("Passed");
			else
				System.out.println("Failed");
			i++;
		}
	}
}
