package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10823 {
	//BOJ / 10823번 / 더하기 2 / 문자열 / 브2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		int sum = 0;
		
		// bufferedReader while문에서 null값 까지 입력받는 방법 ( EOF 처리 공부 및 정리하기 )
		while((line = br.readLine()) != null) { // ctrl + z 가 입력될 때 까지 입력 받음( ctrl + z = null임)
			sb.append(line.toString());
		}

		for(String num : sb.toString().split(",")) {
			sum += Integer.parseInt(num);
		}
		System.out.println(sum);
	}
}
