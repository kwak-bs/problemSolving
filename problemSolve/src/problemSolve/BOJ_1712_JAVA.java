package problemSolve;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1712번 손익분기점 JAVA
public class BOJ_1712_JAVA {
	
    public static void main(String args[]) throws IOException {
      //입력	
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      	
      	// c-b를 기준으로 0이상이면 출력, 문제의 입력 범위가 매우 크기 때문에 while문은 사용하면 안됨.
        if(c - b > 0) {
            System.out.println(a / (c-b) + 1);
        }
        else {
            System.out.println(-1);
        }
    }
}