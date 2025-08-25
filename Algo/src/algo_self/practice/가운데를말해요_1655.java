package algo_self.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> {return o1 - o2;});
		PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			
			if (right.size() == left.size()) {
				left.add(now);
			} else {
				right.add(now);
			}
			
			if (!right.isEmpty() && !left.isEmpty()) {
				if (left.peek() > right.peek()) {
					int temp = right.poll();
					right.add(left.poll());
					left.add(temp);
				}
			}
			
			sb.append(left.peek() + "\n");
		}
		
		System.out.println(sb);
		
	}

}

/**
 * PQ 우선순위 큐
 * [문제]
 * N이 주어지고 N번만큼 숫자가 입력된다.
 * 이 때 가운데의 숫자를 출력해야하며, 숫자가 짝수개일 경우 작은 수를 출력한다.
 * 
 * 정렬을 달아둔 PQ 2개를 사용하여 작은 수(left)와 큰 수(right)를 저장하는 방식으로 구현
 * left는 내림차순으로 정렬 : top이 작은 것들 중 제일 큰 값
 * right는 오름차순 정렬 : top이 큰 것들 중 제일 작은 값
 * left와 right의 사이즈가 같으면 -> left에 추가 | 다르면 right에 추가
 * 
 * left.peek()와 right.peek()를 비교하여
 * left쪽에 큰 수가 추가되었다면 right.poll()과 교체
 * -> 양쪽에 작은 수와 큰 수가 계속 정렬될 수 있도록 구현
 */

