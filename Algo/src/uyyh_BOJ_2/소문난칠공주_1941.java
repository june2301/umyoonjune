package uyyh_BOJ_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 소문난칠공주_1941 {

	static char[][] map;
    static int ans;
    static boolean[] visited;
    static int[] check = new int[7];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        comb(0, 0, 0);
        
        System.out.println(ans);
    }

    static void comb(int cnt, int start, int Scnt) {
        if (cnt - Scnt > 3) return;

        if (cnt == 7) {
            bfs(check[0] / 5, check[0] % 5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            check[cnt] = i;
            comb(cnt+1, i+1, (map[r][c] == 'S')? Scnt+1: Scnt);
        }

    }


    static void bfs(int sr, int sc) {
        visited = new boolean[7];
        visited[0] = true;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sr, sc});
        
        int num = 1;
        while (!q.isEmpty()) {
            int[] save = q.poll();
            int r = save[0];
            int c = save[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                int next = 5*nr + nc;
                for (int k = 0; k < 7; k++) {
                    if (!visited[k] && check[k] == next) {
                        visited[k] = true;
                        num++;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        if (num == 7) ans++;
    }

}
