package d3;

import java.util.Scanner;

public class d3_2805 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sum=0, j=0, n=sc.nextInt();
			String str="";
			for(int i=0;i<n;i++)
			{
				str=sc.next().substring(n/2-j, n/2+1+j);
				if(i<n/2)
					j++;
				else
					j--;
				for(int k=0;k<str.length();k++)
					sum+=str.charAt(k)-'0';
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}