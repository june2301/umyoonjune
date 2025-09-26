package algo_self.programmers.stack_queue;

import java.util.*;

public class LV1_같은숫자는싫어 {
    public int[] solution(int []arr) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (d.size() > 0 && d.peek() == arr[i]) continue;
            d.addFirst(arr[i]);
        }
        int size = d.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = d.pollLast();
        }
        
        return ans;
    }
}

/**
 * 스택/큐 - Deque사용
 * [문제]
 * 0~9로 이루어진 숫자배열 arr가 주어지고, 
 * 연속해서 숫자가 나올 경우 한번만 해당 숫자는 그 구간에서 한번만 출력되도록 남은 숫자들을 return하시오
 * 
 * Deque을 사용해서 addFirst로 숫자를 넣으면서
 * peek()으로 방금 들어간 숫자와 같은 숫자인지 확인하며 continue
 * 
 * 이후 pollLast를 통해 원래 숫서대로 숫자 출력
 */

