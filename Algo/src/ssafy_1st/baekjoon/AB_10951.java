package ssafy_1st.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AB_10951 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		
		while ((str = br.readLine()) != null) {
			
			StringTokenizer st = new StringTokenizer(str);
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(num1 + num2);
			
			bw.write(sb.toString() + "\n");
			
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
