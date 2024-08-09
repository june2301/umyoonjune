package swea;

import java.util.Arrays;
import java.util.Scanner;

public class swea14510 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
		}
		
		Arrays.sort(tree);
		
		int cnt = 0;
		int water = 1;
		while (tree[0] != tree[N-1]) {
			if (water == 1) {
				if (tree[0] < tree[N-1]) {
					tree[0] += water;
				}
				water = 2;
				cnt++;
			} else {
				if (tree[0] < tree[N-1]-1) {
					tree[0] += water;
				}
				water = 1;
				cnt++;
			}
			Arrays.sort(tree);
			System.out.println(Arrays.toString(tree));
		}
		
		System.out.println(cnt);
		
		
		
	}

}
