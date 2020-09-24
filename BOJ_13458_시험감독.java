package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {
	//BOJ / 13458번 /  시험 감독 / 수학 / 브2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 입력 
		int [] stu = new int[n];  // 각 시험장 마다 시험을 보는 학생수 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<stu.length; i++) {
			int input = Integer.parseInt(st.nextToken());
			stu[i] = input;
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int b = Integer.parseInt(st2.nextToken()); // 총 감독관
		int c = Integer.parseInt(st2.nextToken()); // 부 감독관
		
		long ans = 0; 

		
		for(int i=0; i<stu.length; i++) {
			stu[i] -= b; // 총 감독관은 무조건 1명 들어와야한다.
			ans++;
			
			if(stu[i] > 0) { 
				ans += stu[i] / c; //부 감독관의 수 구하기
				
					if(stu[i] % c != 0) { // 0으로 떨어지지 않으면 한명 추가
						ans++;
					}
			}
		}
		System.out.println(ans);
	}
}
