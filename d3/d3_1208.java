package d3;

import java.util.Arrays;
import java.util.Scanner;

public class d3_1208 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
			int []arr=new int[100];
			for(int i=0;i<100;i++)
				arr[i]=sc.nextInt();
			for( int i=0;i<n;i++) {
				Arrays.sort(arr);
				arr[99]--;
				arr[0]++;			
			}
			Arrays.sort(arr);
			System.out.println("#"+test_case+" "+(int)(arr[99]-arr[0]));
		}
	}
}