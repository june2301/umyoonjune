package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
		
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        int[] commend = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
			commend[i] = Integer.parseInt(st.nextToken());
		}
        
        int[] dice = new int[7];
        
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < K; T++) {
			int comm = commend[T];
			
			if (comm == 1) {
				if (c+1 >= M) continue;
				c += 1;
				int tmp = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = tmp;
				
			} else if (comm == 2) {
				if (c-1 < 0) continue;
				c -= 1;
				int tmp = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = tmp;
				
			} else if (comm == 3) {
				if (r-1 < 0) continue;
				r -= 1;
				int tmp = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = tmp;
				
			} else if (comm == 4) {
				if (r+1 >= N) continue;
				r += 1;
				int tmp = dice[6];
				dice[6] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = tmp;
			}
			
			if (map[r][c] == 0) {
				map[r][c] = dice[1];
			} else {
				dice[1] = map[r][c];
				map[r][c] = 0;
			}
			
			sb.append(dice[6] + "\n");
        	
		}
        
        System.out.println(sb);
		
	}
	
}

/**
 * 시뮬레이션
 * [문제]
 * N*M 크기 지도가 주어지고 초기 주사위 위치 r,c가 주어지며 명령의 수 K가 주어진다.
 * 이후 N*M크기의 지도의 각 칸에 숫자가 주어지고, 명령(1~4)이 K개만큼 주어진다.
 * 명령은 동쪽1 서쪽2 북쪽3 남쪽4 로 구성되어 있으며 
 * 해당 방향으로 주사위를 굴릴 수 없으면 건너뛰고, 굴릴 수 있으면 주사위를 해당 방향으로 1번 굴린다.
 * 이 때 주사위가 있는 지도 칸의 숫자가 0이면 주사위의 숫자를 복사하고, 0이 아니면 주사위가 해당 칸의 숫자를 주사위 밑면에 복사해간다.
 * 그리고 이 때 주사위의 윗면을 출력한다.
 * 
 * 각각의 명령을 command배열에 입력받은 후 for문으로 해당 횟수만큼 실행
 * 
 * 이 문제에서 가장 중요한 것은 dice배열에 각 숫자의 이동을 잘 기록하는 것.
 *   2
 * 4 1 3
 *   5
 *   6
 * 문제에서 주어진 위 번호를 유지하도록 dice[7]배열을 생성 후
 * 1이 밑면 6이 윗면을 계속 유지하도록 주사위 숫자 이동
 * 동쪽1 : 3이 밑면으로 이동 (1 <- 3 <- 6 <- 4)
 * 서쪽2 : 4가 밑면으로 이동 (1 <- 4 <- 6 <- 3)
 * 북쪽3 : 5가 밑면으로 이동 (1 <- 5 <- 6 <- 2)
 * 남쪽4 : 2가 밑면으로 이동 (1 <- 2 <- 6 <- 5)
 * 
 * 이후 map[r][c]의 값에 따라 map[r][c]를 변경하거나 dice[1]인 밑면을 변경하며 진행
 * 주사위 윗면인 dice[6] 출력
 */

