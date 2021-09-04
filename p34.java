import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class p34 {
	public static void main(String[] args) {
		int f_numbers[] = new int[10];
		long total = 0;
		for (int i = 0; i < 10; i++)
		{
			f_numbers[i] = factor(i);
			System.out.println(f_numbers[i]);
		}
		for (long i = 3; i < 1499999; i++)
		{
			if(i == 2763)
				System.out.println();
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
				System.out.println("Res:\t"+i);
			}
		}
		System.out.println("Total:\t"+total);
	}
	public static int factor(int num)
	{
		if(num <= 1)
			return 1;
		return factor(num-1) * num;
	}
		
}