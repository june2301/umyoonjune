package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ배수스위치_12927 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		char[] swi = new char[input.length()+1];
		for (int i = 1; i < swi.length; i++) {
			swi[i] = input.charAt(i-1);
		}
		int cnt = 0;
		for (int i = 1; i < swi.length; i++) {
			if (swi[i] == 'Y') {
				cnt++;
				for (int j = i; j < swi.length; j += i) {
					swi[j] = swi[j] == 'N' ? 'Y' : 'N';
				}
			}
		}
		for (int i = 0; i < swi.length; i++) {
			if (swi[i] == 'Y') {
				cnt = -1;
			}
		}
		System.out.println(cnt);
	}

}
