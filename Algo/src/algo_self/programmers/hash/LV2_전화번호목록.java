package algo_self.programmers.hash;

import java.util.*;

class LV2_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean ans = true;
        
        Set<String> set = new HashSet<>();
        for (String s : phone_book) {
            set.add(s);
        }
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = 1; j < s.length(); j++) {
                if (set.contains(s.substring(0, j))) return false;
            }
        }
        
        return ans;
    }
}

/**
 * Set
 * [문제]
 * 전화번호 목록이 문자열 배열로 주어졌을 때, 한 번호가 다른 번호의 시작부분과 같으면 접두어인 경우이다.
 * 만약 접두어인 경우가 있으면 false, 없으면 true를 return하시오.
 * 
 * 번호를 set에 모두 넣은 후 각 번호마다 잘라가며 set에 포함되어있는지 확인
 * 
 * 모든 책번호를 한번씩 확인하며 해당 번호를 1자씩 늘려가며 substring으로 자른 후
 * set.contains함수로 확인
 */

