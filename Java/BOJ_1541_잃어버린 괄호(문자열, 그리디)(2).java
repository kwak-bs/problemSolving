package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
	// BOJ / 1541번 / 잃어버린 괄호 / 구현, 그리디 / 실버2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		// '-'를 기준으로 분할 
		String sub[] = s.split("\\-");
		// sub[0]은 양수 혹은 '+'기호가 속한 수식이다. 
		int answer = cal(sub[0]);
		
		// sub[0]에서 나머지 배열 값(양수 혹은 '+'기호가 속한 수식)들을 빼준다.
		for(int i=1; i<sub.length; i++) {
			answer -= cal(sub[i]);
		}
		System.out.println(answer);
	}
	// 양수 혹은 '+'기호가 속한 수식 계산
	public static int cal(String exp) {
		int result = 0;
		String plus[] = exp.split("\\+");
		for(int i=0; i<plus.length; i++) {
			result += Integer.parseInt(plus[i]);
		}
		
		return result;
	}
}
