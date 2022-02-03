package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class d3_1289 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			boolean zero=true;
			int cnt=0;
			String temp=br.readLine();
			for(int j=0;j<temp.length();j++) {
				if(temp.charAt(j)=='1' && zero) {
					cnt++;
					zero=!zero;
				}
				else if(temp.charAt(j)=='0' && !zero) {
					cnt++;
					zero=!zero;
				}
			}
			System.out.println("#"+(int)(i+1)+" "+cnt);
		}
	}
}