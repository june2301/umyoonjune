package algo_self.programmers.binary_search;

import java.util.*;

class LV3_입국심사 {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long max = (long) n * times[0];
        long min = 0;
        
        while (min <= max) {
            
            long mid = (max + min) / 2;
            
            long sum = 0;
            for (int t : times) {
                sum += mid/t;
            }
            
            if (sum >= n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            
        }
        
        return min;
    }
}

/**
 * 이분탐색
 * [문제]
 * n명이 입국심사를 받아야 하며, 입국심사관들이 한 명 입국심사하는데 걸리는 시간 times 배열이 주어질 때
 * 모든 사람이 입국 심사를 받기 위한 최소시간을 구하시오.
 * 
 * 어떻게 이분탐색을 적용해야하나 고민.
 * times배열을 돌아다니며 가능한 사람을 순간순간 찾는다? -> [X]
 * 시간의 최댓값(times 가장 작은 값*n명)과 최소를 0으로 잡고 그 사이에 가능한 시간 찾기 -> [O]
 * (예시) 시간이 30일 때 times가 7, 10이면 각각 4명 3명 검사가능 -> n이 6인데 7명? -> 시간 줄이기
 * 
 * 범위가 10억단위기 때문에 max와 min을 long으로 선언 
 * (max값을 초기화할 때 n이나 times가 int이므로 둘 중 하나를 long으로 바꿔줘야 한다)
 * 
 * mid값을 가져온 후 각 시간들마다 mid값기준 몇 명 검사가능한지 더한 후
 * n명보다 크면 max감소 | n명보다 작으면 min 증가
 * 
 * 조건을 만족하는 최솟값 : min
 * 
 * 시간복잡도 : O(times.length * log(n * min(times)))
 */

