package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ배수스위치_12927 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		char[] check = new char[input.length];
		
		int cnt = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'Y') {
				cnt++;
				for (int j = i; j < input.length; j++) {
					
				}
			}
		}
		
		
		
		
	}

}
