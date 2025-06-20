package algo_self.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서_11729 {
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		sb.append((int) (Math.pow(2, N) - 1)).append("\n");
		
		calc(N, 1, 2, 3);
		
		System.out.println(sb);
		
	}
	
	static void calc(int N, int from, int mid, int to) {
		
		if (N == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
		
		calc(N-1, from, to, mid);
		sb.append(from + " " + to + "\n");
		calc(N-1, mid, from, to);
		
	}

}

/**
재귀 + 수학
N개를 옮기는데 필요한 경우의 수 = 2^N - 1

N번째 판을 옮기기 위해서는 N-1개를 옮겨야 함
A B C라고 했을 때
1. N-1개 A -> B 이동 후
2. 1개   A -> C 이동
3. N-1개 B -> C 이동
*/
