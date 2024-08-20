package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리순회_1991 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] tree = new char[N+1];
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			tree[i] = input[0].charAt(0);
		}
		
		preorder(tree, 1);
		System.out.println();
		inorder(tree, 1);
		System.out.println();
		postorder(tree, 1);
	}
	
	public static void preorder(char[] tree, int i) {
		if (i < tree.length) {
			System.out.print(tree[i]);
			preorder(tree, 2 * i);
			preorder(tree, 2 * i + 1);
		} else {
			return;
		}
	}
	
	public static void inorder(char[] tree, int i) {
		if (i < tree.length) {
			preorder(tree, 2 * i);
			System.out.print(tree[i]);
			preorder(tree, 2 * i + 1);
		} else {
			return;
		}
	}
	
	public static void postorder(char[] tree, int i) {
		if (i < tree.length) {
			preorder(tree, 2 * i);
			preorder(tree, 2 * i + 1);
			System.out.print(tree[i]);
		} else {
			return;
		}
	}

}
