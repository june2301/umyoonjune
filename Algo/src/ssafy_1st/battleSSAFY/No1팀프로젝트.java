package ssafy_1st.battleSSAFY;

import java.io.*;
import java.util.*;

public class No1팀프로젝트 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<String> A = new HashSet<>();
		for (int i = 0; i < N; i++) {
			A.add(sc.next());
		}
		Queue<String> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			String B = sc.next();
			if (A.contains(B)) {
				pq.add(B);
			}
		}
		int s = pq.size();
		if (s > 0) {
			for (int i = 0; i < s; i++) {
				System.out.println(pq.poll());
			}
		}else {
			System.out.println("NO!!");
		}
		
	}

}
