package algo_self.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 거짓말_1043 {
	
	static int[] p;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		String[] knownInput = br.readLine().split(" ");
		int kcnt = Integer.parseInt(knownInput[0]);
		List<Integer> known = new ArrayList<Integer>();
		for (int i = 1; i <= kcnt; i++) {
			known.add(Integer.parseInt(knownInput[i]));
		}
		
		List<List<Integer>> parties = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			String[] partyInput = br.readLine().split(" ");
			int pcnt = Integer.parseInt(partyInput[0]);
			List<Integer> party = new ArrayList<>();
			for (int j = 1; j <= pcnt; j++) {
				party.add(Integer.parseInt(partyInput[j]));
			}
			
			for (int j = 1; j < pcnt; j++) {
				union(party.get(0), party.get(j));
			}
			parties.add(party);
		}
		
		int ans = 0;
		for (List<Integer> party : parties) {
			boolean able = true;
			for (int t : known) {
				if (find(t) == find(party.get(0))) {
					able = false;
					break;
				}
			}
			if (able) ans++;
		}
		
		System.out.println(ans);
		
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
 * 그래프 탐색
 * union-find 사용
 * 
 * 파티 인원들 중 첫 번째 인원을 부모 노드로 하여 연결
 * 이후 진실을 알고있는 인원과 부모가 같으면 해당 파티는 불가능
 * 가능한 파티 카운트하여 정답 출력
 */

