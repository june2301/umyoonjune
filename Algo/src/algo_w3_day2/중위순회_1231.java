package algo_w3_day2;

import java.util.Scanner;

public class 중위순회_1231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			
			int N = Integer.parseInt(sc.nextLine());
			
			char[] tree = new char[101];
			
			for (int i = 0; i < N; i++) {
				String[] inputs = sc.nextLine().split(" ");
				int index = Integer.parseInt(inputs[0]);
				tree[index] = inputs[1].charAt(0);
			}
			int i = 1;
			StringBuilder sb = new StringBuilder();
			inorder(sb, tree, i);
			
			System.out.println("#" + tc + " " + sb);
		}
	}
	
	public static void inorder(StringBuilder sb, char[] tree, int i) {
		if ('A' <= tree[i] && tree[i] <= 'Z' || tree[i] == '_') {
			inorder(sb, tree, i * 2);
			sb.append(tree[i]);
			inorder(sb, tree, i * 2 + 1);
		} else {
			return;
		}
	}

}
