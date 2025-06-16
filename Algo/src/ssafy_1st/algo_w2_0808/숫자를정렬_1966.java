package ssafy_1st.algo_w2_0808;

import java.util.Scanner;

public class 숫자를정렬_1966 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine());
			String[] input = sc.nextLine().split(" ");
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(input[i]);
			}
			// 삽입정렬 
			for (int i = 1; i < N; i++) {
				int save = nums[i];
				int j;
				for (j = i - 1; j >= 0 && nums[j] > save; j--) {
					nums[j + 1] = nums[j];
				}
				nums[j + 1] = save;
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			
		}
		
		
	}

}
