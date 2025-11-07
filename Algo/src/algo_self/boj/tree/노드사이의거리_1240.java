package algo_self.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 노드사이의거리_1240 {
	
	static int N;
	static List<int[]>[] edges;
	static int[][] dist;

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		edges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int C = Integer.parseInt(input[2]);
			edges[A].add(new int[] {B, C});
			edges[B].add(new int[] {A, C});
		}
		
		dist = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String[] query = br.readLine().split(" ");
			int start = Integer.parseInt(query[0]);
			int end = Integer.parseInt(query[1]);
			sb.append(dist[start][end] + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void bfs(int start) {
		boolean[] visited = new boolean[N+1];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {start, 0});
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int node = curr[0];
			int cost = curr[1];
			for (int[] e : edges[node]) {
				if (visited[e[0]]) continue;
				visited[e[0]] = true;
				dist[start][e[0]] = cost + e[1];
				q.add(new int[] {e[0], cost + e[1]});
			}
		}
		
	}
	
}

/**
 * 트리 + bfs
 * [문제]
 * N개의 노드로 이루어진 트리에서 N-1개의 간선 정보(from, to, cost)가 주어진다.
 * 이 때 M개의 두 노드 쌍을 입력하였을 때 두 노드 사이의 거리를 구하시오.
 * 
 * 인접 리스트로 간선 정보 저장 후 
 * 각 정점에 대한 모든 노드 사이 거리를 이차원 배열로 저장
 * bfs에서 방문처리를 통해 재방문X
 * 
 * 이후 입력받은 두 노드 쌍 사이의 거리를 출력
 */

