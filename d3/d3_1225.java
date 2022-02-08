package d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class d3_1225 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T;
			T=sc.nextInt();
			Queue<Integer> q=new LinkedList<>();
			for(int i=0;i<8;i++)
				q.add(sc.nextInt());
			boolean chk=true;
			while(chk) {
				
				for(int i=1;i<=5;i++) {
					int tmp=q.poll()-i;
					if(tmp<=0) {
						tmp=0;
						chk=false;
						q.add(tmp);
						break;			
					}
					q.add(tmp);
				}
			}
			System.out.print("#"+T+" ");
			for(int i=0;i<8;i++)
				System.out.print(q.poll()+" ");
				
		}
	}
}