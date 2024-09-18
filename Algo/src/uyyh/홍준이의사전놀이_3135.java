package uyyh;

class Trie {
	Trie[] child; // 각 문자의 자식 노드를 저장할 배열
	int cnt; // 이 노드를 통해 시작하는 단어들의 개수를 저장

	public Trie() {
		child = new Trie[26]; // 알파벳 소문자 26글자에 대한 배열
		cnt = 0;
	}
}

public class 홍준이의사전놀이_3135 {

	Trie root;

	// 트라이 초기화
	public void init() {
		this.root = new Trie();
	}

	// 트라이에 단어 삽입
	public void insert(int buffer_size, String buf) {
		Trie node = root;
		for (int i = 0; i < buffer_size; i++) {
			char c = buf.charAt(i);
			int idx = c - 'a'; 
			if (node.child[idx] == null) { // 해당 문자로 시작하는거 없다면
				node.child[idx] = new Trie();
			}
			node = node.child[idx]; // 자식 노드로 이동
			node.cnt++; // 이 경로로 단어가 추가되었으므로 cnt 증가
			// 해당 자식 노드까지의 접두사로 시작하는 단어의 개수 알아서 cnt
		}
	}

	// 특정 접두사로 시작하는 단어의 개수 반환
	public int query(int buffer_size, String buf) {
		Trie node = root;
		for (int i = 0; i < buffer_size; i++) {
			char c = buf.charAt(i);
			int idx = c - 'a';
			if (node.child[idx] == null) {
				return 0; // 해당 접두사가 없으면 0 반환
			}
			node = node.child[idx]; // 자식 노드로 이동
		}
		return node.cnt; // 해당 접두사로 시작하는 단어의 개수 반환
	}
}
