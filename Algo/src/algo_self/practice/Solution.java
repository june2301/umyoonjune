package algo_self.practice;

import java.util.*;

public class Solution {
    public int[] solution(int[] metrics) {
        int n = metrics.length;
        if (n <= 1) return new int[0];

        int diff = metrics[1] - metrics[0];

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int temp = metrics[i] - metrics[i - 1];
            if (temp > diff) { // 비정상적으로 많이 생성된 순간
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}