package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
	//2839�� ������� JAVA
	public static void main(String[] args) throws IOException{
		//�Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int five_quot = N / 5; // ���� �����Ѵ�. 
		
		switch(N % 5) { // �������� ���� ��Ģ�� ã�� ������ �����Ѵ�. 
		 case 0 :
			 System.out.println(five_quot);
			 break;
		 case 1 : 
		 case 3 :
			 System.out.println(five_quot + 1);
			 break;
		 case 2 :
			 if(five_quot < 2) {
				 System.out.println(-1);
			 } 
			 else 
				 System.out.println(five_quot + 2);
			 break;
		 case 4 :
			 if(five_quot < 1) {
				 System.out.println(-1);
			 }
			 else 
				 System.out.println(five_quot + 2);
			 break;
		}
	}

}
