package algo_day3;

import java.util.Scanner;

public class swea1954_강사님 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
             
            int cnt = 0; // 1 ~ N*N까지 반복
            
            int r = 0;
            int c = 0;
            
            int d = 0; // 우(0),하(1),좌(2),상(3)
             
            while(cnt++ < N*N) {
                arr[r][c] = cnt;
                
                // 0 일때 오른쪽으로 진행 c++
                // 못가는 경우 d 바꿔주고 r++(아래)
                if(d == 0) { 
                    if( c == N-1 || (c < N-1 && arr[r][c+1] != 0 )) { 
                        d = (d + 1)%4; 
                        r++;  
                    } else { 
                        c++;
                    }
                }
                // 1일때 아래로 진행 r++
                // 못가는 경우 d 바꿔주고 c--(왼쪽)
                else if(d == 1) { 
                    if( r == N-1 || (r < N-1 && arr[r+1][c] != 0 )) {
                        d = (d + 1)%4; 
                        c--; 
                    } else {
                        r++; 
                    }
                }
                // 2일때 왼쪽으로 진행 c--
                // 못가는 경우 d 바꿔주고 r--(위)
                else if(d == 2) { 
                    if( c == 0 || (c > 0 && arr[r][c-1] != 0 )) { 
                        d = (d + 1)%4; 
                        r--;
                    } else {
                        c--; 
                    }
                }
                // 3일때 위로 진행 r--
                // 못가는 경우 d 바꿔주고 c++(오른쪽)
                else if(d == 3) { 
                    if( r == 0 || (r > 0 && arr[r-1][c] != 0 )) { 
                        d = (d + 1)%4; 
                        c++;            
                    } else {
                        r--;
                    }
                }
            }
             
            System.out.println("#"+tc);
            for(r=0; r<N; r++) {
                for(c=0; c<N; c++) {
                    System.out.print(arr[r][c]+" ");
                }
                System.out.println();
            }
             
        }
		
		
	}

}
