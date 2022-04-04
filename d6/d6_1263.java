package d6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d6_1263 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			int[] cc = new int[n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					arr[i][j]=Integer.parseInt(st.nextToken());
			
			for (int k = 0; k < n; k++) {
				int sum=0;
				boolean[] chk = new boolean[n];
				Queue<Integer> q = new LinkedList<Integer>();
				Queue<Integer> dep = new LinkedList<Integer>();
				q.add(k);
				dep.add(1);
				chk[k]=true;
				while (q.size() > 0) {
					int cur = q.poll();
					int dept = dep.poll();
					for (int j = 0; j < n; j++)
						if (!chk[j] && arr[cur][j] == 1) {
							q.add(j);
							dep.add(dept + 1);
							sum+=dept;  
							chk[j] = true;
						}
					
				}
				if(min>sum)
					min=sum;
			}
			bw.write("#"+test_case+" "+min+"\n");
		}
		bw.close();
	}
}
