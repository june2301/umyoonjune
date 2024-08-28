package algo_2nd_0828;

import java.util.Scanner;

public class 거듭제곱_1217 {

	static int ans = 1;
	static int N, R;
	
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            int tc = sc.nextInt();
            int N = sc.nextInt();
            int R = sc.nextInt();
            int answer = pow(N,R);
            System.out.println("#" + tc + " " + answer);
        }
    }
     
    static int pow(int N, int R) {
        if (R < 1) {
            return 1;
        }else {
            return N * pow(N, R-1);
        }
    }

}
