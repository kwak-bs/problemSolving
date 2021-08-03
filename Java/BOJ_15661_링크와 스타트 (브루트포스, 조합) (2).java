package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661 {
	// BOJ / 15661번 / 링크와 스타트 / 조합, 백트래킹  / 실버1
	static int map[][], n, answer,t;
	static boolean v[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n];
		answer = Integer.MAX_VALUE;
		t=0;
		StringTokenizer stk;
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// t는 팀원 수. 팀원이 절반으로 떨어지는 것이 아니기 때문에 가능한 경우의 수를 모두 탐색한다.
		for(t=1; t<n; t++) {
			nCr(0,0);			
		}
		System.out.println(answer);
	}
	
	public static void nCr(int depth, int start) {
		
		if(depth == t ) {
			answer = Math.min(answer, diff());
			// 0이 나오면 가장 작은 최소값이기 때문에 더 이상 순회 할 필요가 없다. 
			// 시간을 조금 더 줄일 수 있다.
			if(answer == 0) {
				System.out.println(answer);
				System.exit(0);
			}
			return;
		}
		// i를 0이 아닌 start값으로 하면 시간 초과 방지및 시간을 크게 줄일 수 있다.
		for(int i=start; i<n; i++) {
			if(!v[i]) {
				v[i]= true;
				nCr(depth+1, i+1);
				v[i]=false;
			}
		}
	}
	
	public static int diff() {
		
		int start = 0; // v[] 값이 true면 start팀
		int link = 0; //  v[] 값이 false면 link팀
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(v[i] && v[j]) {
					start += (map[i][j] +map[j][i]);
				}
				else if(!v[i] && !v[j]) {
					link += (map[i][j] + map[j][i]);
				}
			}
		}
		
		return  Math.abs(start - link);
	}
}
