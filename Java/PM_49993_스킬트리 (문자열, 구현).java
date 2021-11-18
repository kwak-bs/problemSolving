package problemSolve7;

import java.util.LinkedList;
import java.util.Queue;

public class PM_49993 {
	// PM / 49993번 / 스킬트리 / 구현, 문자열 / Level 2
	public static void main(String[] args) {
		
		String skill = "CBDK";
		String skill_trees[] = {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};
		solution(skill, skill_trees);
	}

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees) {
        	int order = 0;
        	boolean pass = true;
        	for(char curSk : tree.toCharArray()) {
        		int index = skill.indexOf(curSk);
        		if(index == -1) {
        			continue;
        		}
        		else if(order == index) {
        			order++;
        		}
        		else {
        			pass = false;
        			break;
        		}
        	}
        	if(pass) answer++;
        }
        
        System.out.println(answer);
        return answer;
    }
}
