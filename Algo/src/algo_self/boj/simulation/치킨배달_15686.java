package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 치킨배달_15686 {
	
	static int N, M;
	static int[][] map;
	static List<int[]> chicken;
	static int[][] survive;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		map = new int[N][N];
		chicken = new ArrayList<int[]>();
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (map[r][c] == 2) {
					chicken.add(new int[] {r, c});
				}
			}
		}
		
		survive = new int[M][2];
		ans = Integer.MAX_VALUE;
		combination(0, 0);
		
		System.out.println(ans);
		
	}
	
	static void combination(int idx, int start) {
		if (idx == M) {
			int sum = bfs();
			ans = Math.min(sum, ans);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			survive[idx] = chicken.get(i);
			combination(idx + 1, i + 1);
		}
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			int r = survive[i][0];
			int c = survive[i][1];
			q.add(new int[] {r, c, 0});
			visited[r][c] = true;
		}
		
		int sum = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int d = curr[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
				if (map[nr][nc] == 1) {
					sum += d+1;
					if (sum > ans) {
						return Integer.MAX_VALUE;
					}
				}
				q.add(new int[] {nr, nc, d+1});
				visited[nr][nc] = true;
			}
		}
		
		return sum;
	}
	
}

/**
 * 시뮬레이션 + 백트래킹
 * [문제]
 * N*N지도에 빈칸0 집1 치킨집2가 주어졌을 때, 치킨거리는 각 집에서 치킨집까지의 최단거리이며, 
 * 도시의 치킨거리는 모든 집의 치킨거리를 합한 값이다.
 * 이 때 M개의 치킨집만 살아남는다 했을 때 해당 도시의 치킨거리의 최솟값을 구하시오.
 * 
 * 전체 치킨집들 중 M개를 선택하는 것이므로
 * 조합(Combination)을 이용하여 경우의 수로 진행
 * 
 * 지도를 입력받으며 치킨집 위치를 리스트에 저장해두고
 * M개를 선택 후 해당 치킨집들부터 Q에 넣으며 탐색 시작
 * 집에 도착하는 거리를 모두 구한 후 최솟값과 비교하며 정답 출력
 * 
 * -- 추가 탐구 --
 * bfs에 이미 ans를 넘어가면 return시킬 경우
 * 메모리 : 255MB -> 242MB
 * 시간 : 396ms -> 380ms
 * 
 * 가장 강력한 최적화 -> 치킨-집 거리 모두 구해둔 후 Combination진행
 * 메모리 : 12MB
 * 시간 : 124ms
 * (코드 아래 참조)
 */

//public class 치킨배달_15686 {
//    static int N, M;
//    static List<int[]> houses = new ArrayList<>();
//    static List<int[]> chickens = new ArrayList<>();
//    static int H, C;
//    static int[][] dist;         
//    static int[] pick;           
//    static int ans = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] nm = br.readLine().split(" ");
//        N = Integer.parseInt(nm[0]);
//        M = Integer.parseInt(nm[1]);
//
//        for (int r = 0; r < N; r++) {
//            String[] row = br.readLine().split(" ");
//            for (int c = 0; c < N; c++) {
//                int v = Integer.parseInt(row[c]);
//                if (v == 1) {
//                	houses.add(new int[]{r, c});
//                } else if (v == 2) {
//                	chickens.add(new int[]{r, c});
//                }
//            }
//        }
//
//        H = houses.size();
//        C = chickens.size();
//
//        dist = new int[H][C];
//        for (int i = 0; i < H; i++) {
//            int hr = houses.get(i)[0];
//            int hc = houses.get(i)[1];
//            for (int j = 0; j < C; j++) {
//                int cr = chickens.get(j)[0];
//                int cc = chickens.get(j)[1];
//                dist[i][j] = Math.abs(hr - cr) + Math.abs(hc - cc);
//            }
//        }
//
//        pick = new int[M];
//        comb(0, 0);
//
//        System.out.println(ans);
//    }
//
//    static void comb(int cnt, int start) {
//        if (cnt == M) {
//            int sum = 0;
//            for (int h = 0; h < H; h++) {
//                int best = Integer.MAX_VALUE;
//                for (int k = 0; k < M; k++) {
//                    best = Math.min(best, dist[h][pick[k]]);
//                }
//                sum += best;
//                if (sum >= ans) break; 
//            }
//            ans = Math.min(ans, sum);
//            return;
//        }
//        for (int i = start; i < C; i++) {
//            pick[cnt] = i;
//            comb(cnt + 1, i + 1);
//        }
//    }
//}