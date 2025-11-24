package algo_self.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 환승_5214 {
	
	static int N, K, M;
	static List<Integer>[] tube;
	static List<Integer>[] station;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NKM = br.readLine().split(" ");
		
		N = Integer.parseInt(NKM[0]);
		K = Integer.parseInt(NKM[1]);
		M = Integer.parseInt(NKM[2]);
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		
		tube = new ArrayList[M+1];
		for (int i = 1; i <= M; i++) {
			tube[i] = new ArrayList<Integer>();
		}
		
		station = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			station[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= M; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < K; j++) {
				int num = Integer.parseInt(input[j]);
				tube[i].add(num);
				station[num].add(i);
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {1, 1});
		
		boolean[] visitedTube = new boolean[M+1];
		boolean[] visitedStation = new boolean[N+1];
		visitedStation[1] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int now = curr[0];
			int cnt = curr[1];
			
			for (Integer t : station[now]) {
				if (visitedTube[t]) continue; 
				visitedTube[t] = true;
				
				for (Integer s : tube[t]) {
					if (s == N) return cnt+1;
					if (!visitedStation[s]) {
						q.add(new int[] {s, cnt+1});
						visitedStation[s] = true;
					}
				}
			}
		}
		
		return -1;
	}

}

/**
 * 그래프 + bfs
 * [문제]
 * N개의 역이 있고, K개의 역이 포함된 M개의 하이퍼튜브가 주어진다.
 * 1번역에서 출발해서 N번역으로 가는데 방문하는 최소 역의 수를 구하시오.
 * 
 * tube : 각 하이퍼튜브에 속한 역들 정보
 * station : 각 역이 어떤 튜브에 속해있는지
 * 
 * [이전 아이디어]
 * tube 하나만 이용해서 tube[i].contains를 이용해서 속한 튜브들의 역들로 탐색을 진행
 * -> 굉장히 비효율적
 * 
 * [아이디어]
 * 하이퍼튜브 정보 + 역이 속한 튜브 정보 따로 저장
 * bfs탐색을 1부터 시작하여 1이 속한 튜브들에 대해 모든 역을 탐색
 * 
 * 이 때, 역에 대한 방문처리 + 튜브에 대한 방문처리 모두 진행
 * 튜브에 대한 방문처리를 안할 경우 이미 방문한 튜브 속 역들을 모두 continue하느라 시간 매우 비효율
 * 
 * 만약 모두 탐색을 진행했는데 못찾은 경우 -1 return
 * N이 1인 경우 바로 1 return
 */

