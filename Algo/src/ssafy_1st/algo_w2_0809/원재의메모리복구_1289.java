package ssafy_1st.algo_w2_0809;

import java.util.Scanner;

public class 원재의메모리복구_1289 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = sc.nextLine();
			
			char[] ch = input.toCharArray();
			
			int cnt = 1; // 같은 숫자만 반복된게 아니면 모든 케이스는 끝에 한번 바꾸고 시작하는 것이므로
			for (int i = ch.length - 1; i > 0; i--) {
				char save = ch[i];
				if (save != ch[i-1]) {
					cnt++;
				}
			}
			if (ch[0] == '0') { // 0000이 초기상태이기 때문에
				cnt--;
			}
			
			System.out.println("#" + tc + " " + cnt);
			
		}
		
	}

}
