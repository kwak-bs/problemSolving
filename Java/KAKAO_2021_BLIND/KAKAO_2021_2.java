package problemSolve2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PM_KAKAO_2021_2 {
	//KAKAO 2021/ 2번 / 메뉴 리뉴얼  
	
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int course[] = {2,3,4};
		
		PM_KAKAO_2021_2 c = new PM_KAKAO_2021_2();
		
		c.solution(orders, course);
	}
	
	
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        int len[] = new int[course[course.length-1] + 1];
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i< orders.length; i++) {
        	char str[] = orders[i].toCharArray();
        	Arrays.sort(str);
        	
        	for(int j=0; j<course.length; j++) {
        		if(course[j] <= orders[i].length()) {
        			nCr(str, orders[i].length(), course[j], 0, "");
        		}
        	}
        }
        
        for(String s : map.keySet()) {
        	if(map.get(s) >= 2) {
        		if(len[s.length()] < map.get(s)) {
        			len[s.length()] = map.get(s);
        		}
        	}
        }
        
        for(String k: map.keySet()) {
        	if(2 <= map.get(k) && len[k.length()] == map.get(k)) {
        		al.add(k);
        	}
        }
        
        Collections.sort(al);
        answer = new String[al.size()];
        
        for(int i=0; i<al.size(); i++) {
        	answer[i] = al.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }
    
    public static void nCr(char[] str, int n, int r, int start, String result) {
    	
    	if( r == 0) {
    		map.put(result, map.getOrDefault(result, 0) +1);
    		return;
    	}
    	else {
    		for(int i=start; i<str.length; i++) {
    			nCr(str, n, r-1, i+1, result+str[i]);
    		}
    	}
    }
}
