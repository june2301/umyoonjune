package uyyh;

import java.util.Scanner;

public class 신뢰_10761 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int B = 1;
		int O = 1;
		
		// 이전 순서 기억해서
		// 같은 사람이면 move 가능 추가
		// 다른 사람이면 move 가능만큼 걸리는 시간 빼주고 계산
		
		// 상대가 하는동안 움직일 수 있도록 걸린시간 뺀 후 답 합치기
		String befwho = "";
		int Bcnt = 0;
		int Ocnt = 0;
		
		int canMove = 0;
		
		for (int n = 0; n < N; n++) {
			
			String now = sc.next();
			
			if (befwho.equals(now)) { // 이전과 같은 경우
				
				if (now.equals("B")) {
					int target = sc.nextInt();
					Bcnt += Math.abs(target - B) + 1;
					B = target;
					
					canMove += Math.abs(target - B) + 1;
					System.out.println("같을때 B : " + (Bcnt + Ocnt));
				}else {
					int target = sc.nextInt();
					Ocnt += Math.abs(target - O) + 1;
					O = target;
					
					canMove += Math.abs(target - O) + 1;
					System.out.println("같을때 O : " + (Bcnt + Ocnt));
				}
				
			} else { // 이전과 다른 경우
				
				if (now.equals("B")) {
					int target = sc.nextInt();
					int move = 0;
					if (canMove > 0) {
						move = target - B - canMove;
					} else {
						move = Math.abs(target - B);
					}
					if (move < 0 ) {
						move = 0;
					}
					Bcnt += move + 1;
					B = target;
					
					canMove = move + 1;
					System.out.println("다를때 B : " + (Bcnt + Ocnt));
				}else {
					int target = sc.nextInt();
					int move = 0;
					if (canMove > 0) {
						move = target - O - canMove;
						System.out.println(canMove);
						System.out.println(move);
					} else {
						move = Math.abs(target - O);
					}
					if (move < 0 ) {
						move = 0;
					}
					Ocnt += move + 1;
					O = target;
					
					canMove = move + 1;
					
					System.out.println("다를때 O : " + (Bcnt + Ocnt));
				}
			}
			
			befwho = now;
			
		}
		System.out.println("#" + (Bcnt + Ocnt));
		
	}

}
