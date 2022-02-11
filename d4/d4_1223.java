package d4;

import java.util.Scanner;
import java.util.Stack;

public class d4_1223 {

	public static int priority(char a) {
		if(a=='*')
			return 1;
		else if(a=='+')
			return 2;
		return 0;
	}
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String str = sc.nextLine();
			str = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			char [] arr = new char[n];
			Stack<String> stack = new Stack<>();
			for (int i = 0; i < n; i++) {
				char temp = str.charAt(i);
				if (temp >= '0' && temp <= '9') {
					sb.append(String.valueOf(temp));
				} else {
					if (!stack.isEmpty()) {
						if (priority(temp)<priority(stack.peek().charAt(0))) {
//							sb.append(stack.pop());
						}
						else if (priority(temp)>priority(stack.peek().charAt(0))) {
							sb.append(stack.pop());
						}
						else if (priority(temp)==priority(stack.peek().charAt(0))) {
							sb.append(stack.pop());
						}
					}
					stack.add(String.valueOf(temp));
				}
			}
			while (stack.size() > 0)
				sb.append(stack.pop());
			
//			System.out.print(sb.toString());
			
			Stack<Integer> calc = new Stack<>();
			for(int i=0;i<n;i++) {
				char temp = sb.charAt(i);
				if(temp>='0' && temp<='9')
					calc.add(temp-'0');
				else
				{
					int b=calc.pop(), a = calc.pop();
					if(temp=='+')
						calc.add(a+b);
					else if(temp=='*')
						calc.add(a*b);
				}
			}
			System.out.println("#"+test_case+" "+calc.pop());
		}
	}
}