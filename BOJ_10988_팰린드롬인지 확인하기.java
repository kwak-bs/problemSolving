package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {
	//BOJ / 10988번 / 팰린드롬인지 확인하기 / 구현, 문자열 / 브1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int result = 0;
		if(line.length() == 1) { // 입력 길이가 1 이면 무조건 팰린드롬
			result = 1;
		}
		for(int i=0; i<line.length()/2; i++) { // 절반까지만 돌아도됨
			if(line.charAt(i) == line.charAt(line.length() - i -1)) {
				result = 1;
			}
			else {
				result = 0; // 팰린드롬이 아니라고 한번 판정나면 바로 break;
				break;
			}
		}
		
		System.out.println(result);
	}
}
