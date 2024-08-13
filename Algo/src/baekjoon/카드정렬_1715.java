package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카드정렬_1715 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(card);
		Queue<Integer> q = new LinkedList<>();
		
		
		int save = card[0];
		q.add(save);
		int sum = 0;
		int i = 1;
		while (i < N) {
			save = q.poll();
			q.add(card[i++]);
			sum += save + q.poll();
			q.add(sum);
		}
		
//		int sum = 0;
//		int j = 1;
//		while (j < N) {
//			for (int i = 0; i <= j;i++) {
//				q.add(card[i]);
//				sum += q.poll();
//			}
//			j++;
//		}
		System.out.println(sum);
	}
}
