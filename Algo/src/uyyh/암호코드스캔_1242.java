package uyyh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 암호코드스캔_1242 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] c = input.toCharArray();
		String code = "";
		for (int i = 0; i < c.length; i++) {
			String save = String.valueOf(c[i]);
			code += String.format("%04d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(save, 16))));
		}
		System.out.println(code);
		System.out.println(code.length());
//		String front = code.substring(0, 2);
//		String back = code.substring(code.length()-2, code.length());
//		if (back.equals("00") && front.equals("00")) {
//			code = code.substring(0, code.length()-2);
//			code = code.substring(2, code.length());
//		}
		if (code.length() % 56 != 0) {
			int save = 0;
			for (int i = code.length()-1; i > 0; i--) {
				if (code.charAt(i) == '1') {
					save = i+1;
					break;
				}
			}
			code = code.substring(0, save);
			System.out.println(save);
		}
		System.out.println(code);
		
		// 자를 필요 없음. 뒤에서 1 나오는 시점부터 시작.
		// 56 배수이면 자를 필요 없음.
		// 뒤에 0 자르고 그대로 계산
		int N = code.length() / 8;
		List<Integer> nums = new ArrayList<>();
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < 8; i++) {
			String save = code.substring(code.length()-N, code.length());
			code = code.substring(0, code.length()-N);
			char[] cave = save.toCharArray();
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (cave[j] != cave[j-1]) {
					nums.add(cnt);
					cnt = 0;
				}
				cnt++;
			}
			if (cnt > 0) {
				nums.add(cnt);
			}
			
			int evencnt = 0;
			for (int j = 0; j < 4; j++) {
				if (nums.get(j) % 2 == 0) {
					evencnt++;
				}
			}
			
			if (evencnt == 4) {
				for (int j = 0; j < 4; j++) {
					nums.set(j, nums.get(j)/2);
				}
			}
			
			int ans1 = 0;
			if (nums.get(0) == 1) {
				if (nums.get(1) == 1) {
					if (nums.get(2) == 1) {
						ans1 = 6; // 1114
					}else {
						ans1 = 4; // 1132
					}
				}else if (nums.get(1) == 2) {
					if (nums.get(2) == 1) {
						ans1 = 8; // 1213
					}else {
						ans1 = 5; // 1231
					}
				}else if (nums.get(1) == 3) {
					ans1 = 7; // 1312
				}else {
					ans1 = 3; // 1411
				}
			}else if (nums.get(0) == 2) {
				if (nums.get(1) == 2) {
					ans1 = 1; // 2221
				}else {
					ans1 = 2; // 2122
				}
			}else if (nums.get(0) == 3) {
				if (nums.get(1) == 2) {
					ans1 = 0; // 3211
				}else {
					ans1 = 9; // 3112
				}
			}
			
			if (i % 2 == 0) {
				sum += ans1 * 3;
			}else {
				sum += ans1;
			}
			System.out.println(ans1);
			ans += ans1;
			
			nums.clear();
		}
		System.out.println(ans);
		if (sum % 10 == 0) {
		}
		
	}

}
