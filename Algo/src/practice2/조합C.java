package practice2;

import java.util.Arrays;

public class 조합C {

	static String[] input = {"상추", "패티", "토마토", "치즈"};
	static int N, R;
	static String[] sel; 
	
	public static void main(String[] args) {

		N = 4;
		R = 2;
		sel = new String[R];
		
		combination(0, 0); // nCr
		
	}
	
	static void combination(int idx, int sidx) {
		
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i = idx; i <= N-R+sidx; i++) {
			sel[sidx] = input[i];
			combination(i+1, sidx+1);
		}
		
	}

}
