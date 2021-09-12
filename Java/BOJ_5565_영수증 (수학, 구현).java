package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5565 {
	//BOJ / 5565번 / 영수증  / 수학, 구현 / 브3
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<9; i++) {
			int price = Integer.parseInt(br.readLine());
			
			total -= price;
		}
		System.out.println(total);
	}

}
