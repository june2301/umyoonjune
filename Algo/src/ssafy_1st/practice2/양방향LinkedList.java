package ssafy_1st.practice2;

class Node {
	String data;
	Node next;
	Node prev;
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	void addData(int i, String data) {
		
		if (i < 0 || i > size) {
			System.out.println("범위 초과");
			return;
		}
		
		size++;
		
		Node curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.next;
		}
		
		Node newNode = new Node();
		newNode.data = data;
		// 여기까진 동일 (추가하기 전위치까지 curr 이동 + 새로운 노드 생성)
		// 단, 이동시 .link로 이동이 아니라 .next로 이동
		
		// newNode 링크 설정
		newNode.next = curr.next;
		newNode.prev = curr;
		
		// newNode의 앞 뒤 Node들 연결해주기
		curr.next.prev = newNode;
		curr.next = newNode;
		
	}
	
	void remove(int i) {
		
		if (i < 0 || i >= size) {
			System.out.println("범위 초과");
			return;
		}
		
		size--;
		
		// 삭제할 노드를 직접 찾아가기
		Node remNode = head.next; // head.next = 0번 노드부터 출발
		for (int j = 0; j < i; j++) {
			remNode = remNode.next;
		}
		
		// 삭제할 노드의 앞 뒤 노드 연결해주기
		remNode.prev.next = remNode.next;
		remNode.next.prev = remNode.prev;
		
	}
	
	Node get(int i) {
		
		if (i < 0 || i >= size) {
			System.out.println("범위 초과");
			return null;
		}
		
		// 찾을 노드 직접 찾아가기
		Node getNode = head.next; // head.next = 0번 노드부터 출발
		for (int j = 0; j < i; j++) {
			getNode = getNode.next;
		}
		
		// 그냥 그 노드 찾았으니 반환
		return getNode;
		
	}
	
	void printAll() {
		
		Node curr = head.next;
		
		while(curr != tail) {// head 다음부터 tail 전까지 출력
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		
		System.out.println();
		
	}
	
}

public class 양방향LinkedList {

	public static void main(String[] args) {
		
		DoublyLinkedList dl = new DoublyLinkedList();
		
		dl.addData(0, "A");
		dl.addData(0, "B");
		dl.addData(0, "C");
		dl.addData(0, "D");
		dl.addData(0, "E");
		
		dl.printAll();
		
		dl.remove(0);
		
		dl.printAll();
		
		System.out.println(dl.get(0).data);
		
		
	}

}
