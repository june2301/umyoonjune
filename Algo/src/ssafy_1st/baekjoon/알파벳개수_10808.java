package ssafy_1st.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳개수_10808 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int[] abc = new int[26];
		
		for (int i = 0; i < input.length; i++) {
			abc[input[i]-'a']++;
		}
		
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]+" ");
		}
		
	}

}
