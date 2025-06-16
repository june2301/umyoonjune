package ssafy_1st.practice;

class Node {
	String data;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;
	
	SinglyLinkedList() {
		head = new Node();
	}
	
	void addData(int i, String data) {
		
		if (i < 0 || i > size) {
			System.out.println("범위 초과");
			return;
		}
		
		size++;
		
		Node curr = head; // 현재 노드를 head로 시작
		for (int j = 0; j < i; j++) {
			curr = curr.link; // 삽입할 위치 전까지 이동
		}
		
		Node newNode = new Node(); // add로 추가할 노드 생성
		newNode.data = data; // data 넣어주기
		
		newNode.link = curr.link; // curr.link를 뺏어오고
		curr.link = newNode; // 추가된 노드를 curr.link로 연결
		
	}
	
	void delete(int i) {
		
		if (i < 0 || i >= size) {
			System.out.println("범위 초과");
			return;
		}
		
		size--;
		
		// curr = head부터 for문 돌리는건 항상 원하는 위치 전까지 curr 이동
		Node curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
		
	}
	
	Node get(int i) {
		
		if (i < 0 || i >= size) {
			System.out.println("범위 초과");
			return null;
		}
		
		Node curr = head;
		for (int j = 0; j < i; j++) {
			curr = curr.link;
		}
		
		return curr.link;
		
	}
	
	void printAll() { // 일단 확인용으로 루데맥꺼 긁어옴
		Node curr = head.link;

		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}
	
}


public class LinkedList연습 {

	public static void main(String[] args) {
		
		SinglyLinkedList sl = new SinglyLinkedList();
		
		sl.addData(0, "A");
		sl.addData(0, "B");
		sl.addData(0, "C");
		System.out.println(sl.size);
		
		sl.printAll();
		sl.delete(1);
		sl.printAll();
		
		System.out.println(sl.get(0).data);
		
	}

}
