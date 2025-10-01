package algo_self.programmers.exhaustive_search;

import java.util.*;

class LV2_소수찾기 {
    
    Set<Integer> set;
    int len, ans;
    int[] arr;
    boolean[] sel;
    
    public int solution(String numbers) {
        len = numbers.length();
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        
        set = new HashSet<>();
        sel = new boolean[len];
        
        dfs("", 0);
        
        ans = 0;
        for (int num : set) {
            if (isPrime(num)) ans++;
        }
        return ans;
    }
    
    void dfs(String curr, int depth) {
        if (!curr.equals("")) {
            set.add(Integer.parseInt(curr));
        }

        if (depth == len) return;

        for (int i = 0; i < len; i++) {
            if (!sel[i]) {
                sel[i] = true;
                dfs(curr + arr[i], depth + 1);
                sel[i] = false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

/**
 * 완전탐색
 * [문제]
 * 길이 1이상 7이하 숫자들이 String으로 주어졌을 때 각각의 숫자를 조합해서 숫자를 몇 개 만들 수 있는지 return
 * 
 * 우선 String을 숫자 하나씩 int배열로 저장
 * 이후 dfs를 통해 set에 숫자조합들을 하나씩 저장
 * dfs - sel[] 배열을 통해 모든 숫자 조합 구성(순열)
 * 
 * 이후 set에 저장된 숫자들을 바탕으로 소수 검증
 * 각 숫자에 대해 제곱근까지 나누어보며 소수인지 판단
 */

