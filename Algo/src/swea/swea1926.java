package swea;

import java.util.Scanner;

public class swea1926 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i < N+1; i++) {
			String s1 = Integer.toString(i);
			char[] c1 = s1.toCharArray();
			if (c1.length == 3) {
				if((c1[0]=='3'||c1[0]=='6'||c1[0]=='9')&&(c1[1]=='3'||c1[1]=='6'||c1[1]=='9')&&(c1[2]=='3'||c1[2]=='6'||c1[2]=='9')) {
					System.out.print("---");
				}else {
					System.out.print(s1);
				}
			}
			else if (c1.length == 2) {
				if((c1[0]=='3'||c1[0]=='6'||c1[0]=='9')&&(c1[1]=='3'||c1[1]=='6'||c1[1]=='9')) {
					System.out.print("--");
				}else {
					System.out.print(s1);
				}
			}
			else if (c1.length == 2) {
				if (s1.contains("3") || s1.contains("6") || s1.contains("9")) {
					System.out.print("-");
				}
			}else {
				System.out.print(s1);
			}
			System.out.print(" ");
		}
		
	}

}
