package ssafy_1st.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스_1158 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		while (!q.isEmpty()) {
			for (int i = 0; i < M-1; i++) {
				int save = q.poll();
				q.add(save);
			}
			sb.append(q.poll() + ", ");
			if (q.isEmpty()) {
				sb.delete(sb.length()-2, sb.length());
			}
		}
		sb.append(">");
		System.out.println(sb);
	}

}
