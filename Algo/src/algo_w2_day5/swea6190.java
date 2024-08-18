package algo_w2_day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea6190 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[] input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] =sc.nextInt();
			}
			
			List<Integer> nums = new ArrayList<>(); // 단조 숫자 저장 List
			List<String> snum = new ArrayList<>(); // 곱한 숫자 String으로 저장할 List
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					snum.add(Integer.toString(input[i]*input[j]));
				}
			}
			
			for (int i = 0; i < snum.size(); i++) {
				char[] cnum = snum.get(i).toCharArray(); // 곱해진 한 숫자를 char[]로 숫자 하나씩 저장
				int check = 0;
				for (int j = 0; j < cnum.length - 1; j++) {
					if (cnum[j] <= cnum[j+1]) { // 단조인지 check++ 를 통해 확인
						check++;
					}
					if (check >= cnum.length-1) { // 마지막 숫자는 제외한 길이보다 check 많으면
						nums.add(Integer.parseInt(String.valueOf(cnum)));
					}
				}
			}
			
			int max = 0;
			for (int i = 0; i < nums.size(); i++) {
				if (nums.get(i) > max) {
					max = nums.get(i);
				}
			}
			if (nums.size() == 0) {
				max = -1;
			}
			
			System.out.println("#" + tc + " " + max);
		}
		
	}

}
