package uyyh_BOJ;

import java.util.Scanner;

public class 고층건물_1027 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] bui = new double[N];
		
		for (int i = 0; i < N; i++) {
			bui[i] = sc.nextDouble();
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			
			double left = Double.NEGATIVE_INFINITY;
			for (int j = i - 1; j >= 0; j--) {
				double slope = (bui[j]-bui[i]) / (j-i);
				if (slope > left) {
					left = slope;
					cnt++;
				}
			}
			
			double right = Double.NEGATIVE_INFINITY;
			for (int j = i + 1; j < N; j++) {
				double slope = (bui[i]-bui[j]) / (i-j);
				if (slope > right) {
					right = slope;
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}
