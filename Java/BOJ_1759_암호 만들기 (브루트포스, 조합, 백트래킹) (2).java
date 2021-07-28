package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	// BOJ / 1759번 / 암호 만들기 / 조합, 백트래킹  / 골드5
	static int l, c;
	static String print[], alp[];
	static StringBuilder sb;
	static String vowel[] = {"a","e","i","o","u"};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		l = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		alp = br.readLine().split(" ");
		print = new String[l];
		sb = new StringBuilder();
		
		// 사전순으로 증가.
		Arrays.sort(alp);

		recursion(0,0);
		
		System.out.println(sb);
	}
	
	public static void recursion(int depth, int start) {
		
		// l개를 선택했으면 
		if(depth == l) {
			// 자음 모음 조건 확인
			if(check()) {
				for(String value : print) {
					sb.append(value);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		//visit 배열은 따로 필요가 없다. 어차피 오름차순 정렬이고 
		// 다음 인덱스를 재귀의 start인자로 받아주면 되기 때문.
		for(int i=start; i<alp.length; i++) {
			print[depth] = alp[i];
			recursion(depth+1, i+1);
		}
	}

	public static boolean check() {
		int vow = 0; // 모음
		int cons = 0; // 자음
		
		for(String value : print) {
			boolean isVowel = false;
			// 모음이면 vow++
			for(int i=0; i<vowel.length;i++) {
				if(value.equals(vowel[i])) {
					isVowel = true;
					vow++;
				}
				if(isVowel) {
					break;
				}
			}
			// 자음이면 cons++;
			if(!isVowel) cons++;
			
			// 조건에 맞으면 return;
			if(vow >= 1 && cons >= 2) {
				return true;
			}
		}
		
		return false;
	}
}
