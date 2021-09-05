package problemSolve6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PM_72412 {
	// PM / 72412�� / ���� �˻� / ����,  / Level2 / 2021 KAKAO BLIND
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
			// key ���� ���� ���� �Է����� �־��� ���� �ִ�. ��Ÿ�� ������ ���� ������ if���� �������.
			if(map.containsKey(key)) {
				ArrayList<Integer> list = map.get(key);
				
				int start = 0; 
				int end = list.size()-1;
				int mid = 0;
				// �̺� Ž��. ���� ������ list���� queryScore���� ���� ������ start �ε����� �����ϰ� list size���� start�� ���ش�. 
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
		// ��� ����� ���� map�� key ������ �־��ش�.
		for(int i = 0; i<info.length; i++) {
			dfs("", 0, info[i].split(" "));
		}
		// �� key ���� ���� ������ �������� �����Ѵ�. 
		for(String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
	}
	// "-" Ȥ�� ���, ����, ����� ������ str�� key ������ map�� �����ϰų� str�� key ������ �����ϸ� ������ list�� �߰��Ѵ�. 
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
