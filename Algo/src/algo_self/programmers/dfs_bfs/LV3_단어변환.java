package algo_self.programmers.dfs_bfs;

import java.util.*;

class LV3_단어변환 {
    
    class Word {
        String word;
        int dep;
        Word(String word, int dep) {
            this.word = word;
            this.dep = dep;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean exist = false;
        for (String w : words) {
            if (w.equals(target)) {
                exist = true;
                break;
            }
        }
        if (!exist) return 0;
        
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word now = q.poll();
            String cur = now.word;
            
            if (cur.equals(target)) return now.dep;
            
            for (int i = 0; i < words.length; i++) {
                boolean check = true;
                int cnt = 0;
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) != words[i].charAt(j)) cnt++;
                    if (cnt > 1) {
                        check = false;
                        break;
                    }
                }
                
                if (!visited[i] && check) {
                    visited[i] = true;
                    q.add(new Word(words[i], now.dep + 1));
                }
            }
        }
        
        return 0;
    }
    
}

/**
 * BFS
 * [문제]
 * begin으로 시작단어와 target으로 목표 단어가 주어지고, words 배열을 통해 중간 단어들이 주어진다.
 * 이 때 begin단어에서 출발하여 단어 중 한 글자씩만 변경하여 words 배열에 포함된 글자로만 변경하면서
 * target단어로 변경하려면 몇 번의 과정을 거쳐야하는지 구하시오.
 * (words 배열에 target 포함될수도 안될수도)
 * 
 * BFS를 이용해 풀이
 * begin단어에서 시작해서 한글자만 다른 경우에 대해 탐색을 진행
 * 이 때, 몇 번 변경했는지를 기록하기 위해 Word 클래스를 만든 후
 * String 단어와 함께 변경횟수 기록
 * 
 * 만약 words에 target단어가 포함되어 있지 않으면 불가능
 */

