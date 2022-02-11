package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class d4_1861 {

	public static int bfs(int[][] map, int x, int y) {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		int max=0;
		Queue<Streak> q = new LinkedList<Streak>();
		q.add(new Streak(x, y, 1));
		while (q.size() > 0) {
			Streak tmp = q.poll();
			if(tmp.s>max)
				max=tmp.s;
			for (int i = 0; i < 4; i++)
				if (map[tmp.x + dx[i]][tmp.y + dy[i]] == map[tmp.x][tmp.y] + 1)
					q.add(tmp.streak(dx[i], dy[i], 1));
		}
		return max;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] map = new int[n + 2][n + 2];
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					map[i][j] = sc.nextInt();

			int max = 0, maxnum = 9999, ret = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					ret = bfs(map, i, j);
					if (max <= ret) {
						if (max==ret && maxnum < map[i][j])
							continue;
						max = ret;
						maxnum = map[i][j];
					}
				}
			}
			System.out.println("#" + test_case + " " + maxnum + " " + max);

		}
	}
}

class Streak {
	int x, y, s;

	Streak(int x, int y, int s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}

	public Streak streak(int x, int y, int s) {
		this.x += x;
		this.y += y;
		this.s += s;
		return this;
	}
}
