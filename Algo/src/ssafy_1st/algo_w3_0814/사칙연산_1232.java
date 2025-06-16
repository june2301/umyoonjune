package ssafy_1st.algo_w3_0814;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 사칙연산_1232 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		String[] tree = new String[N + 1];

		// 트리 입력 받기
		for (int i = 0; i < N; i++) {
			String[] input = sc.nextLine().split(" ");
			int index = Integer.parseInt(input[0]);
			String node = input[1];
			tree[index] = node;
		}
		
		Queue<String> q = new LinkedList<>();
		inorder(tree, 1, q);

		// 사칙연산 수행
		while (q.size() > 1) {
			// 피연산자와 연산자를 큐에서 추출
			String operand1 = q.poll();
			String operator = q.poll();
			String operand2 = q.poll();
			
			// 추출한 값이 null인 경우 처리
			if (operand1 == null || operator == null || operand2 == null) {
				break;
			}
			
			int num1 = Integer.parseInt(operand1);
			int num2 = Integer.parseInt(operand2);
			int result = 0;
			
			// 연산자에 따라 계산 수행
			if (operator.equals("+")) 
				result = num1 + num2;
			else if (operator.equals("-")) 
				result = num1 - num2;
			else if (operator.equals("*")) 
				result = num1 * num2;
			else if (operator.equals("/")) 
				result = num1 / num2;

			// 계산된 결과를 큐에 추가
			q.add(Integer.toString(result));

			// 큐에 연산자가 남아있다면 순환시켜 다음 연산 준비
			if (!q.isEmpty() && (q.peek().equals("+") || q.peek().equals("-") || q.peek().equals("*") || q.peek().equals("/"))) {
				q.add(q.poll());  // 연산자를 맨 뒤로 이동
			}
		}

		// 최종 결과 출력
		if (!q.isEmpty()) {
			int ans = Integer.parseInt(q.poll());
			System.out.println(ans);
		} else {
			System.out.println("연산을 수행할 수 없습니다.");
		}
	}
	
	// 중위 순회(Inorder Traversal)
	public static void inorder(String[] tree, int i, Queue<String> q) {
		if (i >= tree.length || tree[i] == null) 
			return;
		inorder(tree, i * 2, q);
		q.add(tree[i]);
		inorder(tree, i * 2 + 1, q);
	}
}
