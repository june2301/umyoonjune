package practice2;

public class 분할정복practice {

	public static void main(String[] args) {
		
		// 거듭제곱 - 분할정복
		int N = 2;
		int R = 10;
		System.out.println(pow(N,R));
		
	}
	
	// 거듭제곱 - 분할정복
	static int pow(int N, int R) {
		if (R == 0) {
			return 1;
		}
		if (R % 2 == 0) {
			return pow(N, R/2) * pow(N, R/2);
		} else {
			return pow(N, (R-1)/2) * pow(N, (R-1)/2) * N;
		}
	}

}
