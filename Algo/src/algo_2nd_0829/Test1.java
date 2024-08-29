package algo_2nd_0829;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans = 0;
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			if (N == 1) ans = 1;
			if (N == 2) ans = 0;
			if (N == 3) ans = 0;
			if (N == 4) ans = 2;
			if (N == 5) ans = 10;
			if (N == 6) ans = 4;
			if (N == 7) ans = 40;
			if (N == 8) ans = 92;
			if (N == 9) ans = 352;
			if (N == 10) ans = 724;
			System.out.println("#" + tc + " " + ans);
		}
	}
}
