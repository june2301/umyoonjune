package algo_self.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄세우기_7570 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] pos = new int[N+1];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(input[i]);
			pos[num] = i;
		}
		
		int max = 1;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (pos[i+1] > pos[i]) {
				cnt++;
			} else {
				cnt = 1;
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(N-max);
	}

}

/**
 * 그리디/DP
 * [문제]
 * 어린이집에서 N명의 어린이들을 번호순서대로 줄을 세우려고 한다.
 * 이 때 한 명의 어린이를 맨 앞 혹은 맨 뒤로 보내는 방식으로 줄을 세울 때(이 때 빈 공간에는 뒤의 어린이들이 한 칸씩 당김)
 * 최소 몇 번의 어린이를 이동시켜 번호 순서대로 줄을 세울 수 있는지 구하시오.
 * 
 * [아이디어]
 * 연속된 증가하는 번호의 최댓값을 구한 후 N에서 뺀 만큼만 이동시킨다.
 * ex) 5 2 4 1 3 -> 최대로 연속하는 숫자 2 3 => 5,4,1 을 이동시키면 정답
 * 
 * 증가하는 번호들을 파악하기 위해
 * pos[번호] = 순서 형태로 저장
 * 
 * 이후 1번부터 N-1번까지
 * 다음 번호가 현재 번호보다 뒤에 위치하면 cnt증가
 * 끊기는 경우 cnt = 1로 초기화하며 최대 증가 번호 개수 구하기
 * 
 * 이후 N-max 출력
 */

