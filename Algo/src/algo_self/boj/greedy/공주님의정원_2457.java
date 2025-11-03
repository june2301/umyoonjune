package algo_self.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 공주님의정원_2457 {
	
	static class Flower implements Comparable<Flower> {
		int start;
		int end;
		
		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Flower f) {
			return this.start - f.start;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		List<Flower> list = new ArrayList<Flower>();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int sm = Integer.parseInt(input[0]);
			int sd = Integer.parseInt(input[1]);
			int em = Integer.parseInt(input[2]);
			int ed = Integer.parseInt(input[3]);
			int start = sd;
			for (int j = 1; j < sm; j++) {
				start += month[j];
			}
			int end = ed;
			for (int j = 1; j < em; j++) {
				end += month[j];
			}
			
			list.add(new Flower(start, end));
		}
		Collections.sort(list);
		
		int target = 60;
		int idx = 0;
		int cnt = 0;
		int max = 0;
		
		while (target <= 334) {
			boolean check = false;
			
			while (idx < N && list.get(idx).start <= target) {
				max = Math.max(max, list.get(idx).end);
				idx++;
				check = true;
			}
			
			if (!check) break; 
			cnt++;
			target = max;
		}
		
		if (max <= 334) {
			System.out.println(0);
		} else {
			System.out.println(cnt);
		}
		
	}

}

/**
 * 그리디
 * [문제]
 * N개의 꽃에 대해 피는 날짜(월,일)와 지는 날짜(월,일)가 주어진다.
 * 이 때 3월 1일부터 11월 30일까지 꽃이 한 가지 이상 피어있도록 하는 꽃의 최소 개수를 구하시오.
 * 
 * 날짜를 일수로 기록하며 class를 통해 피는일과 지는일을 list에 저장
 * 3월 1일은 60부터 시작이며 11월 30일은 334일이므로
 * 60아래에서 피는 꽃을 시작으로 334일을 넘어가면 탐색 종료
 * 
 * list에 꽃들을 피는 시기가 빠른 순으로 저장 후
 * 피는날이 target 이하 중에서 가장 늦게 지는 꽃을 하나 선택
 * (만약 그런 꽃이 선택 안된다면 반복문 종료)
 * 해당 꽃의 지는일로 target 초기화 후 반복
 * 
 * 만약 최종적으로 지는날이 334 이하면 불가능
 */

