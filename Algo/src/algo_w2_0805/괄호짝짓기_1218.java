package algo_w2_0805;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기_1218 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<String> sta = new Stack<>();

		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			String input = sc.next();
			for (int i = 0; i < input.length(); i++) {
				sta.add(input.substring(i,i+1));
			}
			
			int cnt = 0;
			int s = 0; // ()
			int m = 0; // {}
			int l = 0; // []
			int g = 0; // <>
			int ans = 0;
			while (cnt < num) {
				String a = sta.pop();
				if (a.equals(")")) s++;
				if (a.equals("}")) m++;
				if (a.equals("]")) l++;
				if (a.equals(">")) g++;
				if (a.equals("(")) s--;
				if (a.equals("{")) m--;
				if (a.equals("[")) l--;
				if (a.equals("<")) g--;
				if (s < 0 || m < 0 || l < 0 || g < 0) {
					ans = 0;
					break;
				}
				cnt++;
			}
			if (s == 0 && m == 0 && l == 0 && g == 0) {
				ans = 1;
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
	}

}
