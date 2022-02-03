package d1;

import java.util.Scanner;

public class d1_2072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		int a=0, b=1, c=1;
		for(int i=1;i<n;i++) {
			c=a+b;
			a=b;
			b=c;
			a%=1000000;
			b%=1000000;
			c%=1000000;
		}
		System.out.println(c);
	}
}
