package mock;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class mock_5644 {
	public static int charging(int m, int bc, Queue<Integer> a, Queue<Integer> b, int[][] charger) {
//		int[][] map = new int[11][11];
		Point loca = new Point(1, 1), locb = new Point(10, 10);
		for (int i = 0; i <= m; i++) {
			boolean[] statea = onCharging(loca, charger);
			boolean[] stateb = onCharging(loca, charger);

			for(int j=0;j<bc;j++)
				if(statea[i] && stateb[i])
			
			if(i==m)
				break;
			loca = move(a, loca);
			locb = move(b, locb);
		}
		return 0;
	}

	public static Point move(Queue<Integer> q, Point cur) {
		Point next = cur;
		int tmp = q.poll();
		switch (tmp) {
		case 0:
			break;
		case 1:
			next.y--;
			break;
		case 2:
			next.x++;
			break;
		case 3:
			next.y++;
			break;
		case 4:
			next.x--;
			break;
		}
		return next;
	}

	public static boolean[] onCharging(Point loc, int[][] charger) {
		boolean[] including = new boolean[charger.length];
		for (int i = 0; i < charger.length; i++) {
			if (Math.abs(loc.x - charger[i][0]) + Math.abs(loc.y - charger[i][1]) <= charger[i][2])
				including[i] = true;
		}
		return including;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int m = sc.nextInt(), bc = sc.nextInt();
			Queue<Integer> a = new LinkedList<Integer>(), b = new LinkedList<>();
			int[][] charger = new int[bc][4];
			for (int i = 0; i < m; i++)
				a.add(sc.nextInt());
			for (int i = 0; i < m; i++)
				b.add(sc.nextInt());
			for (int i = 0; i < bc; i++)
				for (int j = 0; j < 4; j++)
					charger[i][j] = sc.nextInt();
			// x, y, range, power
			System.out.println(charging(m, bc, a, b, charger));

		}
	}
}
