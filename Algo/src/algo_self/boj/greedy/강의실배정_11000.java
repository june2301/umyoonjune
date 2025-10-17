package algo_self.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 강의실배정_11000 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
		
        int[][] classes = new int[N][2];
        for (int i = 0; i < N; i++) {
			String[] AB = br.readLine().split(" ");
			classes[i][0] = Integer.parseInt(AB[0]);
			classes[i][1] = Integer.parseInt(AB[1]);
		}
		
        Arrays.sort(classes, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(classes[0][1]);
        
        for (int i = 1; i < N; i++) {
			int st = classes[i][0];
			int en = classes[i][1];
        	
			if (pq.peek() <= st) {
				pq.poll();
			}
			pq.add(en);
		}
		
        System.out.println(pq.size());
	}

}

/**
 * [문제]
 * N개의 수업에 대한 시작시간/끝시간이 주어지고, 수업은 끝난직후 바로 시작이 가능하다(3에 끝나고 3에 시작 가능)
 * 이 때 모든 수업을 배정하기 위해 필요한 최소 강의실의 개수를 구하시오.
 * 
 * 우선 강의 시간에 대해 시작시간이 빠른 순서로 정렬
 * 
 * 이후 PQ를 이용해 종료시간 저장하면서 가장 종료가 빠른 시간을 앞에 둠.
 * PQ에 저장된 가장 짧은 종료시간이 다음 수업 시작시간보다 작거나 같으면 해당 시간 제거
 * + 수업 종료시간 저장
 */

