package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1541 {
	// BOJ / 1541번 / 잃어버린 괄호 / 수학, 그리디 알고리즘, 문자열, 파싱/ 실버 2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//식을 입력받는다.
		String exp = br.readLine();
		String [] arr = exp.split("\\-");
		int answer = cal(arr[0]); // 첫 -을 만나기 전까지 숫자든 +을 포함하고 있는 식이든 cal 메서드로 보낸다.

		for(int i=1; i<arr.length; i++) {
			answer -= cal(arr[i]); // arr[0]을 제외한 배열의 값은 - 연산자이기 때문에 빼준다.
		}
		System.out.println(answer);
	}
	
	public static int cal(String exp) { // + 계산
		String [] temp = exp.split("\\+");
		int result = 0;
		
		for(int i=0; i<temp.length; i++) {
			result += Integer.parseInt(temp[i]);
		}
		
		return result;
	}
}
