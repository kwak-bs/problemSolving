package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2875 {
	// BOJ / 2875�� / ��ȸ or ���� / ����, ����, �׸��� / ��3
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // �Է�  
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max = N/2 > M ? M : N/2; // �ϴ� K�� ������� ���� �ִ� ���� ���� ���Ѵ�. n/2�� m�� ���� ���� ���� �ִ� ���� ���� �ȴ�.
		
		K -= N + M - max*3; //  ���� �����ϰ� ���� ������� �������� ���� ���̹Ƿ� k���� ���ش�. (n - max*2) + (m - max) = n + m - max*3
		
		while(K > 0) { //  ���� ������ �ʿ��� ���� ���� �ִٸ� (k > 0) ���� �ϳ� ��ü�ϰ� 3���� ���Ͻ����� ����������. �� ������ ���Ͻ� ���� �ο��� ������ ������ �Ѵ�.
			K -= 3;
			max--;
		}
		System.out.println(max);
	}

}
