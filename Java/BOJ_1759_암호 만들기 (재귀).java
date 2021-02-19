package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	// BOJ / 1759번 / 암호 만들기 / 브루트포스 / 골5
	
	static String print[], list[];
	static int l,c;
	static StringBuffer sb;
	static String vowe[] = {"a","e","i","o","u"}; // 모음
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		l = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		print = new String[l];
		list = new String[c];
		sb = new StringBuffer();
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<c; i++) {
			list[i] = stk.nextToken();
		}
		// 사전순으로 증가.
		Arrays.sort(list);
		
		recursion(0,0);
		
		System.out.println(sb);
	}
	
	public static void recursion(int depth, int start) {
		
		if(depth == l) {
			int consonants = 0; // 자음
			int vowels = 0; // 모음
			boolean ok = false; // 자음 모음 조건을 만족하는 변수.
			
			for(String value : print) {
				boolean isvowel = false; // 자음인지 모음인지 판별하는 변수.
				
				for(int i=0; i<vowe.length; i++) {
					if(value.equals(vowe[i])) {
						vowels++;
						isvowel = true;
						break;
					}						
				}
				if(!isvowel) {
					consonants++;					
				}
				
				if(vowels>=1 && consonants >= 2) {
					ok = true;
					break;
				}
			}

			if(ok) {
				for(String value : print) {
					sb.append(value);										
				}
				sb.append("\n");
			}
			return;
		}
		
		//visit은 따로 필요가 없다. 어차피 오름차순 정렬이고 
		// 다음 인덱스를 재귀의 인자로 받아주면 되기 때문.
		for(int i=start; i<list.length; i++) {
			print[depth] = list[i];
			recursion(depth + 1, i+1);
			
		}
	}
}
