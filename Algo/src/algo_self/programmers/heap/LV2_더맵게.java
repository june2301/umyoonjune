package algo_self.programmers.heap;

import java.util.*;

class LV2_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int ans = 0;
        while(!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) {
                ans = -1;
                break;
            }
            
            int curr = pq.poll();
            int next = pq.poll();
            pq.add(curr + next*2);
            ans++;
        }
        
        return ans;
    }
}

/**
 * 힙
 * [문제]
 * 각 음식의 스코빌 지수 배열이 주어지고, 목표치 K가 주어진다.
 * 첫 번째로 가장 맵지 않은 음식 + (두 번째로 가장 맵지 않은 음식 * 2)
 * 위 식을 통해 모든 음식의 스코빌지수를 K이상 되도록 만드는 시행 횟수를 구하시오.
 * 단, 모든 음식을 K 이상으로 만들 수 없을 경우 -1 return
 * 
 * PQ생성 후 모든 음식 스코빌지수 추가
 * pq가 비어있지 않고, 가장 맵지 않은 음식의 수치가 K보다 낮을 경우 while문 반복
 * 첫 번째 + 두번째*2를 다시 pq에 넣으며 진행
 * 만약 pq에 음식이 1개만 남았다면 불가능하므로 ans = -1
 */

