package algo_2nd_0829;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 규영인영카드게임_6808 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
		
		int[] kyu = new int[9];
		List<Integer> save = new ArrayList<>();
		int[] in = new int[9];
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
		
		System.out.println(Arrays.toString(kyu));
		System.out.println(Arrays.toString(in));
		
	}

}
