package algo_w2_0805;

import java.util.Scanner;

public class 쇠막대기자르기_5432 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			String input = sc.next();
			int[] bar = new int[input.length()];
			
			// '('이면 1 ')'이면 0 '()' 이면 22 저장
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {
					if (input.charAt(i+1) == ')') {
						bar[i] = 2;
						bar[i+1] = 2;
					}else {
						bar[i]++;
					}
				}
			}
			int cnt = 0;
			int bnum = 0;
			// '('이면(1이면) bnum증가
			// '()'이면(22이면) bnum만큼 cnt 증가
			// ')'이면(0이면) bnum감소 cnt 1증가
			for (int i = 0; i < bar.length; i++) {
				if (bar[i] == 1) {
					bnum++;
				}
				else if (bar[i] == 2) {
					if (bar[i+1] == 2) {
						cnt += bnum;
						i++;
					}
				}
				else if (bar[i] == 0) {
					bnum--;
					cnt++;
				}
				
			}
			System.out.println("#" + tc + " " + cnt);
		}
		
	}

}
