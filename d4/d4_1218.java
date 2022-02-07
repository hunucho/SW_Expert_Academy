package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class d4_1218 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < n; i++) {
				if(s.charAt(i)==')' ||s.charAt(i)==']' ||s.charAt(i)=='}' ||s.charAt(i)=='>') {	
					if(s.charAt(i)-stack.peek()>0 && s.charAt(i)-stack.peek()<3)
						stack.pop();
					else
						break;
				}
				else
					stack.push(s.charAt(i));
			}
			System.out.print("#"+test_case+" ");
			if(stack.size()==0)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
