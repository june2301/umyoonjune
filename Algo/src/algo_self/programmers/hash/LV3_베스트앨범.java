package algo_self.programmers.hash;

import java.util.*;

class LV3_베스트앨범 {
    
    class Music implements Comparable<Music>{
        String g;
        int cnt;
        int idx;
        
        public Music(String g, int cnt, int idx) {
            this.g = g;
            this.cnt = cnt;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Music m) {
            if (this.cnt != m.cnt) return m.cnt - this.cnt;
            return this.idx - m.idx;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> m = new HashMap<>();
        Map<String, PriorityQueue<Music>> mq = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            m.put(g, m.getOrDefault(g, 0) + p);
            
            if (!mq.containsKey(g)) {
                mq.put(g, new PriorityQueue<>());
            }
            mq.get(g).add(new Music(g, p, i));
        }
        
        List<String> orderG = new ArrayList<>(m.keySet());
        orderG.sort((a, b) -> m.get(b) - m.get(a));
        
        List<Integer> select = new ArrayList<>();
        for (String genre : orderG) {
            PriorityQueue<Music> q = mq.get(genre);
            for (int i = 0; i < 2 && !q.isEmpty(); i++) {
                select.add(q.poll().idx);
            }
        }
        
        int[] ans = new int[select.size()];
        for (int i = 0; i < select.size(); i++) {
            ans[i] = select.get(i);
        }
        return ans;
    }
}

/**
 * 힙 - Map
 * [문제]
 * genres에 곡의 장르와 plays에 해당 곡의 재생횟수가 주어진다.
 * 이 때 베스트 앨범에 장르별 가장 많이 재생된 노래 두 개씩을 모으려고 한다.
 * 1. 속한 노래가 많이 재생된 장르 먼저 수록
 * 2. 장르 내 많이 재생된 노래 먼저 수록
 * 3. 재생 횟수가 같으면 고유 번호(index번호)가 낮은 노래 수록
 * + 장르에 속한 곡이 하나면 하나의 곡 수록
 * 
 * [풀이]
 * 장르별 총 재생수를 관리하기 위해 Map<String, Integer> 사용
 * -> 전체 장르 중 어떤 장르가 먼저 나올지 정하기 위함
 * 장르별 곡들을 관리하기 위해 Map<String, PriorityQueue<Music>> 사용
 * -> 각 장르에서 재생수 기준 내림차순, 동률이면 idx 오름차순으로 정렬
 * genres와 plays를 순회하며:
 * 1) 장르별 총 재생수 누적
 * 2) 장르별 곡 PQ에 (장르, 재생수, 고유번호) 저장
 * 총 재생수를 기준으로 장르를 내림차순 정렬
 * 정렬된 장르 순서대로 각 PQ에서 최대 2곡 poll() 해서 결과 리스트에 추가
 *
 * [핵심]
 * - 장르 우선순위: 총 재생수 내림차순
 * - 곡 우선순위: 재생수 내림차순, 같으면 idx 오름차순
 * - HashMap으로 그룹핑, PriorityQueue로 정렬 처리
 */

