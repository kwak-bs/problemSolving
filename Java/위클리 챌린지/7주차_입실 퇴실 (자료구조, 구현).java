package problemSolve6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PM_86048 {
	// PM / 86048번 / 위클리 챌린지 / 자료구조  / 7주차 
	public static void main(String[] args) {
		
		int[] enter = {1,3,2};
		int[] leave = {1,2,3};
		solution(enter, leave);
	}

	static HashMap<Integer, Integer> meetPeople;
	static List<Integer> in = new LinkedList<>();
	static int inIndex = 0;
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        // Map 초기화 
        meetPeople = new HashMap<>();
        for(int i=1; i<=enter.length; i++) {
        	meetPeople.put(i, 0);
        }
        for(int i=0; i<leave.length; i++) {
        	int outPerson = leave[i];
        	enterCheck(outPerson, enter);
        }
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = meetPeople.get(i+1);
        	System.out.println(answer[i]);
        }
        return answer;
    }
    
    public static void enterCheck(int outPerson ,int[] enter) {
    	
    	while(inIndex < enter.length) {
    		boolean inRoom = false; // 새로온 사람이 들어왔는지 체크
    		int newPerson = 0; // 새로온 사람이 누군지
    		if(enter[inIndex] != 0) {
    			in.add(enter[inIndex]);
    			newPerson = enter[inIndex];
    			// 방문 체크 
    			enter[inIndex] = 0;
    			inRoom = true;
    		}
 
    		// in size가 2 이상이고, 새로운 사람이 들어왔다면 
    		if(in.size() >= 2 && inRoom) {
    			// 새로온 사람은 기존에 있는 사람들 수 만큼 만난다. 
    			meetPeople.put(newPerson, in.size()-1);
    			
    			// 기존에 있는 사람들한테는 1명이 추가된 것이다. 
    			for(int person : in) {
    				if(person == newPerson) continue;
    				meetPeople.put(person, meetPeople.get(person)+1);
    			}
    		}
    		// 방에 있는 사람 중 떠날 사람이 존재하는지 확인한다. 
    		if(leaveCheck(outPerson)) {
    			return;
    		}
    		inIndex++;
    	}
    	
    }
    // 떠날 사람이 존재하면 list에서 삭제한다. 
    public static boolean leaveCheck (int outPerson) {
    	if(in.contains(outPerson)) {
    		int i = in.indexOf(outPerson);
    		in.remove(i);
    		return true;
    	}
    	return false;
    }
}
