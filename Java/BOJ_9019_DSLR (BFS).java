package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
	// BOJ / 9019¹ø / DSLR / BFS / °ñµå5
	static StringTokenizer stk;
	static StringBuilder sb = new StringBuilder();
	static boolean v[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			v = new boolean[10000];
			bfs(a,b);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int a, int b) {
		
		Queue<register> q = new LinkedList<>();
		v[a] = true;
		q.add(new register(a, ""));
		
		while(!q.isEmpty()) {
			register now = q.poll();
			int num = now.num;
			String op = now.op;

			if(num == b) {
				sb.append(op);
				return;
			}
			int next = 0;
			// D
			next = num * 2;
			if(next > 9999) {
				next %= 10000;
			}
			if(!v[next]) {
				v[next] = true;
				q.add(new register(next, op+"D"));
			}
			// S 
			if( num == 0) {
				next = 9999;
			}
			else {
				next = num - 1;				
			}
			if(!v[next]) {
				v[next] = true;
				q.add(new register(next, op+"S"));
			}
			// L
			String strNum = Integer.toString(num);
			while(strNum.length() != 4) {
				strNum = "0"+strNum;
			}
			String first = strNum.substring(0,1);
			String temp = strNum.substring(1,strNum.length());
			int newNum = Integer.parseInt(temp+first);
			if(!v[newNum]) {
				v[newNum] = true;
				q.add(new register(newNum, op+"L"));
			}
			
			// R
			String last = strNum.substring(strNum.length()-1, strNum.length());
			temp = strNum.substring(0, strNum.length()-1);
			newNum = Integer.parseInt(last+temp);
			if(!v[newNum]) {
				v[newNum] = true;
				q.add(new register(newNum, op+"R"));
			}
		}
	}
	
	private static class register {
		int num;
		String op;
		public register (int num, String op) {
			this.num = num;
			this.op = op;
		}
	}
}
