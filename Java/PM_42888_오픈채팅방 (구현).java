package problemSolve5;

import java.util.ArrayList;
import java.util.HashMap;

public class PM_42888 {
	// PM / 42888번 / 오픈채팅방 / 구현 / Level2 / 2019 KAKAO BLIND 
	public static void main(String[] args) {
		solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
	}
	
    public static String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        
        // leave, enter를 통해서 map 업데이트 
        for(int i=0; i<record.length; i++) {
        	String str = record[i];
        	String str_arr[] = str.split(" ");
        	
        	String op = str_arr[0];
        	String id = str_arr[1];
        	String name = "";
        	if(!op.equals("Leave")) {
        		name = str_arr[2];
        	}
        	
        	if(op.equals("Enter")) {
        		hm.put(id, name);
        	}
        	else if(op.equals("Change")) {
        		hm.put(id, name);
        	}
        }
        // 명령어별 msg 추가
        for(int i=0; i<record.length; i++) {
        	String str = record[i];
        	String str_arr[] = str.split(" ");
        	
        	String op = str_arr[0];
        	String id = str_arr[1];
        	
        	if(op.equals("Enter")) {
        		al.add(hm.get(id)+"님이 들어왔습니다.");
        	}
        	else if(op.equals("Leave")) {
        		al.add(hm.get(id)+"님이 나갔습니다.");
        	}
        }
        String answer[] = new String[al.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = al.get(i);
        }
        return answer;
    }
}
