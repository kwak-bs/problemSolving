package problemSolve;


import java.io.*;
import java.util.*;


public class BOJ_5585 {
	// BOJ / 5585번 / 거스름돈 / 그리디알고리즘/ 브론즈 2 
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int pay = Integer.parseInt(br.readLine()); // 물건 값 
      
      int thous = 1000; // 지불할 돈은 무조건 1000원이다. 
      
      int payBack = thous - pay; // 거스름돈 

      int count = 0; // 동전 갯수
      
      while(payBack>0) { // while문을 통해 순간순간 최적해를 구한다. 
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

