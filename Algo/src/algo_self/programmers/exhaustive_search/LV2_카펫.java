package algo_self.programmers.exhaustive_search;

import java.util.*;

class LV2_카펫 {
    public int[] solution(int brown, int yellow) {
        int sum = brown/2 + 2;
        
        int[] ans = new int[2];
        
        for (int i = 3; i <= sum/2; i++) {
            if ((i-2) * (sum-i-2) == yellow) {
                ans[0] = sum-i;
                ans[1] = i;
                break;
            }
        }
        
        return ans;
    }
}

/**
 * 완전탐색
 * [문제]
 * 중앙은 노란색 테두리 1줄은 갈색으로 칠해진 카펫이 있고,
 * 각 색깔의 격자칸의 개수가 주어질 때 카페의 크기(가로>세로)를 구하시오.
 * 
 * 가로a와 세로b에 대한 수식으로 나타내보면
 * brown = a*2 + (b-2)*2
 * yellow = (a-2)*(b-2)
 * 
 * brown의 식을 바꾸면 brown/2 + 2 = a+b 이다.
 * 이를 활용해서 a+b의 합(sum)을 구한 뒤,
 * 카펫의 최소 크기인 3부터 i를 정하여 반복문을 돌리며
 * (i-2) * (sum-i-2) 가 yellow가 나오는 숫자를 찾는다.
 */

