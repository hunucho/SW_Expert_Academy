package d2;

import java.util.Scanner;

public class d2_2001 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt(),m=sc.nextInt(),max=0;
			int[][]arr = new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					arr[i][j]=sc.nextInt();
			for(int i=0;i<=n-m;i++)
				for(int j=0;j<=n-m;j++) {
					int sum=0;
					for(int k=0;k<m;k++)
						for(int l=0;l<m;l++)
							sum+=arr[i+k][j+l];
					if(sum>max)
						max=sum;
				}
			System.out.println("#"+test_case+" "+max);
		}
	}
}