package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 애너그램_1919 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input1 = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();
		
		int[] abc1 = new int[26];
		int[] abc2 = new int[26];
		
		for (int i = 0; i < input1.length; i++) {
			abc1[input1[i]-'a']++;
		}
		for (int i = 0; i < input2.length; i++) {
			abc2[input2[i]-'a']++;
		}
		
		int cnt = 0;
		for (int i = 0; i < abc1.length; i++) {
			if (abc1[i]>0 && abc2[i]>0) {
				if (abc1[i] >= abc2[i]) {
					cnt += abc2[i];
				} else if (abc2[i] > abc1[i]) {
					cnt += abc1[i];
				}
			}
		}
		
		System.out.println((input1.length - cnt) + (input2.length - cnt));
		
	}

}
