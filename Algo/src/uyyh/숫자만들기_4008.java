package uyyh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 숫자만들기_4008 {
	
	static int N, M;
	static List<Character> cal;
	static char[] permCal;
	static boolean[] check;
	static int[] nums;
	static int min, max;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cal = new ArrayList<Character>();
			for (int i = 0; i < 4; i++) {
				int input = sc.nextInt();
				for (int j = 0; j < input; j++) {
					if (i == 0) cal.add('+');
					if (i == 1) cal.add('-');
					if (i == 2) cal.add('*');
					if (i == 3) cal.add('/');
				}
			}
			M = cal.size();
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			check = new boolean[M];
			permCal = new char[M];
			min = Integer.MAX_VALUE;
			max = 0;
			perm(0);
			System.out.println("#" + tc + " " + (max - min));
			
		}
		
	}
	
	static void perm(int idx) {
		
		if (idx == M) {
			int save = nums[0];
			for (int i = 0; i < N-1; i++) {
				if (permCal[i] == '+') save += nums[i+1];
				if (permCal[i] == '-') save -= nums[i+1];
				if (permCal[i] == '*') save *= nums[i+1];
				if (permCal[i] == '/') save /= nums[i+1];
			}
			if (save < min) {
				min = save;
			}
			if (save > max) {
				max = save;
			}
			return;
		}
		
		for (int i = 0; i < M; i++) {
			if (check[i]) continue; 
			permCal[idx] = cal.get(i);
			check[i] = true;
			perm(idx+1);
			check[i] = false;
		}
		
	}

}
