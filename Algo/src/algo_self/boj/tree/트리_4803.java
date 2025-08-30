package algo_self.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 트리_4803 {
	
	static int[] p;
	static boolean[] cycle;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;
		while (true) {
			String[] nm = br.readLine().split(" ");
			
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			if (n == 0 && m == 0) break;
			
			p = new int[n+1];
			cycle = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				String[] input = br.readLine().split(" ");
				
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				
				union(x, y);
			}
			
			Set<Integer> parent = new HashSet<Integer>();
			for (int i = 1; i <= n; i++) {
				int root = find(i);
				if (!cycle[root]) {
					parent.add(root);
				}
			}
			int ans = parent.size();
			
			if (ans == 0) {
                System.out.println("Case " + T + ": No trees.");
            } else if (ans == 1) {
                System.out.println("Case " + T + ": There is one tree.");
            } else {
                System.out.println("Case " + T + ": A forest of " + ans + " trees.");
            }
			
			T++;
		}
		
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py) {
			cycle[px] = true;
		} else {
			boolean check = cycle[px] || cycle[py];
			p[py] = px;
            cycle[px] = check;
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
 * 트리
 * 주어지는 노드와 간선을 통해 트리 구조를 만들고 
 * cycle이 있는지 판단하여 총 몇 개의 트리가 있는지 판별하는 문제.
 * 
 * p[] 배열을 사용하여 입력받는 간선들을 바탕으로 해당 노드의 부모 노드를 표시
 * union을 통해 자식 노드와 부모 노드 연결
 * find를 통해 자식 노드의 부모 노드 찾기
 * 
 * 여기서 노드가 1번부터 주어지기에 p[0] = 0 이라는 점을 이용해서
 * 트리가 사이클을 이루는 경우 부모노드를 0으로 향하게 하여
 * 트리의 개수를 파악하는 방법이 있지만,
 * 
 * union-find 기본 원칙 상 
 * 각 원소는 하나의 집합에만 속하며,
 * 각 집합은 하나의 루트 노드를 갖는다.
 * p[x] = 0을 정상적인 루트로 간주하지 않음.
 * 
 * 따라서, cycle[] 배열을 통해 사이클을 이루는 노드들 파악
 * px 혹은 py 둘 중 하나라도 사이클이면 결과도 사이클.
 */
