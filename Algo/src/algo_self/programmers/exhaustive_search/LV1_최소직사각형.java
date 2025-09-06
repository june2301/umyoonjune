package algo_self.programmers.exhaustive_search;

class LV1_최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int AMax = 0;
        int BMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            int A = sizes[i][0];
            int B = sizes[i][1];
            if (B > A) {
                int temp = A;
                A = B;
                B = temp;
            }
            
            if (A > AMax) AMax = A;
            if (B > BMax) BMax = B;
        }
        
        answer = AMax * BMax;
        return answer;
    }
}

/**
 * 완전탐색
 * [문제]
 * (가로, 세로) 크기의 명함들이 주어질 때 모든 명함을 수납할 수 있는 지갑 크기(가로*세로)를 구하시오
 * 단, 명함은 회전 가능
 * 
 * 양쪽을 비교하여 한 쪽에만 긴 명함들을 배치하여 각각 최대값을 저장 후 곱하여 출력
 */

