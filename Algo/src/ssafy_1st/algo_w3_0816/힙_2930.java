package ssafy_1st.algo_w3_0816;

import java.util.Scanner;

public class 힙_2930 {

	static long[] heap;
	static int hSize;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			heap = new long[N];
			hSize = 0;
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				int cmd = sc.nextInt();
				if (cmd == 1) {
					one(sc.nextInt());
				}else {
					
					System.out.print(two() + " ");
				}
			}
			System.out.println();
		}
	}
	
	static void swap(int i, int j) {
		long tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	static void one(int data) {
		
		heap[++hSize] = data;
		
		int p = hSize / 2;
		int ch = hSize;
		
		while (ch != 1 && heap[ch] > heap[p]) {
			
			swap(p, ch);
			
			ch = p;
			p = ch / 2;
		}
		
	}
	
	static long two() {
		
		
		if (hSize == 0) {
			return -1;
		}
		
		long popItem = heap[1];
		
		heap[1] = heap[hSize--];
		
		int p = 1;
		int ch = p * 2;
		
		// 왼쪽 자식이 오른쪽 자식보다 큰 경우
		if (ch + 1 <= hSize && heap[ch] < heap[ch + 1]) {
			ch++;
		}
		
		// 자식 노드가 부모 노드보다 크면 교환
		while (ch <= hSize && heap[ch] > heap[p]) {
			swap(p, ch);
			
			p = ch;
			ch = p * 2;
			
			if (ch + 1 <= hSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
		}
		
		return popItem;
	}

}
