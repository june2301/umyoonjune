package ssafy_1st.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 후위표기식_1918 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String ans = "";
		
		// 연산자 Value값 지정
		Map<Character, Integer> map = new HashMap<>();
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 0);
		
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			// A~Z는 ans에 바로 넣기
			if ('A' <= c && c <= 'Z') {
				ans += c;
			
			// ( 는 일단 스택에 push
			}else if (c == '(') {
				st.push(c);
				
			// ) 는 스택에서 ( 나올때까지 pop해서 ans에 넣기
			}else if (c == ')') {
				char pItem = st.pop();
				while (pItem != '(') {
					ans += pItem;
					pItem = st.pop();
				}
			}else {
				
			// 연산자는 스택에 push
			// 스택이 차있고 && 스택 peek이 ( 가 아니고 && 연산자 우선순위 맞게 
			// 스택에서 꺼내서 ans에 넣기
				while (!st.isEmpty() &&
						st.peek() != '(' &&
						map.get(st.peek()) >= map.get(c)) {
					char pItem = st.pop();
					ans += pItem;
				}
				st.push(c);
			}
		}
		// 스택에 남은거 전부 ans에 넣기
		while (!st.isEmpty()) {
			ans += st.pop();
		}
		
		System.out.println(ans);
		
	}

}
