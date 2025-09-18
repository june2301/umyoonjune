package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기_4991 {
	
	static int N, M;
    static char[][] map;
    static int sr, sc;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static List<int[]> dusts;
    static int[][] pair;
    static boolean[] check;
    static int K, best;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            map = new char[N][M];
            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 'o') { 
                    	sr = r; 
                    	sc = c; 
                    }
                }
            }

            dusts = new ArrayList<>();
            dusts.add(new int[] {sr, sc});
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == '*') {
                    	dusts.add(new int[] {r, c});
                    }
                }
            }
            K = dusts.size() - 1;
            if (K == 0) { sb.append(0).append('\n'); continue; }

            pair = new int[K + 1][K + 1];
            boolean impossible = false;
            for (int i = 0; i <= K; i++) {
                int[][] dist = bfs(dusts.get(i)[0], dusts.get(i)[1]);
                for (int j = 0; j <= K; j++) {
                    int[] d = dusts.get(j);
                    pair[i][j] = dist[d[0]][d[1]];
                    if (pair[i][j] == -1) {
                        impossible = true;
                    }
                }
            }
            if (impossible) {
            	sb.append(-1 + "\n");
            	continue;
            }

            check = new boolean[K+1];
            best = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append(best == Integer.MAX_VALUE ? -1 : best + "\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int cnt, int cost) {
        if (cost >= best) return;
        if (cnt == K) {
            best = Math.min(best, cost);
            return;
        }

        for (int j = 1; j <= K; j++) {
            if (check[j]) continue;
            int d = pair[i][j];
            if (d == -1) continue;
            check[j] = true;
            dfs(j, cnt + 1, cost + d);
            check[j] = false;
        }
    }

    static int[][] bfs(int sr, int sc) {
        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 'x') continue;
                if (dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return dist;
    }
}