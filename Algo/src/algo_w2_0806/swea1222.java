package algo_w2_0806;

import java.util.Scanner;
import java.util.Stack;

public class swea1222 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String expression = sc.next();
			System.out.println("#" + tc + " " + cal(N, expression));
		}
		
	}
	
	static int cal(int N, String infix) {
		
		// -> 후위 표기식
		String postfix = "";
		Stack<Character> stack1 = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			
			char c = infix.charAt(i);
			
			if ('0' <= c && c <= '9') {
				postfix += c;
			} else {
				while (!stack1.isEmpty()) {
					char popItem = stack1.pop();
					postfix += popItem;
				}
				stack1.push(c);
			}
		}
		while (!stack1.isEmpty()) {
			postfix += stack1.pop();
		}

		// 계산
		Stack<Integer> stack2 = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if ('0' <= c && c <= '9') {
				stack2.push(c - '0');
			} else {
				int num2 = stack2.pop();
				int num1 = stack2.pop();
				int result = 0;
				
				if (c == '+') {
					result = num1 + num2;
				} 
				stack2.push(result);
			}
		}
		return stack2.pop();
		
	}
	
	
}
