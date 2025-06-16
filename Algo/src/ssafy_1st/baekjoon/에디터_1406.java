package ssafy_1st.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class 에디터_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
	        LinkedList<Character> txt = new LinkedList<>();

	        for (char c : input.toCharArray()) {
	            txt.add(c);
	        }

	        int loc = txt.size();

	        int N = Integer.parseInt(br.readLine());
	        for (int i = 0; i < N; i++) {
	            String[] cmd = br.readLine().split(" ");
	            if (cmd[0].equals("L")) {
	                if (loc > 0) {
	                    loc--;
	                }
	            } else if (cmd[0].equals("D")) {
	                if (loc < txt.size()) {
	                    loc++;
	                }
	            } else if (cmd[0].equals("B")) {
	                if (loc > 0) {
	                    txt.remove(loc - 1);
	                    loc--;
	                }
	            } else if (cmd[0].equals("P")) {
	                txt.add(loc, cmd[1].charAt(0));
	                loc++;
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        for (char c : txt) {
	            sb.append(c);
	        }

	        bw.write(sb.toString());
	        bw.flush(); 
	        bw.close();
	    }

}
