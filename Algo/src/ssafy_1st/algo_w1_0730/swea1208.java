package ssafy_1st.algo_w1_0730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {

			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100];
			for (int i = 0; i < box.length; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			// 정렬 1번 실행
			for (int i = 0; i < box.length; i++) {
				int min = i;
				for (int j = i + 1; j < box.length; j++) {
					if (box[min] > box[j]) {
						min = j;
					}
				}
				int tmp = box[i];
				box[i] = box[min];
				box[min] = tmp;
			}
			int cnt = 0;
			while (cnt < dump) {
				// 제일 큰거가 제일 작은거보다 크면
				// 제일큰거 - 1
				// 제일작은거 + 1
				if (box[box.length - 1] - box[0] > 0) {
					box[0]++;
					box[box.length - 1]--;
					cnt++;

					// 정렬
					for (int i = 0; i < box.length; i++) {
						int min = i;
						for (int j = i + 1; j < box.length; j++) {
							if (box[min] > box[j]) {
								min = j;
							}
						}
						int temp = box[i];
						box[i] = box[min];
						box[min] = temp;
					}
				}
			}
			System.out.println("#" + tc + " " + (box[box.length - 1] - box[0]));
		}
	}
}
