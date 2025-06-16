package ssafy_1st.im;

import java.util.Scanner;

public class 시험0819 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
			
        	int N = sc.nextInt();
        	
        	int[] LED = new int[N + 1];
        	for (int i = 0; i < N; i++) {
        		LED[i + 1] = sc.nextInt(); // N 5일때 길이 6
        	}
        	
        	int cnt = 0;
        	
        	for (int i = 1; i <= N; i++) {
        		if (LED[i] == 1) { // i번째 on이면
        			cnt++; 
        			for (int j = i; j <= N; j += i) {
        				LED[j] = 1 - LED[j]; // i배수 상태 바꾸기
        			}
        		}
        	}
        	
        	System.out.println("#" + tc + " " + cnt);
        	
		}

    }

}
