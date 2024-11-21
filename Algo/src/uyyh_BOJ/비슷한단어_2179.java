package uyyh_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 비슷한단어_2179 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = br.readLine();
			arr[i][1] = String.valueOf(i);
		}
		Arrays.sort(arr, (a,b) -> a[0].compareTo(b[0]));
		int max = 0;
		int save1 = 0, save2 = 0;
		for (int i = 0; i < N-1; i++) {
			String one = arr[i][0];
			String two = arr[i+1][0];
			int len = arr[i][0].length();
			int cnt = 0;
			for (int j = 0; j < len; j++) {
				if (one.charAt(j) == two.charAt(j)) {
					cnt++;
				} else {
					break;
				}
			}
			if (cnt > max) {
				max = cnt;
				save1 = i;
				save2 = i+1;
			}
		}
		int ans1 = Integer.parseInt(arr[save1][1]);
        int ans2 = Integer.parseInt(arr[save2][1]);
        
        if (ans1 < ans2) {
            System.out.println(arr[save1][0]);
            System.out.println(arr[save2][0]);
        } else {
            System.out.println(arr[save2][0]);
            System.out.println(arr[save1][0]);
        }
		
	}

}
