package ssafy_1st.algo_2nd_0827;

import java.util.Scanner;

public class 요리사_4012 {

    static int N, R;
    static int[][] point;
    static boolean[] check; // N개 중 N/2개씩 true false 나누기
    static int min;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            R = N / 2;
            point = new int[N][N];
            check = new boolean[N];
            min = Integer.MAX_VALUE;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    point[i][j] = sc.nextInt();
                }
            }
            
            comb(0, 0);
            
            System.out.println("#" + tc + " " + min);
            
        }
    }

    // 조합
    private static void comb(int idx, int sidx) {
    	// 조합으로 원하는 애들만큼 모였을 때 처리는 여기
        if(sidx == R) {
            int food1 = 0;
            int food2 = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(check[i] && check[j]) {
                        food1 += point[i][j];
                    }
                    if(!check[i] && !check[j]) {
                    	food2 += point[i][j];
                    }
                }
            }
            int diff = Math.abs(food1 - food2);
            if (diff < min) {
            	min = diff;
            }
            return;
        }
        
        // 조합 코드는 여기
        for (int i = idx; i <= N-R+sidx; i++) {
            check[i] = true;
            comb(i+1, sidx+1);
            check[i] = false;
        }
    }
}
