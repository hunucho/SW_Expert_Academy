package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_3289 {

	public static void makeSet(int n, int[] p) {
		for (int i = 1; i <= n; i++)
			p[i] = i;
	}

	public static int findSet(int a, int[] p) {
		if (a == p[a])
			return a;
		return p[a] = findSet(p[a], p);
	}

	public static void union(int a, int b, int[] p) {
		int aRoot = findSet(a, p), bRoot = findSet(b, p);
		p[bRoot] = aRoot;
	}

	public static int isUnion(int a, int b, int[] p) {
		int aRoot = findSet(a, p), bRoot = findSet(b, p);
		if (aRoot == bRoot)
			return 1;
		return 0;
	}

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());		
			int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
			int [] p = new int[n+1];
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			makeSet(n, p);
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int sw=Integer.parseInt(st.nextToken()), a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
				if(sw==0)
					union(a,b,p);
				else if(sw==1) {
					sb.append(isUnion(a, b, p));
				}
			}
			System.out.println(sb.toString());
		}
	}
}