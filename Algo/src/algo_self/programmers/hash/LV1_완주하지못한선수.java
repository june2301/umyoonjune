package algo_self.programmers.hash;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            if (m.containsKey(completion[i])) {
                m.put(completion[i], m.get(completion[i])+1);
            } else {
                m.put(completion[i], 1);
            }
        }
        
        for (int i = 0; i < participant.length; i++) {
            if (m.containsKey(participant[i])) {
                if (m.get(participant[i]) > 0) {
                    m.replace(participant[i], m.get(participant[i])-1);
                } else {
                    answer = participant[i];
                    break;
                }
            } else {
                answer = participant[i];
                break;
            }
            
        }
        return answer;
    }
}

/**
 * HashMap
 * [문제]
 * 마라톤에 참가한 선수 목록 participant와 완주한 선수 목록 completion이 주어지고,
 * 완주 못한 선수 한 명을 출력 (동명이인 허용)
 * 
 * Set을 사용하려했지만 동명이인이 존재하기 때문에 (이름, 명)으로 Map 사용
 * 완주 목록을 조회하며 Map에 (이름, 1)로 추가하며 이미 존재할 경우 +1해서 추가
 * 
 * 참가 목록을 조회하며 명수를 1씩 감소시키며
 * 이름이 없거나 명수가 0인 결과 출력
 * 
 * getOrDefault를 활용한 더 간단한 풀이 하단 첨부
 * getOrDefault(key, defaultValue) : 키에 해당하는 Value값을 가져오고 없으면 defaultValue 반환
 */

//	String answer = "";
//	
//	Map<String, Integer> m = new HashMap<>();
//	for (int i = 0; i < completion.length; i++) {
//	    m.put(completion[i], m.getOrDefault(completion[i], 0) + 1);
//	}
//	
//	for (int i = 0; i < participant.length; i++) {
//	    int cnt = m.getOrDefault(participant[i], 0);
//	    if (cnt == 0) {
//	        answer = participant[i];
//	        break;
//	    }
//	    m.put(participant[i], cnt - 1);
//	}
//	return answer;

