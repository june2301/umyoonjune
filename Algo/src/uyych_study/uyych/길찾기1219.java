package uyych_study.uyych;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 길찾기1219 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			
			int[] arr1 = new int[100];
			int[] arr2 = new int[100];
			
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if (arr1[start] == 0) { // arr1에 값이 없으면
					arr1[start] = end;
				} else { // arr1에 값이 있으면
					arr2[start] = end;
				}
			}
			
			int ans = 0;
			Queue<Integer> path = new LinkedList<Integer>();
			path.add(0);
			while (!path.isEmpty()) { // 꺼낼거 없다 -> 더이상 못간다
				int index = path.poll();
				
				if (arr1[index] == 99 || arr2[index] == 99) {
					ans = 1;
					break;
				}
				if (arr1[index] != 0) {
					path.add(arr1[index]);
				}
				if (arr2[index] != 0) {
					path.add(arr2[index]);
				}
				
			}
			
			System.out.println("#" + T + " " + ans);
		}
		
		
	}

}
