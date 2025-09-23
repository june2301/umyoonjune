package algo_self.programmers.binary_search;

import java.util.*;

class LV4_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int[] arr = new int[rocks.length+1];
        for (int i = 0; i < rocks.length; i++) {
            arr[i] = rocks[i];
        }
        arr[arr.length-1] = distance;
        
        long min = 1;
        long max = distance;
        long ans = 0;
        
        while (min <= max) {
            long mid = (min + max) / 2;
            long remove = 0;
            long last = 0;
            
            for (int rock : arr) {
                if (rock - last < mid) {
                    remove++;
                    if (remove > n) break;
                } else {
                    last = rock;
                }
            }
            
            if (remove > n) {
                max = mid - 1;
            } else {
                ans = mid;
                min = mid + 1;
            }
            
            
        }
        
        return (int) ans;
    }
}

/**
 * 이분탐색
 * [문제]
 * 출발지점부터 distance만큼 떨어진 도착지점이 있고 그 사이에 바위들이 rocks배열 위치에 주어짐.
 * 이 때 n개만큼의 바위를 제거할 때 각 지점 사이의 최솟값 중 가장 큰 값을 return하시오.
 * 
 * 지점간의 거리를 확인하기 위해 distance도 포함된 새로운 배열 arr 생성 및 초기화
 * 최대거리는 distance로 초기화 후 
 * 최소거리 중 최댓값을 찾기 위한 이분탐색 진행
 * 
 * mid값을 가져온 후 arr배열을 순회하며 간격이 mid보다 작으면 돌 제거 카운트
 * 돌을 n개보다 많이 제거해야한다? -> max 감소
 * 돌을 n개보다 적거나 같게 제거해야한다? -> min 감소 | ans = mid
 * 
 * 시간복잡도 : O(rocks.length * log(distance))
 */

