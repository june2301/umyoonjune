package algo_self.boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상근이의여행_9372 {
	
	static int[] p;

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int T = 1; T <= TC; T++) {
        	
        	String[] NM = br.readLine().split(" ");
        	int N = Integer.parseInt(NM[0]);
        	int M = Integer.parseInt(NM[1]);
        	
        	p = new int[N+1];
        	for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
        	
        	int cnt = 0;
        	for (int i = 0; i < M; i++) {
				String[] input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				
				int pa = find(a);
				int pb = find(b);
				if (pa != pb) {
					union(a, b);
					cnt++;
				}
			}
        	sb.append(cnt + "\n");
        	
        }
		
		System.out.println(sb);
		
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {
			p[py] = px;
		}
	}
	
	static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
}

/**
 * MST - 크루스칼
 * [문제]
 * 테스트케이스마다 N개의 국가 M개의 비행기가 주어진다.
 * 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력하시오.
 * 
 * -> a, b 를 연결해둔 비행기이기 때문에 N개의 국가를 여행하려면 N-1개의 비행기 필요
 * 따라서 답은 N-1
 * 
 * 하지만 크루스칼로 풀어보았다.
 * p배열 생성 후 각 i에 맞게 초기화
 * 이후 union-find를 통해 연결을 할 것인데,
 * 만약 pa와 pb가 다른 경우에만 union을 진행하며 발생 횟수 카운트
 * -> 타야하는 비행기 수 출력
 */

