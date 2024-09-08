package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 정사각형판정_13732 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][N];
			int scnt = 0;
			for (int r = 0; r < N; r++) {
				String input = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = input.charAt(c);
					if (map[r][c] == '#') {
						scnt++;
					}
				}
			}
			
			int cnt = 0;
			List<Integer> saveC = new ArrayList<Integer>();
			int saveR = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == '#') {
						cnt++;
						saveC.add(c);
						saveR = r;
					}
				}
				if (cnt > 0) {
					break;
				}
			}
			int size = saveC.get(saveC.size()-1) - saveC.get(0) + 1;
			
			boolean ans = true;
			for (int r = saveR; r < saveR + size; r++) {
				for (int c = saveC.get(0); c < saveC.get(0) + size; c++) {
					if (map[r][c] != '#') {
						ans = false;
						break;
					}
				}
			}
			
			if (scnt != Math.pow(cnt, 2)) {
				ans = false;
			}
			
			System.out.print("#" + tc + " ");
			if (ans) {
				System.out.print("yes");
			}else {
				System.out.print("no");
			}
			System.out.println();
			
		}
		
	}

}
