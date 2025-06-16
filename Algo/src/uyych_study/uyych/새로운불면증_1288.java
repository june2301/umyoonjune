package uyych_study.uyych;

import java.util.Scanner;

public class 새로운불면증_1288 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int num = sc.nextInt();
			
			int[] count = new int[10];
			
			int i = 1;
			int num2 = 0;
			while (true) {
				num2 = num * i++;
				
				String save = Integer.toString(num2);
				
				char[] check = save.toCharArray();
				
				for (int j = 0; j < check.length; j++) {
					count[check[j] - '0']++;
				}
				
				int cnt = 0;
				for (int j = 0; j < count.length; j++) {
					if (count[j] > 0) {
						cnt++;
					}
				}
				if (cnt == 10) {
					break;
				}
			}
			
			System.out.println("#" + tc + " " + num2);
		}
		
	}

}
