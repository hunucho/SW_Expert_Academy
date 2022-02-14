package d3;

import java.util.Scanner;

public class d3_6808 {
	static int[] arr=new int[9], brr=new int[9], crr=new int[9];
	static boolean[] visited=new boolean [9];
	static int awin, bwin;
	
	public static void permutation(int depth) {
		if(depth==9)
		{
			int sum1=0, sum2=0;
			for(int i=0;i<9;i++)
			{
				if(arr[i]>brr[i])
					sum1+=arr[i]+brr[i];
				else if(arr[i]<brr[i])
					sum2+=arr[i]+brr[i];
			}
			if(sum1>sum2)
				awin++;
			else if(sum1<sum2)
				bwin++;
			return;
		}
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				brr[depth]=crr[i];
				permutation(depth+1);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			boolean [] chk=new boolean[19];
			awin=0;
			bwin=0;
			for(int i=0;i<9;i++) {
				arr[i]=sc.nextInt();
				chk[arr[i]]=true;
			}
			int cnt=0;
			for(int i=1;i<=18;i++)
				if(!chk[i])
					crr[cnt++]=i;
			permutation(0);
			System.out.printf("#%d %d %d\n",test_case,awin, bwin);
		}
	}
}
