import java.util.Arrays;

public class 순열03_방문체크 {

	static int[] nums;
	static int N;
	// 추가적인 공간 필요
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);
	}
	
	// idx : 결과 배열에 저장할 위치
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀부분
		for (int i = 0; i < N; i++) {
			// 사용하지 않은 원소를 가지고 만들어야한다
			// 1. 사용했으면 넘어간다 -> continue;
			// 2. 사용하지 않았다면 if() { 여기에 작성 }
			if (visited[i])	continue;
			result[idx] = nums[i];
			visited[i] = true; // 해당 i번째 원소 사용했음 확인
			perm(idx+1); // 다음 자리 판단
			visited[i] = false; // result는 덮어버리니까 굳이 초기화 할 필요X
		}
	}
	

}
