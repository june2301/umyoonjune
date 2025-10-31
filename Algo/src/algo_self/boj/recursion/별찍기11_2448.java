package algo_self.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기11_2448 {

	static char[][] map;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        map = new char[N][2*N-1];
		
        for (int r = 0; r < N; r++) {
			for (int c = 0; c < 2*N-1; c++) {
				map[r][c] = ' ';
			}
		}
        star(0, N-1, N);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
			sb.append(map[i]);
			sb.append("\n");
		}
        
		System.out.println(sb);
	}
	
	static void star(int r, int c, int n) {
		if (n == 3) {
            map[r][c] = '*';
            map[r+1][c-1] = '*';
            map[r+1][c+1] = '*';
            for (int i = -2; i <= 2; i++) {
            	map[r+2][c+i] = '*';
            }
            return;
        }

        int half = n/2;
        star(r, c, half);
        star(r+half, c-half, half);
        star(r+half, c+half, half);
	}

}

/**
 * 재귀
 * [문제]
 * N이 항상 3x2^k(3, 6, 12, 24, ...)로 주어지며 아래와 같은 모양이 반복될 때, N번째 줄까지 별을 출력하시오.
 *      *           
 *     * *          
 * 	  *****
 *   *     *      
 *  * *   * *      
 * ***** *****
 * 
 * 삼각형이 상단,좌하단,우하단에 반복되는 모양이며
 * 하나의 삼각형마다 고정된 형태를 보임.
 * 
 * N마다 가로가 2*N-1만큼 필요하므로
 * [N][2*N-1] 크기의 char배열 선언 후 공백으로 초기화
 * 
 * 이후 상단,좌하단,우하단으로 함수를 재귀호출하며
 * n이 3이되면 같은 모양의 삼각형 별찍기 수행
 */

