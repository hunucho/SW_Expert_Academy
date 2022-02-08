package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class d3_1228 {
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
				String tmp = st.nextToken();
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				for (int k = 0; k < y; k++) {
					tmp = st.nextToken();
					li.add(x + k, tmp);
				}
			}
			bw.write("#" + test_case + " ");
//			for (int i = 0; i < 10; i++)
//				bw.write(li.pollFirst() + " ");
			for(String zz :li) {
				System.out.println(zz);
			}
			bw.write("\n");

		}
		bw.close();
	}
}