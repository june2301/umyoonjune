package algo_self.programmers.greedy;

import java.util.*;

class LV2_구명보트 {
    public int solution(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int N = people.length;
        
        int l = 0, r = N-1;
        
        while (l <= r) {
            if (l == r) {
                ans++;
                break;
            }
            
            int sum = people[l] + people[r];
            
            if (sum > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            ans++;
        }
        
        return ans;
    }
}

/**
 * 탐욕 + 투포인터
 * [문제]
 * 사람들의 몸무게 정보가 담긴 people배열과 보트의 제한무게 limit이 주어지고
 * 한 보트에는 최대 2명씩밖에 못타며, 제한 무게를 넘기면 안된다.
 * 이 때 필요한 보트의 최솟값을 구하시오.
 * 
 * 배열을 정렬한 후 가장 가벼운 사람과 가장 무거운 사람을 각각 l과 r로 지정
 * 가장 무거운 사람은 가장 가벼운 사람과 못타면 혼자 타야됨
 * -> sum이 limit을 넘을 경우 r만 -1씩 이동
 * 둘 다 탈 수 있으면 l++ r-- 이동
 * 
 */

