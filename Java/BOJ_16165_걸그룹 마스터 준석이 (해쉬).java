package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_16165 {
	// BOJ / 16165번 / 걸그룹 마스터 준석이 / 해쉬 / 실3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		HashMap<String, Object> teamMap = new HashMap<>(); // map의 value 값으로 ArrayList를 사용하기 위함.
		HashMap<String, String> MemberMap = new HashMap<>();		
		
		for(int i=0; i <n; i++) {
			String team = br.readLine();
			int member = Integer.parseInt(br.readLine());
			
			ArrayList<String> al = new ArrayList<>();
			
			for(int j=0; j<member; j++) {
				// 멤버 이름을 입력 받아 MemberMap key값으로 넣어주고 (문제가 1일경우를 해결하기 위함)
				// team별로 생성한 al에 멤버 이름을 넣어준다.
				
				String name = br.readLine();
				al.add(name);
				MemberMap.put(name, team);
			}
			
			// team별로 map에 ArrayList를 저장한다.  
			// 여기가 중요 포인트.
			teamMap.put(team, al);
		}
		
		Set<String> mapSet = teamMap.keySet();
		Set<String> map2Set = MemberMap.keySet();
		
		for(int i=0; i<m; i++) {
			String temp = br.readLine();
			int prob = Integer.parseInt(br.readLine());
			
			//팀 이름 들어왔을 경우 멤버 사전순 출력.
			if(prob == 0 ) {
				for(String key : mapSet) {
					//System.out.println(map.get(key).toString().split(",").length);
					if(key.equals(temp)) {
						
						int len = teamMap.get(key).toString().length();

						// 양 끝에 '[' , ']' 제거한다.
						String[] members = teamMap.get(key).toString().substring(1, len-1).split(", ");
						// 사전순 정렬
						Arrays.sort(members);

						for(int j=0; j<members.length; j++) {
							System.out.println(members[j]);
						}
					}
				}
			}
			
			//멤버 이름 들어왔을 경우 팀 이름 출력.
			else if(prob == 1) {
				for(String key : map2Set) {
					if(key.equals(temp)) {
						System.out.println(MemberMap.get(temp));						
					}
				}
			}
		}
	}
}
