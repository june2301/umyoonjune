package algo_self.programmers.hash;

import java.util.*;

class LV1_폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        int ans = set.size() < nums.length/2 ? set.size() : nums.length/2;
        return ans;
    }
}

/**
 * Set
 * [문제]
 * N마리의 폰켓몬의 종류가 적힌 숫자 배열이 주어졌을 때,
 * 2/N 마리의 폰켓몬을 선택해서 고를 수 있는 최대 종류를 구하시오.(N은 항상 짝수)
 * 
 * 폰켓몬의 종류를 set에 모두 넣은 후
 * 뽑으려는 수(2/N)보다 종류가 적으면 set.size() 리턴 / 많으면 뽑으려는 수 리턴
 */

