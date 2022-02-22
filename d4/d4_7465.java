package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class d4_7465 {
	public static void makeSet(int n, int[]people) {
		for(int i=0;i<=n;i++)
			people[i]=i;
	}
	public static int findSet(int a, int[]people) {
		if(a==people[a])
			return a;
		return people[a]=findSet(people[a],people);
	}
	public static boolean union(int a, int b, int[]people) {
		int aRoot = findSet(a, people);
		int bRoot = findSet(b, people);
		if(aRoot==bRoot)
			return true;
		people[bRoot]=aRoot;
		return false;
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			int [] people = new int[n+1];
			makeSet(n, people);
			for(int i=0;i<m;i++)
			{
				st = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
				if(b>a)
					union(b,a,people);
				else
					union(a,b,people);
			}
			HashSet<Integer> cnt = new HashSet<Integer>();
			for(int i=1;i<=n;i++) {
				cnt.add(findSet(people[i], people));
			}
			bw.write("#"+test_case+" "+cnt.size()+"\n");
		}
		bw.close();
	}
}
