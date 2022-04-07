package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_1953 {
	static int n,m,r,c,l,ans;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			l=Integer.parseInt(st.nextToken());
			ans=0;
			map = new int[n][m];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();		
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static boolean check(int pr,int pc,int nr, int nc) {
		int[] dx = {-1,0,1,0}, dy= {0,-1,0,1};
		
		if(map[nr][nc]==1) {
			for(int i=0;i<4;i++) {
				if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
					if(nr+dx[i]==pr && nc+dy[i]==pc)
						return true;
			}
		}
		else if(map[nr][nc]==2) {
			for(int i=0;i<4;i+=2) {
				if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(nr+dx[i]==pr && nc+dy[i]==pc)
							return true;
			}
		}
		else if(map[nr][nc]==3) {
			for(int i=1;i<4;i+=2) {
				if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(nr+dx[i]==pr && nc+dy[i]==pc)
							return true;
			}
		}
		else if(map[nr][nc]==4) {
			for(int i=0;i<4;i+=3) {
				if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(nr+dx[i]==pr && nc+dy[i]==pc)
							return true;
			}
		}
		else if(map[nr][nc]==5) {
			for(int i=2;i<4;i++) {
				if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(nr+dx[i]==pr && nc+dy[i]==pc)
							return true;
			}
		}
		else if(map[nr][nc]==6) {
			for(int i=1;i<3;i++) {
				if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(nr+dx[i]==pr && nc+dy[i]==pc)
							return true;
			}
		}
		else if(map[nr][nc]==7) {
			for(int i=0;i<2;i++) {
				if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(nr+dx[i]==pr && nc+dy[i]==pc)
							return true;
			}
		}
		return false;
	}
	
	public static void bfs() {
		int[] dx = {-1,0,1,0}, dy= {0,-1,0,1};
		boolean [][] chk = new boolean [n][m];
		int nr,nc,nl;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r,c,1});
		chk[r][c]=true;
		while(q.size()>0) {
			int[] cur=q.poll();
			nr=cur[0];
			nc=cur[1];
			nl=cur[2];
			
			if(nl>=l)
				continue;
			
			if(map[nr][nc]==1) {
				for(int i=0;i<4;i++) {
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(check(nr,nc,nr+dx[i],nc+dy[i]) && !chk[nr+dx[i]][nc+dy[i]]) {
							q.add(new int[] {nr+dx[i], nc+dy[i], nl+1});
							chk[nr+dx[i]][nc+dy[i]]=true;
						}
				}
			}
			else if(map[nr][nc]==2) {
				for(int i=0;i<4;i+=2) {
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(check(nr,nc,nr+dx[i],nc+dy[i]) && !chk[nr+dx[i]][nc+dy[i]]) {
							q.add(new int[] {nr+dx[i], nc+dy[i], nl+1});
							chk[nr+dx[i]][nc+dy[i]]=true;
						}
				}
			}
			else if(map[nr][nc]==3) {
				for(int i=1;i<4;i+=2) {
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(check(nr,nc,nr+dx[i],nc+dy[i]) && !chk[nr+dx[i]][nc+dy[i]]) {
							q.add(new int[] {nr+dx[i], nc+dy[i], nl+1});
							chk[nr+dx[i]][nc+dy[i]]=true;
						}
				}
			}
			else if(map[nr][nc]==4) {
				for(int i=0;i<4;i+=3) {
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(check(nr,nc,nr+dx[i],nc+dy[i]) && !chk[nr+dx[i]][nc+dy[i]]) {
							q.add(new int[] {nr+dx[i], nc+dy[i], nl+1});
							chk[nr+dx[i]][nc+dy[i]]=true;
						}
				}
			}
			else if(map[nr][nc]==5) {
				for(int i=2;i<4;i++) {
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(check(nr,nc,nr+dx[i],nc+dy[i]) && !chk[nr+dx[i]][nc+dy[i]]) {
							q.add(new int[] {nr+dx[i], nc+dy[i], nl+1});
							chk[nr+dx[i]][nc+dy[i]]=true;
						}
				}
			}
			else if(map[nr][nc]==6) {
				for(int i=1;i<3;i++) {
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(check(nr,nc,nr+dx[i],nc+dy[i]) && !chk[nr+dx[i]][nc+dy[i]]) {
							q.add(new int[] {nr+dx[i], nc+dy[i], nl+1});
							chk[nr+dx[i]][nc+dy[i]]=true;
						}
				}
			}
			else if(map[nr][nc]==7) {
				for(int i=0;i<2;i++) {
					if(nr+dx[i]>=0 && nr+dx[i]<n && nc+dy[i]>=0 && nc+dy[i]<m)
						if(check(nr,nc,nr+dx[i],nc+dy[i]) && !chk[nr+dx[i]][nc+dy[i]]) {
							q.add(new int[] {nr+dx[i], nc+dy[i], nl+1});
							chk[nr+dx[i]][nc+dy[i]]=true;
						}
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				if(chk[i][j])
					ans++;
		}
	}
}
