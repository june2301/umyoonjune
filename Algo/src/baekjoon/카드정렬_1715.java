package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬_1715 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		int sum = 0;
		while (q.size() > 1) {
			int first = q.poll();
			int second = q.poll();
			int save = first + second;

			sum += save;
			q.add(save);
		}

		System.out.println(sum);
	}
}
