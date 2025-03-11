package uyyh_BOJ_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Trie {
	HashMap<Character, Trie> children;
	boolean isEnd;

	Trie() {
		children = new HashMap<>();
		isEnd = false;
	}
}

public class 접두사찾기_14426 {

	static Trie root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		root = new Trie();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			insert(word);
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			String query = br.readLine();
			if (search(query)) {
				count++;
			}
		}

		System.out.println(count);
	}

	static void insert(String word) {
		Trie curr = root;
		for (char c : word.toCharArray()) {
			curr.children.putIfAbsent(c, new Trie());
			curr = curr.children.get(c);
		}
		curr.isEnd = true;
	}

	static boolean search(String prefix) {
		Trie curr = root;
		for (char c : prefix.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				return false;
			}
			curr = curr.children.get(c);
		}
		return true;
	}

}
