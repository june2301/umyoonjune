package algo_self.programmers.greedy;

import java.util.*;

class SolutiLV1_체육복on {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        students[0] = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]] += 1;
        }
        
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]] -= 1;
        }
        
        for (int i = 0; i < lost.length; i++) {
            if (students[lost[i]] == 0) {
                if (students[lost[i]-1] == 2) {
                    students[lost[i]-1] -= 1;
                    students[lost[i]] += 1;
                } else if (lost[i]+1 <= n && students[lost[i]+1] == 2) {
                    students[lost[i]+1] -= 1;
                    students[lost[i]] += 1;
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) ans++;
        }
        
        return ans;
    }
}

/**
 * 탐욕법
 * [문제]
 * 학생수 n, 체육복을 잃어버린 학생 목록 lost, 체육복을 여분으로 가져온 학생 목록 reserve가 주어졌을 때
 * 체육복은 학생의 번호 앞/뒤 로만 빌려줄 수 있고, 체육복을 여분으로 가져온 학생도 원래 체육복을 잃어버릴 수 있다.
 * 이 때 체육 수업을 들을 수 있는 최대 학생 수를 구하시오.
 * 
 * 학생 번호가 1부터 주어지므로 n+1크기 학생 배열 선언 후 1로 초기화(0번 배열은 0)
 * 이후 여벌로 가져온 학생과 잃어버린 학생을 각각 +1/-1 하여 표시
 * 
 * 체육복이 0인 학생에 대해서 앞/뒤 순서로 확인하여 
 * 2벌 가지고 있는 학생에 대해 -1 / 0인 학생 +1 하여 체육복 채우기
 * 
 * 이후 전체 학생들 중 1벌 이상 가지고 있는 학생 카운트 후 return
 * 
 * **당연히 lost와 reserve가 정렬한 상태로 주어질 것이라 생각했지만 그렇지 않았음**
 * 앞/뒤 순서로 확인하기 때문에 반드시 정렬된 상태에서 순회해야 함.
 */

