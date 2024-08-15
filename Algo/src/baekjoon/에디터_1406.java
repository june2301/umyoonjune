package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 에디터_1406 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		char[] text = input.toCharArray();
		List<Character> txt = new ArrayList<Character>();
		
		for (int i = 0; i < text.length; i++) {
			txt.add(text[i]);
		}
		
		int loc = txt.size();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");
			if (cmd[0].equals("L")) {
				loc--;
				if (loc < 1) {
					loc = 0;
				}
			} else if (cmd[0].equals("D")) {
				loc++;
				if (loc > txt.size() - 1) {
					loc = txt.size();
				}
			} else if (cmd[0].equals("B")) {
				if (loc == 0) {
					
				} else {
					txt.remove(loc-1);
					loc--;
				}
			} else if (cmd[0].equals("P")) {
				txt.add(loc, cmd[1].charAt(0));
				loc++;
			}
		}
		String ans = "";
		for (int i = 0; i < txt.size(); i++) {
			ans += txt.get(i);
		}
		
		System.out.println(ans);
		
	}

}
