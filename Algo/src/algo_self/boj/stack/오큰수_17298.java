package algo_self.boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 오큰수_17298 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Stack<Integer> st = new Stack<Integer>();
		
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				answer[st.pop()] = arr[i];
			}
			st.push(i);
		}
		
		while (!st.isEmpty()) {
			answer[st.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i] + " ");
		}
		
		System.out.println(sb);
		
	}

}

/**
 * Stack
 * 
 * 스택에 숫자를 담은 후 꺼내면서 비교할 생각을 하였지만,
 * 그럴 경우 현재 위치에서 오른쪽의 수들 중 자신보다 큰 수를 비교하기 어려움.
 * 
 * 스택을 인덱스로 활용
 * 정답배열을 생성 후,
 * 주어진 수열을 0->N방향으로 탐색
 * index번호를 stack에 push
 * 
 * index가 stack.peek()인 숫자보다 현재 숫자가
 * 크다면 -> 정답배열에 stack.pop()인덱스인 숫자 추가 + stack에 현재 index 추가
 * 작다면 -> stack에 현재 index 추가
 * 
 * stack에서 나오지 못한 숫자들
 * => 오큰수가 없는 수자 = 정답배열에 -1 추가
 * 
 */
