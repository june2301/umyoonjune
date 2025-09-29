package algo_self.programmers.stack_queue;

import java.util.*;

class LV2_올바른괄호 {
    boolean solution(String s) {
        char[] c = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) return false;
        }
        
        return cnt == 0;
    }
}

/**
 * 스택
 * [문제]
 * 주어진 s에 괄호가 잘 짝지어졌으면 true, 아니면 false를 return하시오
 * 
 * (면 cnt++, )이면 cnt--해서 0 이하일 경우 탈락
 * 종료 후 cnt가 0이 아닐 경우에도 탈락
 * 
 * 
 * 스택을 활용한 코드
 * (이면 push, )이면 pop하는데 비어있을 경우 탈락
 * 종료 후 스택이 비어있지 않으면 탈락
 */

//class Solution {
//    boolean solution(String s) {
//        Stack<Character> stack = new Stack<>();
//        
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                stack.pop();
//            }
//        }
//        
//        return stack.isEmpty();
//    }
//}