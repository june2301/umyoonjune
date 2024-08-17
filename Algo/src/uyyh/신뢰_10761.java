package uyyh;

import java.util.Scanner;

public class 신뢰_10761 {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			// 로봇들 초기 위치
			int B = 1;
			int O = 1;
			String befwho = ""; // 이전 로봇
			// 로봇 이동 거리
			int Bcnt = 0;
			int Ocnt = 0;
			
			// 이전 로봇이 이동하느라 현재 로봇이 이동 가능한 거리
			int canMove = 0;
			
			for (int n = 0; n < N; n++) {
				
				String now = sc.next();
				int target = sc.nextInt();
				
				if (befwho.equals(now)) { // 이전과 같은 경우
					
					// 이동 거리에 (타겟 - 현재 위치) + 버튼누르는 시간1
					// canMove에 다음 이동 가능 추가
					if (now.equals("B")) {
						Bcnt += Math.abs(target - B) + 1;
						canMove += Math.abs(target - B) + 1;
						B = target;
					}else {
						Ocnt += Math.abs(target - O) + 1;
						canMove += Math.abs(target - O) + 1;
						O = target;
					}
					
				} else { // 이전과 다른 경우
					
					// 이동 거리 = (타겟 - 현위치)절대값 - 이전 이동 가능 거리
					// 이전 이동 거리가 지금 이동해야 할 거리보다 크면 move = 0;
					// move + 버튼 누르는 시간
					if (now.equals("B")) {
						int move = 0;
						if (canMove > 0) {
							move = Math.abs(target - B) - canMove;
						} else {
							move = Math.abs(target - B);
						}
						if (move < 0 ) {
							move = 0;
						}
						Bcnt += move + 1;
						B = target;
						canMove = move + 1;
					}else {
						int move = 0;
						if (canMove > 0) {
							move = Math.abs(target - O) - canMove;
						} else {
							move = Math.abs(target - O);
						}
						if (move < 0 ) {
							move = 0;
						}
						Ocnt += move + 1;
						O = target;
						canMove = move + 1;
					}
				}
				
				befwho = now;
				
			}
			System.out.println("#" + tc + " " + (Bcnt + Ocnt));
		}
		
	}

}
