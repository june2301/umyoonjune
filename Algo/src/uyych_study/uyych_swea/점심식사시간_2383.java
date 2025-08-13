package uyych_study.uyych_swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 점심식사시간_2383 {
	
	static int stair1, stair2;
	static int M;
	static int[] time1, time2;
	static List<Integer> list1, list2;
	static boolean[] sel;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N+2][N+2];
			
			List<Integer> manr = new ArrayList<>();
			List<Integer> manc = new ArrayList<>();
			int str1 = 0;
			int stc1 = 0;
			int str2 = 0;
			int stc2 = 0;
			stair1 = 0;
			stair2 = 0;
			
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N+1; c++) {
					map[r][c] = sc.nextInt();
					if (map[r][c] == 1) {
						manr.add(r);
						manc.add(c);
					}
					if (map[r][c] > 1 && str1 == 0 && stc1 == 0) {
						str1 = r;
						stc1 = c;
						stair1 = map[r][c];
					}
					if (map[r][c] > 1 && str1 != 0 && stc1 != 0) {
						str2 = r;
						stc2 = c;
						stair2 = map[r][c];
					}
				}
			}
			
			M = manr.size();
			
			// 사람 수 만큼 배열 생성
			time1 = new int[M];
			time2 = new int[M];
			// 2개의 계단까지 걸리는 시간 각각 저장 
			for (int i = 0; i < M; i++) {
				time1[i] = Math.abs(str1 - manr.get(i)) + Math.abs(stc1 - manc.get(i));
				time2[i] = Math.abs(str2 - manr.get(i)) + Math.abs(stc2 - manc.get(i));
			}
			ans = Integer.MAX_VALUE;
			sel = new boolean[M];
			// 모든 경우의 수 고려 -> 부분집합
			powerset(0);
			
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
	static void powerset(int idx) {
		if (idx == M) {
			list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            
            // 리스트에 각각 계단 이용하는 경우 나누어 저장
            for (int i = 0; i < M; i++) {
            	if (sel[i]) {
            		list1.add(time1[i]);
				}else {
					list2.add(time2[i]);
				}
			}

            // 리스트 정렬
            Collections.sort(list1);
            Collections.sort(list2);

            int case1 = 0;
            for (int i = 0; i < list1.size(); i++) {
            	// 3명 이하 이용 시
                int startTime = list1.get(i) + 1;
                // 3명 초과 이용 시 (i는 0부터)
                if (i >= 3) {
                    startTime = Math.max(startTime, list1.get(i - 3) + stair1 + 1);
                }
                // 이번 리스트에 대해 더 큰 수로 갱신
                case1 = Math.max(case1, startTime + stair1);
            }

            int case2 = 0;
            for (int i = 0; i < list2.size(); i++) {
                int startTime = list2.get(i) + 1;
                if (i >= 3) {
                    startTime = Math.max(startTime, list2.get(i - 3) + stair2 + 1);
                }
                case2 = Math.max(case2, startTime + stair2);
            }
			
            // 각 리스트 중 더 큰 경우 저장
			int subans = case1 >= case2 ? case1 : case2;
			if (subans < ans) {
				ans = subans;
			}
			return;
		}
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
	}

}
