//package d3;
//
//import java.util.Scanner;
//
//public class d3_5215 {
//
//	static int sum, ans, cal, n, l;
//	static int [][] material;
//	public static void f(int k) {
//		if(cal<=l && sum>ans)
//			ans=sum;
//		for(int i=k+1;i<n;i++)
//		{
//			sum+=material[i][0];
//			cal+=material[i][1];
//			if(cal<=l && sum>ans)
//				ans=sum;
//			f(i);
//			sum-=material[i][0];
//			cal-=material[i][1];
//				
//		}
//	}
//	public static void main(String args[]) throws Exception
//	{
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
//		
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			n=sc.nextInt();
//			l=sc.nextInt();
//			ans=0;
//			material=new int [n][2];
//			for(int i=0;i<n;i++) {
//				material[i][0]=sc.nextInt();
//				material[i][1]=sc.nextInt();
//			}
//			for(int i=0;i<n;i++) {
//				sum=cal=0;
//				sum+=material[i][0];
//				cal+=material[i][1];
//				f(i);				
//			}
//			System.out.printf("#%d %d\n",test_case,ans);
//		}
//	}
//}

package d3;

import java.util.Scanner;

public class d3_5215 {

	static int sum, ans, cal, n, l;
	static int [][] material;
	public static void f(int k) {
		for(int i=k+1;i<n;i++)
		{
			sum+=material[i][0];
			cal+=material[i][1];
			if(cal<=l && sum>ans)
				ans=sum;
			f(i);
			sum-=material[i][0];
			cal-=material[i][1];
		}
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n=sc.nextInt();
			l=sc.nextInt();
			ans=0;
			material=new int [n][2];
			for(int i=0;i<n;i++) {
				material[i][0]=sc.nextInt();
				material[i][1]=sc.nextInt();
			}
			f(-1);
			System.out.printf("#%d %d\n",test_case,ans);
		}
	}
}