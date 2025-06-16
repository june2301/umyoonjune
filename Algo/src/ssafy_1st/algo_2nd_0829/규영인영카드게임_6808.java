package ssafy_1st.algo_2nd_0829;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 규영인영카드게임_6808 {
	
	static int[] nums, kyu, in;
	static int[] deck;
	static boolean[] visit;
	static int kwin, iwin;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
			iwin = 0;
			kwin = 0;
			kyu = new int[9];
			in = new int[9];
			deck = new int[9];
			visit = new boolean[9];
			
			List<Integer> save = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				nums[kyu[i]-1] = 0;
			}
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					save.add(nums[i]);
				}
			}
			for (int i = 0; i < in.length; i++) {
				in[i] = save.get(i);
			}
			
			perm(0);
			
			System.out.println("#" + tc + " " + kwin + " " + iwin);
		}
		
	}
	
	static void perm(int idx) {
		if (idx == 9) {
			game();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visit[i])
				continue;
			deck[idx] = in[i];
			visit[i] = true;
			perm(idx+1);
			visit[i] = false;
		}
	}
	
	static void game() {
		int kScore = 0;
		int iScore = 0;
		for (int i = 0; i < 9; i++) {
			if (deck[i] > kyu[i]) {
				iScore += deck[i] + kyu[i];
			} else {
				kScore += deck[i] + kyu[i];
			}
		}
		if (iScore > kScore) {
			iwin++;
		}else {
			kwin++;
		}
		
	}

}
