package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_16953 {
	// BOJ / 16953¹ø / A ¡æ B / bfs / ½Ç¹ö1
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		Queue<long[]> q = new LinkedList<>();
		Set<Long> set = new HashSet<>();
		q.add(new long[] {a,0});
		long min = -2;
		
		while(!q.isEmpty()) {
			long[] cur = q.poll();
			long num = cur[0];
			long cnt = cur[1];
			if( num == b) {
				min = cnt;
			}
			long next1 = num * 2; 
			if(next1 <= b && !set.contains(next1)) {
				set.add(next1);
				q.add(new long[] {next1, cnt+1});				
			}
			String temp = num+"1";
			long next2 = Long.parseLong(temp);
			if(next2 <= b && !set.contains(next2)) {
				set.add(next2);
				q.add(new long[] {next2, cnt+1});
			}
		}
		System.out.println(min + 1);
	}
}
