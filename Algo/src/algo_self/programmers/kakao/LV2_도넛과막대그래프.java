package algo_self.programmers.kakao;

import java.util.*;

class LV2_도넛과막대그래프 {
    
    int[] ans = {0, 0, 0, 0};
    int INF = 1_000_001;
    List<Integer>[] gr;
    boolean[] visited;
    
    public int[] solution(int[][] edges) {
        gr = new ArrayList[INF];
        for (int i = 0; i < gr.length; i++) {
            gr[i] = new ArrayList<Integer>();
        }
        
        int high = 0;
        int[] in = new int[INF];
        int[] out = new int[INF];
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            gr[to].add(from);
            in[to]++;
            out[from]++;
            high = Math.max(high, Math.max(edges[i][0], edges[i][1]));
        }
        
        visited = new boolean[high+1];
        for (int i = 1; i <= high; i++) {
            if (in[i] == 0 && out[i] >= 2) {
                ans[0] = i;
                visited[i] = true;
            } else if (in[i] >= 2 && out[i] == 2) {
                ans[3]++;
                check(i);
            } else if (in[i] >= 1 && out[i] == 0) {
                ans[2]++;
                check(i);
            }
        }
        
        for (int i = 1; i <= high; i++) {
            if (visited[i]) continue;
            cycle(i, i);
        }
        
        return ans;
    }
    
    void cycle(int n, int p) {
        if (visited[n] && n == p) {
            ans[1]++;
            return;
        }
        
        visited[n] = true;
        
        for (int num : gr[n]) {
            cycle(num, p);
        }
    }
    
    void check(int n) {
        if (visited[n]) return;
        
        visited[n] = true;
        
        for (int num : gr[n]) {
            check(num);
        }
    }
}

/**
 * 구현
 * [문제]
 * 여러 개의 도넛, 막대, 8자 그래프가 존재하며 정점을 하나 추가하여 각각의 그래프의 임의의 정점과 연결했다.
 * 이 때 모든 정점들에 대한 간선 정보가 주어질 때 추가 정점의 번호, 각 그래프의 개수를 출력하시오.
 * 
 * 당연하게도 인접그래프 형식으로 간선의 정보를 저장하려고 했음.
 * 풀이 -> in/out 개수 파악을 통한 막대/8자 그래프 파악 + 역방향 인접그래프를 통한 탐색
 * 
 * 우선 입력 과정에서 각각의 간선 정보를 역방향으로 to<-from 형태로 저장
 * 각 정점에 대해 해당 정점을 향하는 간선의 개수와 해당 정점에서 나가는 간선의 개수를 저장
 * 
 * 이 때, 
 * in==0 out>=2 이면 추가 정점
 * in>=2 out==2 이면 8자 그래프 중심점
 * in>=1 out==0 이면 막대 그래프 종료점
 * 이를 바탕으로 해당 그래프들과 연결된 정점들을 전부 **방문처리**
 * 
 * 이후 남은 정점들에 대하여 cycle함수를 통해 도넛 그래프의 개수 확인
 * 
 * -------------------------------------------------
 * => 정석 풀이 방법
 * 
 * 인접 그래프 필요X
 * in/out 개수만 파악 후
 * 마찬가지로 추가정점/8자그래프/막대그래프 파악
 * 이후 추가 정점에 대한 out 개수 = 연결된 그래프 개수
 * out개수 - (8자+막대) = 도넛 그래프 수
 * 
 * 하단 풀이 참조
 */


//import java.util.*;
//
//class Solution {
//    public int[] solution(int[][] edges) {
//        int MAX = 1_000_001;
//        int[] in = new int[MAX];
//        int[] out = new int[MAX];
//        
//        // 진입, 진출 차수 계산
//        for (int[] e : edges) {
//            out[e[0]]++;
//            in[e[1]]++;
//        }
//
//        int newNode = 0;     // 새로 추가한 정점 번호
//        int donut = 0;       // 도넛 그래프 개수
//        int bar = 0;         // 막대 그래프 개수
//        int eight = 0;       // 8자 그래프 개수
//
//        // 1️ 추가한 정점 찾기
//        for (int i = 1; i < MAX; i++) {
//            if (in[i] == 0 && out[i] >= 2) {
//                newNode = i;
//                break;
//            }
//        }
//
//        // 2️ 생성 정점이 연결한 그래프 종류 판별
//        for (int[] e : edges) {
//            if (e[0] == newNode) continue;  // 생성 정점 → 각 그래프로 향하는 간선은 제외
//            // 결합점: 8자 그래프
//            if (in[e[1]] == 2 && out[e[1]] == 2) eight++;
//            // 끝점: 막대 그래프
//            else if (in[e[1]] >= 1 && out[e[1]] == 0) bar++;
//        }
//
//        // 3️ 도넛 개수 = (생성 노드에서 나간 간선 수) - (막대 + 8자)
//        donut = out[newNode] - (bar + eight);
//
//        return new int[]{newNode, donut, bar, eight};
//    }
//}
