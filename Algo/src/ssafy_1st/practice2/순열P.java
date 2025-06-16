package ssafy_1st.practice2;

import java.util.Arrays;

public class 순열P {

	static int[] nums;
	static int N;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		
		nums = new int[] {0, 1, 2};
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		permutation(0);
		
	}
	
	static void permutation(int idx) {
		
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			result[idx] = nums[i];
			visited[i] = true;
			permutation(idx+1);
			visited[i] = false;
		}
		
	}

}
