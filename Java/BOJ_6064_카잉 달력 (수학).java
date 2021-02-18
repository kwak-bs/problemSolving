package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
	// BOJ / 6064번 / 카잉 달력  / 수학 / 실1
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int m = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			int gcd = gcd(Math.max(m, n), Math.min(m, n));
			long lcm = lcm(m,n,gcd);

			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			// x를 고정.
			int ans = x % (m+1);
			int tempY = ans;
			boolean flag = false;
			
			// x는 맞췄기 때문에 y만큼만 돌리면 됨.
			for(int i=0; i<n; i++) {
				//ans로 n을 나눌순 없으니까 tempY를 ans화 하여 계산진행.
				// 대신 tempY는 나머지를 활용하여 진행.
				tempY = tempY % n == 0 ? n : tempY % n;
				
				if(tempY == y) {
					flag = true;
					break;
				}
				tempY += m;
				ans +=m;
			}
			
			if(flag) {
				sb.append(ans).append("\n");
			}
			else {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int gcd(int big, int small) {
		
		while(small > 0) {
			int temp = big % small;
			big = small;
			small = temp;
		}
		return big;
	}
	
	public static int lcm(int m, int n, int gcd) {
		return m * n / gcd;
	}
}
