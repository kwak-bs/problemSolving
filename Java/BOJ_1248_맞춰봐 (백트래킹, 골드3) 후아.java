package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1248 {
   // BOJ / 1248번 / 맞춰봐 / 브루트포스 / 골3
   static int n;
   static int print[];
   static int sign[][];
   static boolean end;
   static StringBuffer sb;
   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      String s = br.readLine();

      print = new int [n];
      sign = new int [n][n];
      end = false;
      sb = new StringBuffer();
      int cnt = 0;
      for(int i=0; i<n; i++) {
         for(int j=i; j<n; j++) {
            char x = s.charAt(cnt);
            if (x == '0') {
               sign[i][j] = 0;
            } 
            else if (x == '+') {
                sign[i][j] = 1;
            } 
            else {
                sign[i][j] = -1;
            }
            cnt +=1;
         }
      }
      recursion(0);
      
      System.out.println(sb);
   }
   
   public static void recursion(int depth) {

      if(depth == n) {
         end = true;
         for(int value : print) {
            sb.append(value).append(" ");
         }
         
         return;
      }
      //sign[i][i]가 0이면 그냥 0넣어주면 된다.
      if(sign[depth][depth] == 0) {
         print[depth] = 0;
         
         recursion(depth + 1);

         // depth가 4면 종료.
         if(end) {
        	 return;
         }
      }
      // 0을 제외한 1~10까지 부호에 맞게 곱해준뒤 print에 넣어준다.
      // 그리고 check진행.
      for(int i=1; i<=10; i++) {
         print[depth] = sign[depth][depth] * i;
         
         if(check(depth)) {
            recursion(depth + 1);
         }
         // depth가 4면 종료.
         if(end) {
            return;
         }
      }
   }
   
   // sign[index][i]의 부호를 기준으로 sign[0][i]까지 부호를 탐색하고
   // 마찬가지로 print[index]를 기준으로 print[0]까지 탐색.
   // 그후 부호에 맞게 비교.
   public static boolean check(int index) {

      int sum = 0;
      for(int i=index; i>=0; i--) {
         sum +=print[i];
         
         if(sign[i][index] == 0) {
            if(sum != 0) return false; 
         } 
         else if(sign[i][index] < 0) {
            if(sum >= 0) return false;
         }
         else if(sign[i][index] > 0) {
            if(sum <= 0) return false;
         }
      }
      
      return true;
   }
}