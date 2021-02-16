package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2309 {
	// BOJ / 2309번 / 일곱 난쟁이  / 브르투 포스 / 브2
	static int nan[];
	static boolean visit[];
	static int sum;
	static ArrayList<Integer> al;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		nan = new int[9];
		visit = new boolean[9];
		for(int i=0; i<9; i++) {
			nan[i] = Integer.parseInt(br.readLine());
		}
		
		al = new ArrayList<>();	
		dfs(0);
	}
	
	public static void dfs(int index) {
		
		if(al.size() == 7) {
			int sum = 0;
			for(int i=0; i<al.size(); i++) {
				sum += al.get(i);
			}
			
			if(sum == 100) {
				Collections.sort(al);
				for(int i=0; i<al.size(); i++) {
					System.out.println(al.get(i));
				}
			}
			
			return;
		}
		
		for(int i=index; i<9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				al.add(nan[i]);
				dfs(i);
				visit[i] = false;
				al.remove(al.size()-1);
			}
		}
	}
}
