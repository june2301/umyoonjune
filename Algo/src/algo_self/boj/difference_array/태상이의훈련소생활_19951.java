package algo_self.boj.difference_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 태상이의훈련소생활_19951 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[] arr = new int[N+1];
		String[] arrInput = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i+1] = Integer.parseInt(arrInput[i]);
		}
		
		int[] diff = new int[N+2];
		for (int i = 0; i < M; i++) {
			String[] mission = br.readLine().split(" ");
			int start = Integer.parseInt(mission[0]);
			int end = Integer.parseInt(mission[1]);
			int val = Integer.parseInt(mission[2]);
			diff[start] += val;
			diff[end+1] -= val;
		}
		
		int curr = 0;
		for (int i = 1; i <= N; i++) {
			curr += diff[i];
			int ans = arr[i] + curr;
			sb.append(ans + " ");
		}
		
		System.out.println(sb);
	}

}

/**
 * 차분배열
 * [문제]
 * 배열길이 N과 지시 M이 주어지고,
 * N에 해당하는 배열과 M번의 지시(시작, 끝, 작업량)가 주어지고 
 * 모든 작업을 끝냈을 때의 배열을 출력
 * 
 * 작업 시작과 끝이 0부터 시작이 아니라 1부터 시작이기 때문에 배열을 N+1 크기로 생성
 * 이에 따라 변화량을 기록할 diff 배열을 N+2 크기로 생성
 * 
 * diff배열에 작업 시작점에 +변화량 / 끝+1 지점에 -변화량을 저장
 * curr 변수를 통해 변화량을 누적해가며 답을 구하기(변화량 누적을 위한 변수 생성 잊지말 것.)
 */

