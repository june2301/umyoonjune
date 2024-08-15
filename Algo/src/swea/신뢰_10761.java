package swea;

import java.util.Scanner;

public class 신뢰_10761 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int B = 1;
		int O = 1;
		
		int ans = 0;
		int Bcnt = 0;
		int Ocnt = 0;
		int move = 0;
		String befwho = "";
		for (int n = 0; n < N; n++) {
			String who = sc.next();
			if (who.equals("B")) {
				befwho = who;
				int num = sc.nextInt();
				if (befwho.equals("O")) {
					Bcnt += 0;
				} else {
					Bcnt += Math.abs(num - B); // 시행횟수 추가
				}
				B = num; // 위치 이동
			}
			if (who.equals("O")) {
				befwho = who;
				int num = sc.nextInt();
				if (befwho.equals("B")) {
					Ocnt += 0;
				} else {
					Ocnt += Math.abs(num - O); // 시행횟수 추가
				}
				O = num;
			}
			
		}
		System.out.println(ans);
		
	}

}
