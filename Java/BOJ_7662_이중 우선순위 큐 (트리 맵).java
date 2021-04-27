package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
	// BOJ / 7662번 / 이중 우선순위 큐 / 트리맵 / 골드5
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-- > 0) {
			int tt = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			
			while(tt-- >0) {
				stk = new StringTokenizer(br.readLine(), " ");
				String d = stk.nextToken();
				int dd = Integer.parseInt(stk.nextToken());

				if(d.equals("I")) {
					tm.put(dd, tm.getOrDefault(dd, 0)+1);
				}
				else{
					if(tm.size() == 0) continue;
					
					int num = dd == 1 ? tm.lastKey() : tm.firstKey();
					if(tm.put(num, tm.get(num) - 1) == 1) {
						tm.remove(num);
					}
				}
			}
			
			if( tm.size() == 0) {
				sb.append("EMPTY").append("\n");
			}
			else {
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
