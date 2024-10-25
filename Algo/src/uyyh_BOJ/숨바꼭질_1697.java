package uyyh_BOJ;

import java.util.Scanner;

public class 숨바꼭질_1697 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int cnt = 0;
		while (N != K) {
			if (Math.abs((N*2)-K) < Math.abs(N-K) ) {
				N *= 2;
				cnt++;
			} else {
				if (N > K) {
					N--;
				} else {
					N++;
				}
				cnt++;
			}
			System.out.println(cnt + " : " + N);
		}
		System.out.println(cnt);
		
		
		
	}

}
