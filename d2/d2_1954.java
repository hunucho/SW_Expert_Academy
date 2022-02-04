package d2;

import java.util.Scanner;

public class d2_1954 {
	static int [][]arr;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		arr = new int [n][n];
		int cnt=1, i=0, j=0, direct=0, correction=0,temp=0, hold=n ;
		while(cnt<=n*n) {
			arr[i+correction][j+correction]=cnt++;
			temp++;
			switch(direct) {
			case 0: j++; if(temp==hold-1) { direct=1; temp=0;} break;
			case 1: i++; if(temp==hold-1) { direct=2; temp=0;} break;
			case 2: j--; if(temp==hold-1) { direct=3; temp=0;} break;
			case 3: i--; if(temp==hold-1) { direct=0; temp=0; hold-=2; correction++;} break;
			}
		}
//		System.out.println("#"+test_case);
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

}
