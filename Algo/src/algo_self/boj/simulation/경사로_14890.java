package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {
	
	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
        	st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
        
        int ans = 0;
        
        for (int c = 0; c < N; c++) {
        	if (check(map[c])) {
        		ans++;
        	}
        	int[] line = new int[N];
			for (int r = 0; r < N; r++) {
				line[r] = map[r][c];
			}
			if (check(line)) {
				ans++;
			}
		}
        
        System.out.println(ans);

	}
	
	static boolean check(int[] line) {
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N-1; i++) {
			int curr = line[i];
			int next = line[i+1];
			int diff = curr - next;
			if (diff == 0) continue;
			if (Math.abs(diff) > 1) return false;
			
			if (diff > 0) { // 내리막
				for (int j = 1; j <= L; j++) {
					int idx = i + j;
					if (idx >= N) return false;
					if (line[idx] != next) return false;
					if (visited[idx]) return false;
					visited[idx] = true;
				}
				i += L-1;
			} else { // 오르막
				for (int j = 0; j < L; j++) {
					int idx = i - j;
					if (idx < 0) return false;
					if (line[idx] != curr) return false;
					if (visited[idx]) return false;
					visited[idx] = true;
				}
			}
		}
		return true;
	}
	
}

/**
 * 시뮬레이션
 * [문제]
 * N*N크기의 지도에 서로 다른 높이가 주어지고, 경사로 길이 L이 주어진다.
 * 이 때 경사로의 높이는 1이고, 각 행/열마다 높이를 확인해서 경사로를 두어 이동가능한 경우의 수를 모두 구하시오.
 * 
 * 각 줄마다 검사하는 로직 구현
 * 기본적으로 curr과 next로 현재칸과 다음칸을 비교
 * 같으면 continue / 1초과로 다르면 불가능(false)
 * 
 * curr-next가 1이면 내리막
 * -> next부터 +L만큼 검사
 * curr-next가 -1이면 오르막
 * -> curr부터 -L만큼 검사
 * 
 * 우선 0~N 범위를 벗어나면 false / L까지 검사하는데 그 전에 높낮이가 또 다르면 false
 * 위 사항에 해당하지 않으면 범위 내의 같은 수
 * 여기서 오르막과 내리막이 반복되는 경우를 방지하기 위해 visited로 경사로를 두었을 경우 체크
 * 
 * 위 사항들에 해당되지 않는 경우 경사로를 정상적으로 둘 수 있음
 */

