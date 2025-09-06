package algo_self.programmers.sort;

import java.util.*;

class LV1_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            int A = cmd[0];
            int B = cmd[1];
            int C = cmd[2];
            int[] save = new int[B-A+1];
            int idx = 0;
            for (int j = A-1; j < B; j++) {
                save[idx++] = array[j];
            }
            Arrays.sort(save);
            answer[i] = save[C-1];
        }
        
        return answer;
    }
}

/**
 * 정렬
 * [문제]
 * array숫자배열과 commands이차원배열이 주어졌을 때,
 * commands의 [i, j, k]에 맞게 숫자배열의 i~j숫자들 중 정렬 후 k번째 숫자들을 구하시오.
 * 
 * 반복문을 통해 i~j번째 숫자들을 배열에 넣은 후, 정렬하여 k번째 숫자를 출력
 * 1-based index이므로 범위 및 k번째 숫자 찾을 때 유의.
 * 
 * copyOfRange을 사용할 수도 있음.
 * Arrays.copyOfRange(배열이름, 시작점, 끝점)
 */

