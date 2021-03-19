package problemSolve4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class KAKAO_2019_오픈채팅방 {

	public static void main(String[] args) throws IOException {

		KAKAO_2019_오픈채팅방 c = new KAKAO_2019_오픈채팅방();
		
		String [] record = {"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"};
		c.solution(record);
	}
	
    public String[] solution(String[] record) throws IOException {

    	ArrayList<String> ansList = new ArrayList<>();
    	HashMap<String, String> idmap = new HashMap<String,String> ();
    	
    	for(String s : record) {
    		StringTokenizer stk = new StringTokenizer(s);
    		String cmd = stk.nextToken();
    		
    		if(cmd.equals("Enter") || cmd.equals("Change")) {
    			String id = stk.nextToken();
    			String name = stk.nextToken();
    			idmap.put(id, name);
    		}
    	}
    	
    	for(String s : record) {
    		StringTokenizer stk = new StringTokenizer(s);
    		String cmd = stk.nextToken();
    		
    		if(cmd.equals("Enter")) {
    			String id = stk.nextToken();
    			ansList.add(idmap.get(id) + "님이 들어왔습니다.");
    		}
    		else if(cmd.equals("Leave")) {
    			String id = stk.nextToken();
    			ansList.add(idmap.get(id)+ "님이 나갔습니다.");
    		}
    	}
    	String[] answer = new String[ansList.size()];
    	
    	for(int i =0; i<answer.length; i++) {
    		answer[i] = ansList.get(i);
    	}
        return answer;
    }
}
