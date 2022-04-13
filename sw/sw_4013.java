package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_4013 {
	static int [][] magnets;
	static int[] index;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int k= Integer.parseInt(br.readLine());
			magnets = new int [6][8];	// 1일때 N극
			index = new int[6];
			for(int i=1;i<=4;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					magnets[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());
				turn(num, dir, new boolean [6]);
			}			
			int ans=0;
			for(int i=1,mul=1;i<=4;i++, mul*=2)
				if(magnets[i][index[i]]==1)
					ans+=mul;
			System.out.println("#"+tc+" "+ans);
		}
	}
	public static void turn(int num, int dir, boolean [] chk) {
		if(num<=0 || num>=5 ||chk[num])
			return;
		chk[num]=true;
		if(dir>0) {
			if(magnets[num][(index[num]+2)%8]!=magnets[num+1][(index[num+1]+6)%8])
				turn(num+1,dir*-1,chk);
			if(magnets[num][(index[num]+6)%8]!=magnets[num-1][(index[num-1]+2)%8])
				turn(num-1,dir*-1,chk);
			index[num]=(index[num]+7)%8;
		}
		else if(dir<0)
		{
			if(magnets[num][(index[num]+2)%8]!=magnets[num+1][(index[num+1]+6)%8])
				turn(num+1,dir*-1,chk);
			if(magnets[num][(index[num]+6)%8]!=magnets[num-1][(index[num-1]+2)%8])
				turn(num-1,dir*-1,chk);
			index[num]=(index[num]+1)%8;			
		}
	}
}
