package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16198 {
	// BOJ / 16198번 / 에너지 모으기 / 재귀 / 실버1
	
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer>al = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			al.add(Integer.parseInt(stk.nextToken()));
		}
		max = Integer.MIN_VALUE;
		
		go(0, al);
		
		System.out.println(max);
	}
	
	public static void go( int sum, ArrayList<Integer> al) {
		
		if(al.size() == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=1; i<al.size()-1; i++) {
			int acc = al.get(i-1) * al.get(i+1);
			int temp = al.remove(i);
			go(sum + acc,al);			
			al.add(i, temp);
		}
	}
}
