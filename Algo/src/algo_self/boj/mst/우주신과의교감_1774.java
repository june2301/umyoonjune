package algo_self.boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 우주신과의교감_1774 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] gods = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gods[i][0] = Integer.parseInt(st.nextToken());
            gods[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[][] linked = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            linked[a][b] = linked[b][a] = true;
        }

        boolean[] visited = new boolean[N];
        double[] dist = new double[N];
        double INF = Double.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[0] = 0;

        double ans = 0;
        for (int i = 0; i < N; i++) {
            int next = -1;
            double best = INF;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && dist[j] < best) {
                    best = dist[j];
                    next = j;
                }
            }
            visited[next] = true;
            ans += best;

            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    double d = linked[next][j] ? 0 : Math.hypot(gods[next][0] - gods[j][0], gods[next][1] - gods[j][1]);
                    if (d < dist[j]) dist[j] = d;
                }
            }
        }

        System.out.printf("%.2f\n", ans);
    }

}

/**
 * 프림 알고리즘
 * [문제]
 * 우주신의 수 N과 연결된 통로 M이 주어진다.
 * 이후 N개만큼의 우주신의 좌표와 연결된 우주신들의 번호 쌍이 M개만큼 주어진다.
 * 이 때 모든 우주신을 연결하기 위한 최소 길이를 소수점 둘째 자리까지 반올림하여 구하시오.
 * 
 * gods[N][2]에 각 우주신 좌표 저장
 * linked[N][N]에 통로 연결 정보 저장 + 이미 연결된 통로는 true
 * dist배열을 통해 각 정점 연결 최소 비용 저장
 * 
 * N번 반복:
 * 1. 방문하지 않은 정점 중 dist가 가장 작은 정점 선택
 * 2. 해당 정점을 방문 처리하고 ans에 비용 누적
 * 3. 선택한 정점과 다른 정점 간 거리(또는 0비용 연결)를 비교해 dist 갱신
 * -> dist갱신 + 최단거리 선택(방문처리) 반복
 * 
 * ans를 소수점 둘째 자리까지 출력
 */

