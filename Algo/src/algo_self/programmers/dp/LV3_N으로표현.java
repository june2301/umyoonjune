package algo_self.programmers.dp;

import java.util.*;

class LV3_N으로표현 {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int i = 1; i <= 8; i++) {
            int re = 0;
            for (int r = 0; r < i; r++) {
                re += N * Math.pow(10, r);
            }
            dp.get(i).add(re);
            
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i-j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}

/**
 * DP
 * [문제]
 * 1~9사이의 N이 주어지고 N과 사칙연산만을 이용해서 number를 만드는데 필요한 가장 작은 N을 사용한 횟수를 return
 * 단, N을 8번보다 많이 사용할 경우 -1 return
 * ex) N=5, number=12 -> (55 + 5) / 5 -> 답:4
 * 
 * 초기 아이디어
 * int저장하는 dp배열을 number+1크기만큼 생성 후 각 숫자를 만드는데 필요한 N의 개수 저장하면서 진행
 * -> 규칙성이 마땅하지 않음 | NN/N 사용하거나 N-1을 N - N/N 으로 표현하는 경우가 많이 발생
 * 
 * 답 아이디어
 * List<Set> 형태로 dp 생성
 * list는 N을 몇번 사용해서 만들 수 있는 숫자들을 Set에 저장하는 방식 적용
 * 8까지 HashSet선언 후
 * 반복문을 통해 모든 경우의 수를 저장
 * 
 * 우선 N에 대해 N을 i번 붙인 숫자를 저장 ex) 5일 경우 i가 증가할수록 5, 55, 555 저장
 * 이후 i 이전 배열들과 조합하여 i번째 Set에 구할 수 있는 숫자들 저장
 * ex)
 * dp[1] = 5
 * dp[2] = 55, 10, 0, 25, 1
 * dp[3] = 555, 60, 50, 11, 30, 15, 125, 2, …
 * 
 * 이후 dp.get(i)가 number를 포함하고 있으면 종료
 */

