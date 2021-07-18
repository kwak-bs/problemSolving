package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_1544 {
	// BOJ / 1544번 / 사이클 단어 / 해쉬맵 / 실버5
	static Set<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		set = new HashSet<>();
		
		while(n-- > 0) {
			String s = br.readLine();
			
			if(set.size() == 0) {
				set.add(s);
			}
			else {
				check(s);
			}
		}
		
		System.out.println(set.size());
	}
	
	public static void check(String s) {
		int len = s.length();
		String first = s;
		boolean contain = false;
		
		while(len-- > 0) {
			if(set.contains(s)) {
				contain = true;
			}
			
			if(contain) return;
			s = rotate(s);
		}
		
		if(!contain) {
			set.add(first);
		}
	}
	// 시계방향으로 읽으니까 반시계 방향으로 회전시킨다.
	public static String rotate(String s) {
		String result = "";
		
		Queue<String> q = new LinkedList<>();
		
		for(int i=1; i<s.length(); i++) {
			q.add(s.charAt(i)+"");
		}
		q.add(s.charAt(0)+"");
		
		while(!q.isEmpty()) {
			result += q.poll();
		}
		return result;
	}
}
