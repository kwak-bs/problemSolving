package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707 {
	// BOJ / 1707번 / 이분 그래프 / 그래프 / 골드4
	static ArrayList<Integer> al[];
	static int colors[];
	static final int RED = 1;
	static final int BLUE = -1;
	static boolean isBip;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk; 
		
		int t = Integer.parseInt(br.readLine());
		
		
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int v = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			al = new ArrayList[v+1];
			colors = new int[v+1];
			isBip = true;
			for(int i=0; i<al.length; i++) {
				al[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<e; i++) {
				stk= new StringTokenizer(br.readLine(), " ");
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				al[a].add(b);
				al[b].add(a);
			}
			// 연결 그래프와 비연결 그래프의 경우를 모두 탐색해봐야 하므로 
			// 모든 정점을 탐색한다.
			for(int i=1; i<v+1; i++) {
				if(!isBip) {
					break;
				}
				if(colors[i] != 0) {
					continue;
				}
				dfs(i, RED);
			}
			
			
			System.out.println(isBip ? "YES" : "NO");
		}
	}
	
	public static void dfs(int index, int color) {
		
		colors[index] = color;
		for(int next : al[index]) {
			
			if(colors[next] == color) {
				isBip = false;
				return;
			}
			
			if(colors[next] == 0) {
				dfs(next, -color);
			}
		}
	}
}
