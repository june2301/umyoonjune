package uyych_study.uyych_swea;

import java.util.Arrays;
import java.util.Scanner;

public class 나무높이_14510 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			int[] tree = new int[N];
			for (int i = 0; i < N; i++) {
				tree[i] = sc.nextInt();
			}
			
			Arrays.sort(tree);
			
			int cnt = 0;
			int water = 1;
			main : while (tree[0] != tree[N-1]) {
				if (water == 1) {
					
					// 정확히 1차이날때
					for (int i = 0; i < N; i++) {
						if (tree[i] + 1 == tree[N-1]) {
							tree[i] += water;
							cnt++;
							water = 2;
							Arrays.sort(tree);
							continue main;
						}
					}
					if (tree[1] == tree[N-1] && tree[0] == tree[N-1] - 2) { 
						// [1]번째가 이미 같고
						// [0]번째가 제일 큰 수와 2이상 차이 날때
						cnt++;
						water = 2;
						continue;
					} else {
						tree[0] += water;
						cnt++;
						water = 2;
					}
				} else {
					
					// 정확히 2차이날때
					for (int i = 0; i < N; i++) {
						if (tree[i] + 2 == tree[N-1]) {
							tree[i] += 2;
							cnt++;
							water = 1;
							Arrays.sort(tree);
							continue main;
						}
					}
					
					// 1밖에 차이 안날때 한턴 넘기기
					if (tree[0] == tree[N-1]-1) {
						cnt++;
						water = 1;
						continue;
					} else {
						tree[0] += water;
						cnt++;
						water = 1;
					}
				}
				
				Arrays.sort(tree);
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
		
		
	}

}
