package algo_2nd_0903;

import java.util.Scanner;

public class 수영장_1952 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int day = sc.nextInt();
		int mon1 = sc.nextInt();
		int mon3 = sc.nextInt();
		int year = sc.nextInt();
		
		int[] swim = new int[12];
		int sum = 0;
		for (int i = 0; i < 12; i++) {
			swim[i] = sc.nextInt();
			sum += swim[i];
		}
		
		
	}

}
