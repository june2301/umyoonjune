package algo_w2_day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			Queue<Integer> que = new LinkedList<>();
			
			String[] input = br.readLine().split(" ");
			// 최대값 저장 정답계산 저장
			int max = 0;
			long ans = 0;
			for (int i = N-1; i >= 0; i--) {
				// 거꾸로 que에 담기
				que.add(Integer.parseInt(input[i]));
				// max값 정하기
				if (que.peek() > max) {
					max = que.peek();
				}
				// 가장 최근거 꺼내서 max보다 작으면 빼기
				int save = que.poll();
				if (save < max) {
					ans += max - save;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}

	}

}
