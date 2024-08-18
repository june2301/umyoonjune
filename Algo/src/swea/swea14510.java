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
		main : while (tree[0] != tree[N-1]) {
			if (water == 1) {
				
				for (int i = 0; i < N; i++) {
					if (tree[i] + 1 == tree[N-1]) {
						tree[i] += 1;
						cnt++;
						water = 2;
						Arrays.sort(tree);
						System.out.println(Arrays.toString(tree) + " " + cnt);
						continue main;
					}
				}
				System.out.println("여긴가");
				if (tree[1] == tree[N-1] && tree[0] < tree[N-1] - 1) { 
					// [1]번째가 이미 같고
					// 0번째가 제일 큰 수와 2이상 차이 날때
					cnt++;
					water = 2;
					continue;
				} else {
					tree[0] += water;
					cnt++;
					water = 2;
				}
				System.out.println(Arrays.toString(tree) + " " + cnt);
			} else {
				
				for (int i = 0; i < N; i++) {
					if (tree[i] + 2 == tree[N-1]) {
						tree[i] += 2;
						cnt++;
						water = 1;
						Arrays.sort(tree);
						System.out.println(Arrays.toString(tree) + " " + cnt);
						continue main;
					}
				}
				
				if (tree[0] == tree[N-1]-1) {
					cnt++;
					water = 1;
					continue;
				} else {
					tree[0] += water;
					cnt++;
					water = 1;
				}
				System.out.println(Arrays.toString(tree) + "여기지 " + cnt);
			}
			
//			3 3 5 10  1
//			3 5 5 10  2
//			4 5 5 10  1
//			5 5 6 10  2
//			5 6 6 10  1
//			6 6 7 10  2
//			6 7 7 10  1
//			7 7 8 10  2
//			7 8 8 10  1
			
//			7 8 10 10 2
//			8 8 10 10 1
//			8 10 10 10 2
//			8 10 10 10 1x
//			10 10 10 10 2
			
//			8 8 9 10  2
//			8 9 9 10  1
//			9 9 10 10  2
//			9 10 10 10  1
//			9 10 10 10  2x
//			10 10 10 10  1
			
			Arrays.sort(tree);
			System.out.println(Arrays.toString(tree) + " " + cnt);
		}
		
		System.out.println(cnt);
		
		
		
	}

}
