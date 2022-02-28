package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_13038 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int target = Integer.parseInt(br.readLine()), min = Integer.MAX_VALUE;
			int[] classes = new int[7];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				classes[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 7; i++) {
				int day = 0, cnt = 0;
				while (cnt < target) {
					day++;
					if (classes[(i + day) % 7] == 1)
						cnt++;
				}
				if (day < min)
					min = day;
			}
			System.out.printf("#%d %d\n", test_case, min);
		}	

	}
}