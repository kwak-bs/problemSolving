package problemSolve6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PM_72412 {
	// PM / 72412번 / 순위 검색 / 구현,  / Level2 / 2021 KAKAO BLIND
	static HashMap<String,ArrayList<Integer>> map = new HashMap<>();
	static int[] answer;
	public static void main(String[] args) {

		solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
				new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
	}
	
	public static int[] solution(String[] info, String[] query) {
		answer = new int[query.length];
		
		setInfo(info);
		countQuery(query);
		return answer;
	}
	
	public static void countQuery(String[] query) {
		
		for(int i=0; i<query.length; i++) {
			String spl[] = query[i].split(" and ");
			String q = "";
			for(int j=0; j<spl.length; j++) {
				q += spl[j];
			}
			String[] qArr = q.split(" ");
			String key = qArr[0];
			int queryScore = Integer.parseInt(qArr[1]);
			int count = 0;	
			// key 값이 없는 경우로 입력으로 주어질 수도 있다. 런타임 에러를 보기 싫으면 if문을 사용하자.
			if(map.containsKey(key)) {
				ArrayList<Integer> list = map.get(key);
				
				int start = 0; 
				int end = list.size()-1;
				int mid = 0;
				// 이분 탐색. 오름 차순된 list에서 queryScore보다 작은 점수를 start 인덱스로 지정하고 list size에서 start를 빼준다. 
				while(start <= end) {
					mid = (start + end) / 2;
					
					if(list.get(mid) >= queryScore) {
						end = mid - 1;
					}
					else {
						start = mid + 1;
					}
				}
				count = list.size() - start;
			}
			answer[i] = count;
		}
	}
	 
	public static void setInfo(String[] info) {
		// 모든 경우의 수를 map의 key 값으로 넣어준다.
		for(int i = 0; i<info.length; i++) {
			dfs("", 0, info[i].split(" "));
		}
		// 각 key 값을 돌며 점수를 오름차순 정렬한다. 
		for(String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
	}
	// "-" 혹은 언어, 직군, 경력을 포함한 str을 key 값으로 map에 저장하거나 str이 key 값으로 존재하면 점수만 list에 추가한다. 
	public static void dfs(String str, int depth, String[] info) {
		
		if(depth == 4) {
			
			if(!map.containsKey(str)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(Integer.parseInt(info[4]));
				map.put(str, list);
			}
			else {
				map.get(str).add(Integer.parseInt(info[4]));
			}
			return;
		}
		
		dfs(str+"-", depth+1, info);
		dfs(str+info[depth], depth+1, info);
	}
}
