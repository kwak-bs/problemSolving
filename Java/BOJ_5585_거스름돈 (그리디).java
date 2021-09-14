package problemSolve;


import java.io.*;
import java.util.*;


public class BOJ_5585 {
	// BOJ / 5585�� / �Ž����� / �׸���˰���/ ����� 2 
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int pay = Integer.parseInt(br.readLine()); // ���� �� 
      
      int thous = 1000; // ������ ���� ������ 1000���̴�. 
      
      int payBack = thous - pay; // �Ž����� 

      int count = 0; // ���� ����
      
      while(payBack>0) { // while���� ���� �������� �����ظ� ���Ѵ�. 
    	  if(payBack >= 500) {
    		  count++;
    		  payBack -= 500;
    	  }
    	  else if(payBack >= 100) {
    		  count++;
    		  payBack -= 100;
    	  }
    	  else if(payBack >= 50) {
    		  count++;
    		  payBack -= 50;
    	  }
    	  else if(payBack >= 10) {
    		  count++;
    		  payBack -= 10;
    	  }
    	  else if(payBack >= 5) {
    		  count++;
    		  payBack -= 5;
    	  }
    	  else if(payBack >= 1) {
    		  count++;
    		  payBack -= 1;
    	  }
      }
      System.out.println(count);
   }
}

