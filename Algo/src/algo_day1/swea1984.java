package algo_day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea1984 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	
        	List<Integer> list1 = new ArrayList<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0; i < 10; i++) {
        		list1.add(Integer.parseInt(st.nextToken()));
        	}
        	Collections.sort(list1);
        	list1.remove(0);
        	list1.remove(list1.size()-1);
        	
        	double sum = 0;
        	for (int i = 0; i < list1.size(); i++) {
        		sum += list1.get(i);
        	}
        	int ans = (int) Math.round(sum / (double)list1.size());
        	System.out.println("#" + tc + " " + ans);
			
		}
		
	}

}
