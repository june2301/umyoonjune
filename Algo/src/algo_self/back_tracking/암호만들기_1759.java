package algo_self.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 암호만들기_1759 {
	
	static int L, C;
	static char[] c;
	static char[] code;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] LC = br.readLine().split(" ");
		
		L = Integer.parseInt(LC[0]);
		C = Integer.parseInt(LC[1]);
		
		c = new char[C];
		code = new char[L];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			c[i] = input[i].charAt(0);
		}
		
		Arrays.sort(c);
		
		combination(0, 0);
		
	}
	
	static void combination(int idx, int sidx) {
		if (sidx == L) {
			if (isValid(code)) {
				System.out.println(String.valueOf(code));
			}
			return;
		}
		
		if (idx >= C) {
			return;
		}
		
		code[sidx] = c[idx];
		combination(idx+1, sidx+1);
		combination(idx+1, sidx);
		
	}
	
	static boolean isValid(char[] c) {
		int con = 0;
		int vow = 0;
		boolean check = false;
		for (int i = 0; i < L; i++) {
			if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
				vow++;
			} else {
				con++;
			}
			if (vow >= 1 && con >= 2) {
				check = true;
				break;
			}
		}
		
		return check;
	}

}

/**
 * 백트래킹 - 조합(Combination)
 * 
 * C개의 문자열 중 L개를 조합하며, lCc
 * 추가로 모음 1개 이상, 자음 2개 이상을 포함하는 조건이 붙는다.
 * 
 * combination(int idx, int sidx)에서 
 * idx는 입력받은 배열 중 답에 담을 인덱스
 * sidx는 답에 넣을 자리 인덱스를 의미
 * 
 * combination(idx + 1, sidx + 1); -> 다음 입력 인덱스, 다음 출력 인덱스로 이동
 * combination(idx + 1, sidx);     -> 비선택 (입력은 다음, 출력은 그대로)
 * 
 * 답 출력 전 자음/모음 조건 확인
 */
