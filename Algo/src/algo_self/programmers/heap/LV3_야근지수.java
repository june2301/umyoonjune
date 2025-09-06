package algo_self.programmers.heap;

import java.util.*;

class LV3_야근지수 {
    public long solution(int n, int[] works) {
        long ans = 0;
        int W = works.length;
        
        Arrays.sort(works);
        
        int idx = W-2;
        while (n > 0) {
            int diff = works[W-1] - works[idx];
            int dist = (W-1) - idx;
            
            if (diff == 0) {
                if (idx == 0) {
                    int minus = n / W;
                    int rest = n % W;
                    if (minus >= 1) {
                        for (int i = 0; i < W; i++) {
                            works[i] -= minus;
                            n -= minus;
                        }
                        for (int i = 0; i < rest; i++) {
                            works[i]--;
                            n--;
                        }
                    } else {
                        for (int i = 0; i < rest; i++) {
                            works[i]--;
                            n--;
                        }
                    }
                    break;
                } else {
                    idx--;
                    continue;
                }
            } else {
                if (diff * dist <= n) {
                    for (int i = W-1; i > idx; i--) {
                        works[i] -= diff;
                        n -= diff;
                    }
                } else {
                    int minus = n / dist;
                    int rest = n % dist;
                    if (minus >= 1) {
                        for (int i = W-1; i > idx; i--) {
                            works[i] -= minus;
                            n -= minus;
                        }
                        for (int i = W-1; i > W-1-rest; i--) {
                            works[i]--;
                            n--;
                        }
                    } else {
                        for (int i = W-1; i > W-1-rest; i--) {
                            works[i]--;
                            n--;
                        }
                    }
                }
            }
            
            idx--;
            
            if (n == 0) break;
        }
        
        for (int i = 0; i < W; i++) {
            if (works[i] < 0) continue;
            ans += Math.pow(works[i], 2);
        }
        
        return ans;
    }
}

/**
 * heap
 * [문제]
 * works에 남은 일의 시간들이 주어지고 퇴근까지 남은 시간 n이 주어진다.
 * 이 때 야근지수(= 퇴근 후 진행하는 일의 제곱의 합)가 최솟값을 구하시오.
 * 
 * -> n을 적당히 빼내어 남은 시간 각각의 제곱의 합이 최소가 되도록 구하시오
 * 
 * 풀이방식
 * [시뮬레이션]
 * : works를 정렬 후 뒤에서부터 한 칸씩 idx를 앞으로 가며 시간 평준화 작업
 * 한 칸 전진 후 [W-1]값(제일 뒤)과 차이(diff)와 바꿔야 하는 숫자의 개수(dist)를 구한 뒤,
 * 분기처리를 통해 남은 시간들 구하기
 * 1. diff가 0인 경우
 *   a. idx도 0인 경우
 *     1. 남은 n을 골고루 줄 수 있는 경우
 *     2. 남은 n을 골고루 못 주는 경우
 *   b. idx가 0이 아닌 경우
 *     idx 한 칸 더 전진
 * 2. diff가 0이 아닌 경우
 *   a. n이 넉넉한 경우 = dist만큼 diff를 뺄 수 있는 경우
 *     dist 범위 숫자들에 diff 빼주기
 *   b. n이 부족한 경우
 *     공통적으로 뺄 수 있을 만큼 뺀 후 남은 n값으로 1씩 빼주기
 * 
 * [heap]
 * PQ를 Collections.reverseOrder()로 선언 후 모든 시간 값을 담아줌
 * n이 0이 될 때까지 poll()하여 큰 숫자부터 1씩 빼고 다시 담는 과정 반복
 * 
 * 시간복잡도
 * [시뮬] : O(W log W)
 * [heap] : O(n log W)
 * 
 * n의 범위가 1,000,000이고, 숫자의 범위가 20000개까지라서
 * 한 개씩 확인하고 빼주더라도 최악의 경우 1.5e^7 수준
 * 
 * 가장 최적의 풀이 = PQ + 그룹 레벨링
 */

