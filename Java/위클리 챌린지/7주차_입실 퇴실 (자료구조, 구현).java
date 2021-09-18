package problemSolve6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PM_86048 {
	// PM / 86048�� / ��Ŭ�� ç���� / �ڷᱸ��  / 7���� 
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
        // Map �ʱ�ȭ 
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
    		boolean inRoom = false; // ���ο� ����� ���Դ��� üũ
    		int newPerson = 0; // ���ο� ����� ������
    		if(enter[inIndex] != 0) {
    			in.add(enter[inIndex]);
    			newPerson = enter[inIndex];
    			// �湮 üũ 
    			enter[inIndex] = 0;
    			inRoom = true;
    		}
 
    		// in size�� 2 �̻��̰�, ���ο� ����� ���Դٸ� 
    		if(in.size() >= 2 && inRoom) {
    			// ���ο� ����� ������ �ִ� ����� �� ��ŭ ������. 
    			meetPeople.put(newPerson, in.size()-1);
    			
    			// ������ �ִ� ��������״� 1���� �߰��� ���̴�. 
    			for(int person : in) {
    				if(person == newPerson) continue;
    				meetPeople.put(person, meetPeople.get(person)+1);
    			}
    		}
    		// �濡 �ִ� ��� �� ���� ����� �����ϴ��� Ȯ���Ѵ�. 
    		if(leaveCheck(outPerson)) {
    			return;
    		}
    		inIndex++;
    	}
    	
    }
    // ���� ����� �����ϸ� list���� �����Ѵ�. 
    public static boolean leaveCheck (int outPerson) {
    	if(in.contains(outPerson)) {
    		int i = in.indexOf(outPerson);
    		in.remove(i);
    		return true;
    	}
    	return false;
    }
}
