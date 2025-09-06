package algo_self.programmers.dfs_bfs;

class LV2_타겟넘버 {
    
    int tar;
    int[] arr;
    int N;
    int ans;
    
    public int solution(int[] numbers, int target) {
        ans = 0;
        arr = numbers.clone();
        tar = target;
        N = numbers.length;
        
        dfs(0, 0);
        
        return ans;
    }
    
    void dfs(int now, int dep) {
        if (dep == N) {
            if (now == tar) {
                ans++;
            }
            return;
        }
        
        dfs(now + arr[dep], dep + 1);
        dfs(now - arr[dep], dep + 1);
        
    }
}

/**
 * dfs
 * [문제]
 * 숫자 배열과 타겟 숫자가 주어졌을 때,
 * 모든 숫자를 이용해 각 숫자를 더하고 빼면서 타겟 숫자를 만드는 경우의 수를 구하시오.
 * 
 * dfs를 이용하여, 각 숫자를 더하는 경우와 빼는 경우를 재귀로 계산
 * 모든 숫자를 사용하였을 때, 타겟 넘버와 같다면 ans++
 */

