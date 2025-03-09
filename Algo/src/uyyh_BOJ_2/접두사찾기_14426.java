package uyyh_BOJ_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 접두사찾기_14426 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), i);
		}

		int ans = 0;
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			for (String key : map.keySet()) {
				boolean check = key.startsWith(input);
				if (check) {
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);

	}

}
