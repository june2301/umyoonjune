package algo_self.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기10_2447 {

	static StringBuilder sb = new StringBuilder();;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
		
        for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				star(r, c, N);
			}
			sb.append("\n");
		}
        
		System.out.println(sb);
	}
	
	static void star(int r, int c, int n) {
		if ((r/n) % 3 == 1 && (c/n) % 3 == 1) {
			sb.append(" ");
			return;
		} 
		if (n == 1) {
			sb.append("*");
			return;
		}
		star(r, c, n/3);
	}

}

/**
 * 재귀
 * [문제]
 * N이 3의 거듭제곱 형태로 주어졌을 때 별이 가운데 공백을 갖고있는 패턴으로 나타난다.
 * N의 패턴은 가운데 (N/3)x(N/3) 크기의 공백을 N/3패턴으로 둘러싼 형태이다.
 * 이 때 N( < 3^8)에 따른 별을 출력하시오.
 * 
 * 아이디어
 * : 좌표 개념으로 접근하여 한 좌표마다 sb에 별 찍기 수행
 * 
 * 공백인 경우부터 생각
 * r과 c를 3으로 나눈 나머지가 1일 때 공백
 * -> n으로 나누어 어느 크기의 블록에 속하는지 파악
 *    N이 항상 3의 거듭제곱이므로 모든 구역을 9개로 나누었을 때
 *    r/n % 3 이 0이면 이전 / 1이면 중앙 / 2이면 이후
 *    r과 c가 중앙인 경우에 공백처리
 * 
 * 공백 이외의 영역
 * -> n을 계속 나누었을 때 아무 일도 일어나지 않고
 *    n이 1이된 모든 경우 : 별찍기
 */

