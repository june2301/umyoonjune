package algo_2nd;

import java.util.Scanner;

public class 이진수표현_10726 {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String binary = Integer.toBinaryString(M);
			
			char[] save = binary.toCharArray();
			int cnt = 0;
			if (M > 0) {
				for (int i = save.length-N; i < save.length; i++) {
					if (binary.charAt(i) == '1') {
						cnt++;
					}
				}
			}
			String ans = "OFF";
			if (cnt >= N) {
				ans = "ON";
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
