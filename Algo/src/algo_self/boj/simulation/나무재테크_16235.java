package algo_self.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 나무재테크_16235 {
	
	static class Tree {
		int r, c, y;

		public Tree(int r, int c, int y) {
			super();
			this.r = r;
			this.c = c;
			this.y = y;
		}
	}
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NMK = br.readLine().split(" ");
		int N = Integer.parseInt(NMK[0]);
		int M = Integer.parseInt(NMK[1]);
		int K = Integer.parseInt(NMK[2]);
		
		int[][] nutrients = new int[N+1][N+1];
		int[][] currN = new int[N+1][N+1];
		for (int r = 1; r <= N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 1; c <= N; c++) {
				nutrients[r][c] = Integer.parseInt(input[c-1]);
				currN[r][c] = 5;
			}
		}
		
		Deque<Tree> trees = new ArrayDeque<Tree>();
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int y = Integer.parseInt(input[2]);
			trees.add(new Tree(r, c, y));
		}
		
		int year = 0;
		while (year < K) {
			Queue<Tree> deadT = new LinkedList<>();

			int T = trees.size();
			for (int i = 0; i < T; i++) {
				Tree curr = trees.pollFirst();
				if (currN[curr.r][curr.c] >= curr.y) {
					currN[curr.r][curr.c] -= curr.y;
					curr.y++;
					trees.addLast(curr);
				} else {
					deadT.add(curr);
				}
			}

			for (Tree dt : deadT) {
				currN[dt.r][dt.c] += dt.y / 2;
			}

			Queue<Tree> q = new LinkedList<>();
			for (Tree tree : trees) {
				if (tree.y % 5 == 0) {
					q.add(tree);
				}
			}
			while (!q.isEmpty()) {
				Tree tree = q.poll();

				for (int i = 0; i < 8; i++) {
					int nr = tree.r + dr[i];
					int nc = tree.c + dc[i];
					if (nr <= 0 || nr > N || nc <= 0 || nc > N) continue;
					trees.addFirst(new Tree(nr, nc, 1));
				}
			}

			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					currN[r][c] += nutrients[r][c];
				}
			}
			
			year++;
		}
		
		System.out.println(trees.size());
		
	}
	
}

/**
 * 시뮬레이션
 * [문제]
 * N*N크기의 땅에 양분이 5가 있는 상태로 시작하며,
 * 겨울마다 추가될 좌표마다 양분값이 N*N크기로 주어진다.
 * M개의 나무가 심어진 r, c 좌표와 나이 y가 주어짐.
 * 봄 - 나무가 나이만큼 양분을 먹고 나이+1 / 양분이 부족하면 즉사 / 나이가 어린 나무부터 양분 먹음
 * 여름 - 죽은 나무가 나이/2 값으로 해당 땅에 양분 추가
 * 가을 - 나무의 나이가 5의 배수이면 주위 8칸에 나이 1짜리 나무 번식
 * 겨울 - 양분 추가
 * 
 * Tree 클래스를 만들어서 나무를 정의한 후
 * Deque에 모든 나무들을 넣는다.
 * 봄단계에서 Queue를 만들어 죽을 나무들을 추가해준 뒤 여름단계에서 소비
 * 계속 살아있는 나무는 addLast로 뒤에부터 추가
 * 가을에서 번식하는 나무들은 addFirst로 앞에서부터 추가
 * 겨울에는 양분 추가
 */

