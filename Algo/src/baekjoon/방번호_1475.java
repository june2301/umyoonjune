package baekjoon;

import java.util.Scanner;

public class 방번호_1475 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 0~9 카운트할 배열
		int[] ans = new int[10];
		
		// 숫자 입력받아서 배열에 하나씩 저장
		String input = sc.next();
		char[] c = input.toCharArray();
		int[] a = new int[input.length()];
		for (int i = 0; i < c.length; i++) {
			a[i] = (int)c[i] - '0';
		}
		
		// 각 숫자 개수 카운트
		for (int i = 0; i < a.length; i++) {
			ans[a[i]]++;
		}
		
		// 6과 9 처리
		if (ans[6] > ans[9]) {
			int num = ans[6] - ans[9];
			ans[9] += num/2;
			ans[6] -= num/2;
		}
		if (ans[9] > ans[6]) {
			int num = ans[9] - ans[6];
			ans[6] += num/2;
			ans[9] -= num/2;
		}
		
		// 최빈수 계산
		int max = 0;
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] > max) {
				max = ans[i];
			}
		}
		
		System.out.println(max);
	}

}
