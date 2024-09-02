package practice2;

public class 부분집합 {
	
	static String[] input = {"A", "B", "C", "D"};
	static int N;
	static boolean[] sel; 

	public static void main(String[] args) {

		N = 4;
		sel = new boolean[N];
		
		powerset(0);
		
	}
	
	static void powerset(int idx) {
		
		if (idx == N) {
			String res = "";
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					res += input[i] + " ";
				}
			}
			System.out.println(res);
			return;
		}
		
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
	}
	

}
