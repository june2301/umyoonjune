package ssafy_1st.algo_w3_0813_L;

import java.util.Scanner;

class Node {
	int number;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;
	
	SinglyLinkedList() {
		head = new Node();
	}
	
	void add(int i, int number) {
		
		if (i < 0 || i > size) {
			System.out.println("삽입 위치 오류");
			return;
		}
		
		size++;
		
		Node newNode = new Node();
		newNode.number = number;
		
		Node cur = head;
		for (int j = 0; j < i; j++) {
			cur =cur.link;
		}
		
		newNode.link = cur.link;
		cur.link = newNode;
	}
	
	void print10() {
		Node cur = head.link;
		
		for (int i = 0; i < 10; i++) {
			System.out.print(cur.number + " ");
			cur = cur.link;
		}
		
	}
	
}

public class 암호문1_구현_1228 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			SinglyLinkedList list = new SinglyLinkedList();
			for (int i = 0; i < N; i++) {
				list.add(i, sc.nextInt());
			}
			int M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				sc.next();
				int where = sc.nextInt();
				int cnt = sc.nextInt();
				for (int j = 0; j < cnt; j++) {
					int newNum = sc.nextInt();
					list.add(where++, newNum);
				}
			}
			
			System.out.print("#" + tc + " ");
			list.print10();
			System.out.println();
		}
		
	}

}
