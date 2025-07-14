package algo_self.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같이눈사람만들래_20366 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				list.add(new int[] {arr[i] + arr[j], i, j});
			}
		}
		
		list.sort((a, b) -> a[0] - b[0]);
		
		int size = list.size();
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < size-1; i++) {
			int[] a = list.get(i);
			for (int j = i+1; j < size; j++) {
				int[] b = list.get(j);

				int temp = Math.abs(a[0] - b[0]);
				if (temp > ans) break;
				if (a[1] == b[1] || a[1] == b[2] || a[2] == b[1] || a[2] == b[2]) continue;
				
				ans = temp;
				if (ans == 0) {
					System.out.println(ans);
					return;
				}
				
			}
		}
		
		System.out.println(ans);
		
	}

}

/**
 * 투포인터 - 유사 완전탐색
 * 
 * 모든 눈사람의 키를 비교하기 위해
 * 가능한 모든 눈사람의 키를 list로 저장하면서 인덱스도 함께 저장
 * 
 * 저장한 list를 눈사람 키 순으로 정렬해두고 이중 반복문으로 비교
 * - 저장해가는 정답보다 눈사람의 키가 큰 경우 -> 그 뒤로도 어차피 크기 때문에 break;
 * - 같은 인덱스의 눈덩이를 사용한 경우 continue;
 * 
 * 모든 눈덩이 조합 탐색하여 저장 시간복잡도 : O(N^2)
 * 리스트 정렬 시간복잡도 : O(N^2logN^2)
 * 
 * 최종 시간복잡도 : O(N^2logN^2)
 */

