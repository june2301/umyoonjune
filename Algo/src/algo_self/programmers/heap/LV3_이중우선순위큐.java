package algo_self.programmers.heap;

import java.util.*;

class LV3_이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> downPQ = new PriorityQueue<>(); // 작은거
        PriorityQueue<Integer> upPQ = new PriorityQueue<>((a, b) -> {return b - a;}); // 큰거
        
        for (int i = 0; i < operations.length; i++) {
            String[] o = operations[i].split(" ");
            String oper = o[0];
            int num = Integer.parseInt(o[1]);
            
            if (oper.equals("D")) {
                
                if (num == 1) {
                    if (!upPQ.isEmpty()) {
                        upPQ.poll();
                    } else if (!downPQ.isEmpty()) {
                        while (downPQ.size() > 1) {
                            upPQ.add(downPQ.poll());
                        }
                        downPQ.poll();
                    }
                } else {
                    if (!downPQ.isEmpty()) {
                        downPQ.poll();
                    } else if (!upPQ.isEmpty()) {
                        while (upPQ.size() > 1) {
                            downPQ.add(upPQ.poll());
                        }
                        upPQ.poll();
                    }
                }
                
            } else {
                
                if (!upPQ.isEmpty()) {
                    
                    if (num < upPQ.peek()) {
                        downPQ.add(num);
                    } else {
                        downPQ.add(upPQ.poll());
                        upPQ.add(num);
                    }
                    
                } else {
                    upPQ.add(num);
                }
                
                if (!upPQ.isEmpty() && !downPQ.isEmpty()) {
                    
                    if (upPQ.peek() < downPQ.peek()) {
                        int tmp = downPQ.poll();
                        downPQ.add(upPQ.poll());
                        upPQ.add(tmp);
                    }
                }
                
            }
            
        }
        
        int[] ans = new int[2];
        
        if (!upPQ.isEmpty() && !downPQ.isEmpty()) {
            ans[0] = upPQ.poll();
            ans[1] = downPQ.poll();
        } else if (!upPQ.isEmpty()) {
            int num = upPQ.poll();
            ans[0] = num;
            ans[1] = num;
        } else if (!downPQ.isEmpty()) {
            int num = downPQ.poll();
            ans[0] = num;
            ans[1] = num;
        }
        
        return ans;
    }
}

/**
 * heap
 * [문제]
 * "I 숫자" : 큐에 숫자 삽입
 * "D 1" : 큐에서 최댓값 삭제 | "D -1" : 큐에서 최솟값 삭제
 * 위와 같은 연산들이 주어진 operations 배열이 주어졌을 때 연산이 끝난 후 큐에 남아있는 [최댓값, 최솟값]을 출력하시오
 * 남아있는 수가 없다면 [0, 0] 출력
 * 
 * 큰 수를 저장하는 upPQ와 작은 수를 저장하는 downPQ를 생성한 후 분기처리를 통해 계산
 * I의 경우 일단 upPQ에 넣고 만약 upPQ에 값이 있다면 크기를 비교하여 downPQ에 추가
 * 추가로 downPQ와 upPQ의 크기를 비교해서 값이 바껴야한다면 바꿔줌
 * 
 * D의 경우 1이면 upPQ에서 삭제 | -1이면 downPQ에서 삭제
 * 만약 비어있고 다른곳에는 숫자가 있다면, 마지막 숫자가 남을 때까지 반대로 보내고(최솟값or최댓값 찾기위해)
 * 이후 마지막 숫자 제거
 * 
 * PQ에 남은 값 확인 후 출력
 * 
 * 
 * ---위 방식보다 더 간단한 풀이(하단 주석)---
 * I의 경우 minQ와 maxQ에 둘 다 값을 추가
 * 이후 값을 제거할 때는 Q.remove(object)를 활용하여 양쪽에서 값 모두 제거
 * 
 * 하지만 두 방식 모두 최악의 경우 시간초과가 발생할 수 있음.
 * 1. while문으로 반복해서 찾게되면 최악의 경우 시간초과
 * 2. remove(object)가 O(n)만큼 시간을 들여서 최악의 경우 시간초과
 * 
 * [최적의 방안] -> TreeMap사용
 * 키값 기준으로 자동 정렬하기 때문에 최댓값은 map.lastKey() | 최솟값은 map.firstKey()를 한 후
 * map.get(키값) -> 중복 숫자 검사 후 중복이면 밸류-1 | 중복 아니면 map.remove(키값)
 */

//class Solution {
//    public int[] solution(String[] operations) {
//        PriorityQueue<Integer> minQ = new PriorityQueue<>();
//        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
//        
//        for (int i = 0; i < operations.length; i++) {
//            String[] s = operations[i].split(" ");
//            if (s[0].equals("I")) {
//                minQ.offer(Integer.valueOf(s[1]));
//                maxQ.offer(Integer.valueOf(s[1]));
//            } else if (s[0].equals("D")) {
//                if (s[1].equals("1") && !maxQ.isEmpty()) {
//                    int max = maxQ.poll();
//                    minQ.remove(max);
//                } else if (s[1].equals("-1") && !minQ.isEmpty()) {
//                    int min = minQ.poll();
//                    maxQ.remove(min);
//                }
//            }
//        }
//        
//        int min = minQ.isEmpty() ? 0 : minQ.poll();
//        int max = maxQ.isEmpty() ? 0 : maxQ.poll();
//        
//        return new int[] {max, min} ;
//    }
//}