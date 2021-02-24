package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182 {
	// BOJ / 1182번 / 부분 수열의 합 / 브루트포스 / 실버2
	
	static int n,s,count;
	static int num[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk= new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		s = Integer.parseInt(stk.nextToken());
		num = new int[n];
		visit = new boolean [n];
		stk= new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}

		recursion(0,0,0);
		
		System.out.println(count);
	}
	
	public static void recursion(int sum, int depth,int start) {

		if(depth > 0 && sum == s) {
			count ++;
		}
		// 밑에 if문에 기저조건 더 추가해줄라고 sum > s 라는 쓰렉같은 조건 추가해줬다가 시간만 개날림
		// 생각해보니 s는 음수도 가능했었는데 후아 ㅋ 
		if(depth == n ) {
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			recursion(sum + num[i], depth+1,i+1);
			visit[i]= false;
		}
	}
}
