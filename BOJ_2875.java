package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2875 {
	// BOJ / 2875번 / 대회 or 인턴 / 수학, 구현, 그리디 / 브3
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 입력  
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max = N/2 > M ? M : N/2; // 일단 K를 고려하지 않은 최대 팀의 수를 구한다. n/2와 m중 가장 작은 수가 최대 팀의 수가 된다.
		
		K -= N + M - max*3; //  팀을 구성하고 남은 사람들을 인턴으로 보낼 것이므로 k에서 빼준다. (n - max*2) + (m - max) = n + m - max*3
		
		while(K > 0) { //  만약 아직도 필요한 인턴 수가 있다면 (k > 0) 팀을 하나 해체하고 3명을 인턴십으로 보내버린다. 이 동작을 인턴십 모집 인원이 마감될 때까지 한다.
			K -= 3;
			max--;
		}
		System.out.println(max);
	}

}
