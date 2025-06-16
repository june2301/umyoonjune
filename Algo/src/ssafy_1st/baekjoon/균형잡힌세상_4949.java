package ssafy_1st.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			// . 입력시 종료
			if (str.equals(".")) {
				break;
			}
			
			// 스택 생성 및 답 체크용 ans 초기화
			Stack<Character> st = new Stack<>();
			int ans = 0;
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				// ( , [ 이면 push
				if (ch == '(' || ch == '[') {
					st.push(ch);
				} else if (ch == ')') { // ) 이면
					// 비었거나 pop이 ( 가 아니면
					if (st.isEmpty() || st.pop() != '(') {
						ans = 1;
						break;
					}
				} else if (ch == ']') { // ] 이면
					// 비었거나 pop이 [ 가 아니면
					if (st.isEmpty() || st.pop() != '[') {
						ans = 1;
						break;
					}
				}
			}
			
			// 스택에 아직 남아있으면 no
			if (!st.isEmpty()) {
				ans = 1;
			}

			if (ans == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
				ans = 0;
			}
		}
	}
}
