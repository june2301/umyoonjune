package uyyh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 서로소집합2_3289 {

    static List<Set<Integer>> nums;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();
            int M = sc.nextInt();

            nums = new ArrayList<>(N + 1);
            for (int i = 0; i <= N; i++) {
                nums.add(new HashSet<>());
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < M; i++) {
                int check = sc.nextInt();
                if (check == 0) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    merge(a, b);
//                    System.out.println("확인 : " + nums.get(a));
//                    System.out.println("확인 : " + nums.get(b));
                }
                if (check == 1) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int ans = connect(a, b);
                    System.out.print(ans);
                }
            }
            System.out.println();
        }
    }

    static void merge(int a, int b) {
        nums.get(a).add(b);
        nums.get(b).add(a);
        nums.get(a).add(a);
        nums.get(b).add(b);
        
        for (int i = 0; i < N; i++) {
        	if (nums.get(a).contains(i)) {
        		nums.get(i).addAll(nums.get(b));
			}
		}
        for (int i = 0; i < N; i++) {
        	if (nums.get(b).contains(i)) {
        		nums.get(i).addAll(nums.get(a));
        	}
        }
        
    }

    static int connect(int a, int b) {
        if (nums.get(a).contains(b)) {
            return 1;
        } else {
            return 0;
        }
    }
}
