package algo_w2_day3_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea3499 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			Queue<String> d1 = new LinkedList<>();
			Queue<String> d2 = new LinkedList<>();
			// queue에 add
			if (N % 2 == 1) { // 홀수개일 경우
				for (int i = 0; i < N/2+1; i++) {
					d1.add(input[i]);
				}
				for (int i = N/2+1; i < N; i++) {
					d2.add(input[i]);
				}
			} else { // 짝수개일 경우 
				for (int i = 0; i < N/2; i++) {
					d1.add(input[i]);
				}
				for (int i = N/2; i < N; i++) {
					d2.add(input[i]);
				}
			}
			
			// 출력 홀수이면 홀수부터 출력 // empty일경우 stop
			System.out.print("#" + tc + " ");
            while (!d1.isEmpty() || !d2.isEmpty()) {
                if (!d1.isEmpty()) {
                    System.out.print(d1.poll() + " ");
                }
                if (!d2.isEmpty()) {
                    System.out.print(d2.poll() + " ");
                }
            }
			System.out.println();
		}
		
	}

}
