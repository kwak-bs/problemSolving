package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14720 {
	// BOJ ���� ����  / 14720  / ����,�׸��� �˰���, dp / ��3 
	public static void main(String[] args) throws IOException {
		// ������� 0 -> ���ڿ��� 1 -> �ٳ��� ���� 2 -> ���� ���� 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		
		while(N-- > 0) {
			if(Integer.parseInt(st.nextToken()) == count%3){
				count++;
			}
		}
		System.out.println(count);
	}
}
