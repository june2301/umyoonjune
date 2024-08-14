package im;

import java.util.Scanner;

public class ex0814 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			int[] stu = new int[N];
			for (int i = 0; i < N; i++) {
				stu[i] = sc.nextInt();
			}
			
			// 어학점수 1~100별 학생수 기록
			int[] scores = new int[101];
			for (int i = 0; i < N; i++) {
				scores[stu[i]]++;
			}
			
			// 분반 학생 수 기록
			int ans = 100;
			//  abc 값 기록용
			int rea = 0;
			int reb = 0;
			int rec = 0;
			// i와 j 범위를 1~100까지 나눠
			// 모든 범위에서 학생 수 차이 최소값 구하기
			for (int i = 0; i < 100-2; i++) {
				for (int j = i; j < 100-1; j++) {
					int a = 0;
					int b = 0;
					int c = 0;
					
					for (int aa = 0; aa <= i; aa++) {
						a += scores[aa];
					}
					
					for (int bb = i + 1; bb <= j; bb++) {
						b += scores[bb];
					}
					
					for (int cc = j + 1; cc <= 100; cc++) {
						c += scores[cc];
					}
					
					// abc 중 제일 큰 값, 제일 작은 값
					int smax = Math.max(a, b);
					smax = Math.max(smax, c);
					int smin = Math.min(a, b);
					smin = Math.min(smin, c);
					
					// ans에 최소값 기록, 그 때의 abc 기록
					if ((smax - smin) <= ans) {
						ans = smax - smin;
						rea = a;
						reb = b;
						rec = c;
					}
				}
			}
			// 만약 최소값에서 abc가 조건 만족 못하면 ans = -1
			if (rea < min || rea >max || reb < min || reb > max || rec < min || rec > max) 
				ans = -1;
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
