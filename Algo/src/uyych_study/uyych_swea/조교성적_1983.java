package uyych_study.uyych_swea;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 조교성적_1983 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			float n = N/10;
			int K = sc.nextInt();
			
			float[] avg = new float[N];
			
			PriorityQueue<Float> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			for (int i = 0; i < N; i++) {
				float sum = 0;
				sum += sc.nextInt() * 0.35;
				sum += sc.nextInt() * 0.45;
				sum += sc.nextInt() * 0.20;
				avg[i] = sum;
				pq.add(sum);
			}
			float rank = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				float save = pq.poll();
				if (save == avg[K-1]) {
					rank = i+1;
				}
				if (avg[i] == avg[K-1]) {
					cnt++;
				}
			}
			float ans = 0;
			ans = (rank+cnt-1) / n;
			
			String grade = "";
            if (ans <= 1.0) 
                grade = "A+";
            else if (ans <= 2.0) 
                grade = "A0";
            else if (ans <= 3.0) 
                grade = "A-";
            else if (ans <= 4.0) 
                grade = "B+";
            else if (ans <= 5.0) 
                grade = "B0";
            else if (ans <= 6.0) 
                grade = "B-";
            else if (ans <= 7.0) 
                grade = "C+";
            else if (ans <= 8.0) 
                grade = "C0";
            else if (ans <= 9.0) 
                grade = "C-";
            else 
                grade = "D0";

            System.out.println("#" + tc + " " + grade);
		}
		
	}

}
