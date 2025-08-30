package algo_self.boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 옥상정원꾸미기_6198 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<Integer>();
		
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			
			while (!st.isEmpty() && st.peek() <= h) {
				st.pop();
			}
			
			cnt += st.size();
			
			st.push(h);
		}
		
		System.out.println(cnt);
		
	}

}

/**
Stack을 이용한 문제

LIFO 특성을 이용해서 다음 빌딩들이 추가되기 전에 
다음 빌딩보다 높이가 같거나 작은 빌딩들은 스택에서 제거,
스택에 남아있는 빌딩들은 추가될 빌딩을 볼 수 있으므로 cnt에 추가

1 ≤ N ≤ 80,000 이므로
cnt가 long이어야 한다.

*/