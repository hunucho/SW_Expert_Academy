package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d4_1238 {
	
	public static int bfs(boolean[][]network, int s) {
		Queue<Integer> q = new LinkedList<>(), cnt=new LinkedList<>();
		boolean [] chk = new boolean[101];
		q.add(s);
		cnt.add(0);
		chk[s]=true;
		int max=s,prevcnt=0;
		while(q.size()>0) {
			int cur=q.poll(), curcnt=cnt.poll();
			
			if(curcnt>prevcnt) {
				prevcnt=curcnt;
				max=cur;
			}
			else if(curcnt==prevcnt && max<cur)
				max=cur;
			for(int i=1;i<=100;i++) {
				if(network[cur][i] && !chk[i]) {
					chk[i]=true;
					q.add(i);
					cnt.add(curcnt+1);
				}
			}
			
		}		
		return max;
	}
	
	public static void main(String args[]) throws Exception
	{
		int T=10;		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
			boolean[][]network = new boolean[101][101];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n/2;i++) {
				int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
				network[start][end]=true;
			}
			System.out.printf("#%d %d\n",test_case,bfs(network,s));

		}
	}
}
