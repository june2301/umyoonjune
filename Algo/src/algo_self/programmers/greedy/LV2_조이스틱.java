package algo_self.programmers.greedy;

import java.util.*;

class LV2_조이스틱 {
    public int solution(String name) {
        char[] ca = name.toCharArray();
        int ans = 0;
        int N = ca.length;
        for(int i = 0; i < N; i++) {
            int diff = ca[i] - 'A';
            if (diff > 13) diff = 26 - diff;
            ans += diff;
        }
        int move = N - 1;
        for (int i = 0; i < N; i++) {
            int next = i + 1;
            
            while (next < N && ca[next] == 'A') next++;
            move = Math.min(move, 2 * i + (N - next));
            move = Math.min(move, i + 2 * (N - next));
        }
        ans += move;
        return ans;
    }
}

/**
 * 탐욕법
 * [문제]
 * 조이스틱을 움직여서 주어진 알파벳을 완성해야 하며 초기 상태는 A로만 구성(모두 대문자)
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
 * 이 때 알파벳을 완성하는데 최소 조작 횟수를 구하시오.
 * 
 * 알파벳 계산은 char값에서 'A'값을 뺸 것을 기반으로
 * 차이가 13보다 큰 경우 Z에서 이동하는게 더 빠르기 때문에 26에서 차이값을 빼줌
 * 
 * 핵심은 좌우 이동('A' 건너뛰기)
 * 최대 움직이는 경우 = N-1 | next = i+1부터 A가 아닌 위치 탐색
 * A영역을 피해 움직이는 경우 2가지
 * 1. 정방향(오른쪽)으로 가다가 꺾어서 역방향으로 가는 경우 = 2*i만큼 왕복 후 N-next만큼 더
 * 2. 역방향(왼쪽)으로 가다가 꺾어서 정방향으로 가는 경우 = N-next만큼 왕복 후 i만큼 더
 */

