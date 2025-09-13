package algo_self.programmers.exhaustive_search;

import java.util.*;

class LV1_모의고사 {
    public int[] solution(int[] answers) {
        
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int num = answers[i];
            if (A[i % 5] == num) cnt[0]++;
            if (B[i % 8] == num) cnt[1]++;
            if (C[i % 10] == num) cnt[2]++;
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == cnt[i]) list.add(i+1);
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}

/**
 * 완전탐색
 * [문제]
 * 1, 2, 3번 수포자가 각각 문제를 찍는 방식이 주어지고,
 * 문제의 정답이 주어졌을 때 가장 많이 맞추는 사람들을 오름차순으로 return하라.
 * 
 * 각각 찍는 방법을 배열로 만든 후
 * 정답들을 확인하면서 i % (배열크기) 를 통해 각각 찍은 문제가 맞았는지 카운트
 * 
 * 이후 가장 많이 맞춘 횟수를 구하고,
 * list를 이용해 가장 많이 맞춘 사람과 수를 구해서
 * 배열을 생성하여 정답 인원 추가 후 return
 * 
 * 정답을 출력하는 과정이 너무 길어보일 수 있지만 자바 특성상 가장 깔끔한 방법
 */

