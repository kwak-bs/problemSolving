package problemSolve;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1712�� ���ͺб��� JAVA
public class BOJ_1712_JAVA {
	
    public static void main(String args[]) throws IOException {
      //�Է�	
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      	
      	// c-b�� �������� 0�̻��̸� ���, ������ �Է� ������ �ſ� ũ�� ������ while���� ����ϸ� �ȵ�.
        if(c - b > 0) {
            System.out.println(a / (c-b) + 1);
        }
        else {
            System.out.println(-1);
        }
    }
}