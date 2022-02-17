package d5;

import java.awt.Point;
import java.util.Scanner;

public class d5_1247 {
	static int distance, n, shortest;
	static boolean[] isVisited;

	public static void bfs(int curidx, int depth, Point[] positions) {
		int temp = 0;
		Point cur = positions[curidx];
		if (depth == n) {
			temp=calcDistance(cur, positions[n + 1]);
			distance += temp;
			shortest=Integer.min(distance, shortest);
			distance -= temp;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!isVisited[i]) {
				temp=calcDistance(cur, positions[i]);
				distance += temp;
				isVisited[i] = true;
				bfs(i, depth + 1, positions);
				isVisited[i]=false;
				distance-=temp;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			shortest=Integer.MAX_VALUE;
			n = sc.nextInt();
			isVisited = new boolean[n + 1];
			Point[] positions = new Point[n + 2];
			positions[0] = new Point(sc.nextInt(), sc.nextInt());
			positions[n + 1] = new Point(sc.nextInt(), sc.nextInt());
			for (int i = 1; i <= n; i++)
				positions[i] = new Point(sc.nextInt(), sc.nextInt());

			bfs(0, 0, positions);

			System.out.printf("#%d %d\n", test_case, shortest);
		}
	}

	public static int calcDistance(Point cur, Point next) {
		return Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y);
	}
}
