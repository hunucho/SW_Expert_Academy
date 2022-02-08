package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class d3_1229 {
	public static void main(String args[]) throws Exception {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1; test_case <= T; test_case++) {

			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList<String> li = new LinkedList<>();
			for (int i = 0; i < n; i++)
				li.add(st.nextToken());

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int cmd = 0; cmd < m; cmd++) {
				String func = st.nextToken();
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				switch (func) {
				case "I":
					for (int k = 0; k < y; k++) {
						String tmp = st.nextToken();
						li.add(x + k, tmp);
					}
					break;
				case "D" :
					for(int i=0;i<y;i++)
						li.remove(x);
					break;
				}
				
			}
			bw.write("#" + test_case + " ");
			for (int i = 0; i < 10; i++)
				bw.write(li.pollFirst() + " ");
			bw.write("\n");

		}
		bw.close();
	}
}