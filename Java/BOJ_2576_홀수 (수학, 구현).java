package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2576 {
	//BOJ / 2576�� / Ȧ�� / ����, ���� / ��3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int odd_sum = 0;
		int odd_min = 99999;
		for(int i=0; i<7; i++) {
			int n = Integer.parseInt(br.readLine()); //�Է�
			
			if( n % 2 != 0) { // Ȧ���� ��� 
				odd_sum += n;
				if( odd_min > n) {
					odd_min = n;
				}
			}
		}
		if( odd_sum == 0) { // Ȧ���� �ѹ��� �ȳ������� 
			System.out.println(-1);
		}
		else {
			System.out.println(odd_sum);
			System.out.println(odd_min);
		}

	}
}
