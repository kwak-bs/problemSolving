package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9375 {
	//BOJ / 9375번 / 패션왕 신해빈  / 해시 / 실3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			HashMap<String,Integer> map = new HashMap<>();

			
			for(int i=0; i<n; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				// 첫번째 들어오는 입력은 버리고 두번 째 들어오는 옷의 종류만 key로 넣어준다.
				stk.nextToken();
				String key = stk.nextToken(); 
				map.put( key, 
						map.getOrDefault(key, 0) +1);
			}
			
			Set<String> keySet = map.keySet();
			
			int answer = 1;
			for(String key : keySet) {
				// 입거나 안입거나 조합 갯수 세기
				answer *= map.get(key) + 1;
			}
			// 아예 안입는 경우를 빼준다.
			System.out.println(answer - 1);
		}
	}
}
