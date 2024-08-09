package algo_w2_day3_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1225 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(sc.nextLine());
			String[] input = sc.nextLine().split(" ");
			
			// Queue에 입력값 저장
			Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < input.length; i++) {
				que.add(Integer.parseInt(input[i]));
			}
			
			int cnt = 1;
			int save = 0;
			while (true) {
				// que 꺼내서 cnt만큼 뺀 값을 save에 저장
				save = que.poll() - cnt++;
				// cnt는 1~5까지만
				if (cnt > 5) {
					cnt = 1;
				}
				// save가 0보다 작거나 같으면 마지막으로 넣고 break;
				if (save <= 0) {
					save = 0;
					que.add(save);
					break;
				}
				// save가 0보다 작거나 같지 않으면 저장
				que.add(save);
				save = 0;
			}
			
			// queue 출력
			System.out.print("#"+T+" ");
			while (!que.isEmpty()) {
				System.out.print(que.poll() + " ");
			}
			System.out.println();
			
		}
		
	}

}
