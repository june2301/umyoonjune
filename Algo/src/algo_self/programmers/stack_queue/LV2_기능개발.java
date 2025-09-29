package algo_self.programmers.stack_queue;

import java.util.*;

class LV2_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = speeds.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int p = progresses[i];
            int s = speeds[i];
            int time = (100 - p) % s > 0 ? (100 - p) / s + 1 : (100 - p) / s;
            int cnt = 0;
            for (int j = i; j < N; j++) {
                if (progresses[j] + speeds[j]*time >= 100) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > 0) q.add(cnt);
            i += cnt-1;
        }
        
        int M = q.size();
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            ans[i] = q.poll();
        }
        
        return ans;
    }
}

/**
 * [문제]
 * 각 작업의 진행도 progresses와 하루에 각 작업의 개발 속도 speeds 배열이 주어졌을 때
 * 이전 작업이 종료되지 않으면 이후 작업들은 배포될 수 없다.
 * 이 때 각 배포마다 몇 개의 기능이 배포되는지 return하시오
 * 
 * 각 기능 작업마다 며칠이 필요한지 time 변수에 계산하며 저장
 * 이후 진행되는 작업들에 대해 해당 time 내로 작업이 종료되는 개수 카운트
 * 종료 안되는 작업 나오면 break + 추가로 종료된 작업만큼 반복문 건너뛰기
 * 
 * 
 * Programmers 사이트에서 스택&큐 알고리즘으로 분류해두었지만 사용할 필요가 없어보임.
 */

