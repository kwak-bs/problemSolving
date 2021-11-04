package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {
	// BOJ / 1105번 / 팔 / 구현 / 실버1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		String l = stk.nextToken();
		String r = stk.nextToken();
		int answer = 0;
		// 자릿수가 다르면 무조건 0을 출력한다. l과 r사이의 폭이 크므로 8이 존재하지 않는 수가 존재할 수 있다. 
		// 자릿수가 같으면 l과 r의 각 자릿수를 비교하여 '8'을 공통으로 갖고있는 자릿수의 갯수를 세준다. 
		// 만약 자릿수의 숫자가 다르면 그 자릿수 이하로는 많은 수가 존재하므로 비교할 필요가 없다. (break)
		if(l.length() == r.length() && Integer.parseInt(l) <= Integer.parseInt(r)) {
			for(int i=0; i<l.length(); i++) {
				if(l.charAt(i) == '8' && l.charAt(i) == r.charAt(i)) {
					answer++;
				}
				else if(l.charAt(i) != r.charAt(i)) {
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
