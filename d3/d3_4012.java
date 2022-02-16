package d3;

import java.util.Scanner;

public class d3_4012 {
	static int min;
	public static void combi(int cnt, int start, int n, boolean[] numbers, int[][] map) {
		if (cnt == n / 2) {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < n; i++) {
				if (numbers[i]) {
					for (int j = 0; j < n; j++)
						if (numbers[j])
							sum1 += map[i][j];
				} else if (!numbers[i]) {
					for (int j = 0; j < n; j++)
						if (!numbers[j])
							sum2 += map[i][j];
				}
			}
			min = Math.min(min,Math.abs(sum1-sum2));
			return;
		}

		for (int i = start; i < n; i++) {
			numbers[i] = true;
			combi(cnt + 1, i + 1, n, numbers, map);
			numbers[i] = false;
		}
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			boolean[] numbers = new boolean[n];
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = sc.nextInt();
			min = Integer.MAX_VALUE;
			combi(0, 0, n, numbers, arr);

			System.out.println("#"+test_case+" "+min);

		}
	}
}