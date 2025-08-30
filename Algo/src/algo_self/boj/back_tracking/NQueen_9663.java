package algo_self.boj.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen_9663 {
	
	static int N, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ans = 0;
		arr = new int[N];
		
		queen(0);
		System.out.println(ans);
		
	}
	
	static void queen(int idx) {
		if (idx == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[idx] = i;
			if (check(idx)) {
				queen(idx + 1);
			}
		}
	}
	
	static boolean check(int idx) {
		for (int i = 0; i < idx; i++) {
			if (arr[idx] == arr[i]) {
				return false;
			} else if (Math.abs(idx-i) == Math.abs(arr[idx]-arr[i])) {
				return false;
			}
		}
		return true;
	}

}

/**
 * 백트래킹
 * [문제]
 * N*N크기의 체스판에 N개의 Queen을 서로 공격하지 않는 위치에 배치시키는 경우의 수 구하기
 * 
 * arr[N] 배열을 생성하여
 * arr[r]=c를 통해 r,c 좌표를 구현
 * ex) arr[2]=1 이면 (2, 1) 좌표에 위치
 * 
 * *같은 행* 검사는 arr[]에 애초에 값을 한 개만 넣기 때문에 괜찮
 * 
 * check()함수를 통해 같은 열 / 대각선 검사
 * arr[A]와 arr[B]의 값이 같으면 => 서로 같은 열에 존재
 * A-B와 arr[A]-arr[B]의 값이 같으면 => 서로 대각선 위치에 존재
 * 모두 통과 -> 놓을 수 있는 위치
 * 
 * 완전 탐색을 통해 N개만큼 놓게되면 경우의 수++
 */


