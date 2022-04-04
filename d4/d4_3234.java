package d4;

import java.util.Scanner;

public class d4_3234 {
	
	public static int combi(int start, int[]scales, boolean[] chk) {
		int cnt=0;
		if(!isPossible(chk, scales))
			return 0;
		
		for(int i=0;i<scales.length;i++) {
			if(!chk[i]) {
				chk[i]=true;
				cnt+=combi(0, scales, chk);
				chk[i]=false;
			}
		}
		return cnt+(fact(chk));
	}
	
	public static int fact(boolean[] chk) {
		int l=0, r=0;
		for(int i=0;i<chk.length;i++)
			if(chk[i])
				r++;
			else
				l++;
		if(r==0)
			r=1;
		if(l==1)
			l=1;
		int ll=1, rr=1;
		for(int i=1;i<=l;i++)
			ll*=i;
		for(int i=1;i<=r;i++)
			rr*=i;
		return ll*rr;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
			int[] scales=new int[n];
			boolean[] chk = new boolean[n];
			
			for(int i=0;i<n;i++) {
				scales[i]=sc.nextInt();
			}
			System.out.println(combi(0,scales, chk));
			
		}
	}
	
	public static boolean isPossible(boolean[]chk, int[]scales) {
		int l=0, r=0;
		for(int i=0;i<scales.length;i++) {
			if(chk[i])
				r+=scales[i];
			else
				l+=scales[i];
		}
		if(l>r)
			return true;
		return false;
	}
}
