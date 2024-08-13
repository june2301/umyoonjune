package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NWL = br.readLine().split(" ");
		int N = Integer.parseInt(NWL[0]);
		int W = Integer.parseInt(NWL[1]);
		int L = Integer.parseInt(NWL[2]);
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int[] trucks = new int[N];
		for (int i = 0; i < N; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(trucks[0]);
		
		int i = 1;
		int time = 0;
		int sum = 0;
		
		int count = 0;
		while (i < N) {
			sum += q.poll();
			time++;
			if ((sum + trucks[i]) <= L) {
				q.add(trucks[i++]);
			} else {
				q.add(0);
				count++;
				if (count >= W) {
					sum = 0;
					count = 0;
				}
			}
			System.out.println(i+"번째 : " + time);
		}
		
		System.out.println(time);
		
		
		
	}

}
