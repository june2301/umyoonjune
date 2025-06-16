package ssafy_1st.algo_2nd_0902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 나무높이_14510 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] tree = new int[N];
			for (int i = 0; i < N; i++) {
				tree[i] = sc.nextInt();
			}
			Arrays.sort(tree);
			
			List<Integer> save = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				save.add(tree[N-1] - tree[i]);
			}
			Collections.sort(save);
//			System.out.println(save);
			int water = 1;
			int day = 0;
			while (!save.isEmpty()) {
				for (int i = 0; i < save.size(); i++) {
					if (save.get(i) == 0) {
						save.remove(i);
					}
				}
				Collections.sort(save);
				for (int i = 0; i < save.size(); i++) {
					if (water == 1) {
						if (save.size() == 1 && save.get(i) == 2) {
							water = 2;
							break;
						}
						if (save.get(i) == 1) {
							save.set(i, save.get(i)-1);
							water = 2;
							break;
						}else if (save.get(i) > 1) {
							save.set(i, save.get(i)-1);
							water = 2;
							break;
						}
					}
					if (water == 2) {
						if (save.size() == 1 && save.get(i) == 1) {
							water = 1;
							break;
						}
						if (save.get(i) == 2) {
							save.set(i, save.get(i)-2);
							water = 1;
							break;
						}else if (save.get(i) > 2) {
							save.set(i, save.get(i)-2);
							water = 1;
							break;
						}
						int cnt = 0;
						if (save.get(i) == 1 && save.get(i+1) == 1 && save.size() == 2) {
							water = 1;
							day++;
							continue;
						}
					}
					
				}
				for (int i = 0; i < save.size(); i++) {
					if (save.get(i) == 0) {
						save.remove(i);
					}
				}
//				System.out.println(save);
				day++;
			}
			
			System.out.println(day);
			
		}
		
	}

}
