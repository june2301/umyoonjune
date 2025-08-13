package uyych_study.uyych_swea;

import java.util.Scanner;

public class 간단369다시_1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			String s1 = Integer.toString(i);
			char[] c1 = s1.toCharArray();
			
			int cnt = 0;
			
			for (int j = 0; j < c1.length; j++) {
				if (c1[j] == '3' || c1[j] == '6' || c1[j] == '9') {
					cnt++;
				}
			}
			if (cnt == 3) {
				System.out.print("---" + " ");
			} else if (cnt == 2) {
				System.out.print("--" + " ");
			} else if (cnt == 1) {
				System.out.print("-" + " ");
			} else {
				System.out.print(s1 + " ");
			}
			
		}
		
	}

}
