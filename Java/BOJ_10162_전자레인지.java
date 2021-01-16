package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {
	//BOJ / 10162번 / 전자레인지/ 구현, 사칙연산, 수학 / 브4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		int onem = 60;
		int one_cnt = 0;
		
		int tens = 10;
		int ten_cnt = 0;
		
		int fivem = 300;
		int five_cnt = 0;
		
		while(input > 0) { // input이 0 이상 이면 반복 
			if(input < 10) { // 10 이하면 break, 최소 단위가 10이기 때문 
				break;
			}
			
			if( input >= fivem) {
				five_cnt++;
				input -= fivem;

			}
			else if( input >= onem) {
				one_cnt++;
				input -= onem;

			}
			else if( input >= tens) {
				ten_cnt++;
				input -= tens;

			}
		}
		if(input != 0 ) {
			System.out.println(-1);
		}
		else {
			System.out.println(five_cnt +" " + one_cnt+ " " + ten_cnt);			
		}
	}

}
