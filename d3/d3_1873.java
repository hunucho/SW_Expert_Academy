package d3;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class d3_1873 {
	static int h = 0, w = 0;

	public static boolean move(char[][] map, int x, int y, int dx, int dy, char dir) {
		map[x][y] = dir;
		if (x + dx >= 0 && x + dx < h && y + dy >= 0 && y + dy < w) {
			if (map[x + dx][y + dy] == '.') {
				map[x + dx][y + dy] = dir;
				map[x][y] = '.';
				return true;
			}
		}
		return false;
	}

	public static void shoot(char[][] map, int x, int y, char dir) {
		switch (dir) {
		case '^':
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == '*') {
					map[i][y] = '.';
					break;
				} else if (map[i][y] == '#')
					break;
			}
			break;
		case 'v':
			for (int i = x; i < h; i++) {
				if (map[i][y] == '*') {
					map[i][y] = '.';
					break;
				} else if (map[i][y] == '#')
					break;
			}
			break;
		case '<':
			for (int j = y; j >= 0; j--) {
				if (map[x][j] == '*') {
					map[x][j] = '.';
					break;
				} else if (map[x][j] == '#')
					break;
			}
			break;
		case '>':
			for (int j = y; j < w; j++) {
				if (map[x][j] == '*') {
					map[x][j] = '.';
					break;
				} else if (map[x][j] == '#')
					break;
			}
			break;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			h = sc.nextInt();
			w = sc.nextInt();
			int x = 0, y = 0;
			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++)
				map[i] = sc.next().toCharArray();

			// 전차 위치 찾기
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '^' || map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v') {
						x = i;
						y = j;
						break;
					}
				}
			}

			// 구현
			int ccnt = sc.nextInt();
			String cmds = sc.nextLine();
			cmds = sc.nextLine();
			for (int i = 0; i < ccnt; i++) {
				char cmd = cmds.charAt(i);
				switch (cmd) {
				case 'S':
					shoot(map, x, y, map[x][y]);
					break;
				case 'U':
					if(move(map, x, y, -1, 0, '^'))
						x--;
					break;
				case 'D':
					if(move(map, x, y, 1, 0, 'v'))
						x++;
					break;
				case 'L':
					if(move(map, x, y, 0, -1, '<'))
						y--;
					break;
				case 'R':
					if(move(map, x, y, 0, 1, '>'))
						y++;
					break;
				}
			}

			// 출력
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)
					bw.write(map[i][j]);
				bw.write("\n");
			}
			bw.flush();
		}
	}
}