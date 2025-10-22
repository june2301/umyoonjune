package algo_self.programmers.dp;

import java.util.*;

class LV3_정수삼각형 {
    public int solution(int[][] triangle) {
        int ans = 0;
        int N = triangle.length;
        
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        for (int num : dp[N-1]) {
            ans = Math.max(ans, num);
        }
        
        return ans;
    }
}

/**
 * DP
 * [문제]
 * 삼각형 모양의 숫자들이 triangle 배열로 주어질 때, 위에서 아래(왼,오)로 한 칸씩 내려오면서
 * 숫자를 더했을 때 나오는 숫자의 최댓값을 return하시오.
 * 
 * [초기 아이디어]
 * int[] dp에 위에서부터 한 줄씩 확인하면서 아래 2개에 대해 더 큰 수를 저장하면서 진행하려고 함.
 * -> 1차원 배열로는 비교불가 + 위에서 아래로 진행하되, 아래 2개를 비교하는게 아니라 위의 두 개를 비교하면서 진행해야 함.
 * 
 * => 양쪽 사이드는 어차피 경우가 1개라 무조건 위에 있는 수를 더하고
 *    그 안쪽에 있는 수들만 양쪽 위의 숫자 중 더 큰 수를 더해오는 방식으로 진행
 * 
 * i는 1부터 N 아래까지 진행하며 j는 0부터 i까지 확인 (i는 행row, j는 열col)
 * j가 0이거나 i와 같다 -> 양쪽 끝이라 위에 수에서 그대로 더함
 * 나머지 경우에 대해서는 위의 왼,오 비교해서 더 큰 수 더하기
 */

