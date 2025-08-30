package algo_self.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 숨바꼭질3_13549 {
	
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		
		arr = new int[100_001];
		
		Arrays.fill(arr, -1);
		
		bfs(N, 0);
		
		System.out.println(arr[K]);
		
	}
	
	static void bfs(int N, int temp) {
		Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
			return a[1] - b[1];
		});
		pq.add(new int[] {N, temp});
		arr[N] = 0;
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int now = curr[0];
			int cnt = curr[1];
			
			if (now * 2 < 100_001 && (arr[now * 2] == -1 || arr[now * 2] > cnt)) {
				arr[now * 2] = cnt;
				pq.add(new int[] {now * 2, cnt});
			}
			if (now + 1 < 100_001 && (arr[now + 1] == -1 || arr[now + 1] > cnt + 1)) {
				arr[now + 1] = cnt + 1;
				pq.add(new int[] {now + 1, cnt + 1});
			}
			if (now - 1 >= 0 && (arr[now - 1] == -1 || arr[now - 1] > cnt + 1)) {
				arr[now - 1] = cnt + 1;
				pq.add(new int[] {now - 1, cnt + 1});
			}
		}
		
	}
	
}

/**
 * bfs
 * 
 * N에서 출발하여 K까지 도달하는데 걸리는 최단 시간 구하기
 * +1 / -1 이동에는 1만큼, *2 이동에는 0만큼 시간 소요
 * 
 * 조건이 0 <= N, K <= 100,000 이므로 100,001크기 배열 생성
 * -1로 채운 후 정답체크 및 방문체크용도로 사용
 * 
 * bfs 함수 생성
 * 최단거리를 구해야 하기 때문에 cnt가 낮은 순으로 정렬한 pq 생성
 * *2하는 경우부터 계산 및 +1, -1하는 경우 계산하여 pq에 추가
 * 
 * 조건의 범위 내에서
 * 방문하지 않았거나, cnt가 더 낮은 경우를 체크하며
 * arr[K] 최솟값 갱신
 * 
 */

