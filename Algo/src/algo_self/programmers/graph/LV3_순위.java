package algo_self.programmers.graph;

import java.util.*;

class LV3_순위 {
    public int solution(int n, int[][] results) {
        int ans = 0;
        
        int[] win = new int[n+1];
        int[] lose = new int[n+1];
        
        int[][] graph = new int[n+1][n+1];
        for (int[] res : results) {
            graph[res[0]][res[1]] = 1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (graph[i][k] == 0) continue;
                for (int j = 1; j <= n; j++) {
                    if (graph[k][j] == 0) continue;
                    graph[i][j] = 1;
                }
            }
        }
        
        for (int w = 1; w <= n; w++) {
            for (int l = 1; l <= n; l++) {
                if (graph[w][l] == 1) {
                    win[w]++;
                    lose[l]++;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (win[i] + lose[i] >= n-1) ans++;
        }
        
        return ans;
    }
}

/**
 * 그래프 + 플로이드-워셜
 * [문제]
 * n명의 권투선수가 진행한 경기결과 results[][]가 주어진다.
 * 이 때 [A, B]에 대해 A가 B를 이기는 것이며, 실력이 좋은 선수가 항상 실력이 안좋은 선수를 이긴다.
 * 이 때 경기결과를 통해 선수들의 순위를 매기려고 할 때 몇몇 경기결과를 분실하여 정확하게 순위를 매길 수 없다.
 * 이 때 정확하게 순위를 매길 수 있는 선수의 수를 구하시오.
 * 
 * A->B : A가 B를 이긴다는 개념으로 그래프 형성
 * 이 때 누가 누구를 이길 수 있는지 체크하기 위해 플로이드-워셜 적용
 * -> 인접행렬로 그래프 구성
 * 
 * graph[이긴사람][진사람] = 1 로 기록
 * 플로이드-워셜을 통해 A->B 이고 B->C이면 A->C를 기록
 * => 누가 누구를 이길 수 있는지 전부 기록
 * 
 * 기록된 graph를 통해 각 n명의 선수가 이긴/진 횟수를 확인하여
 * n-1보다 크거나 같은 경우 순위 확정 가능
 */

