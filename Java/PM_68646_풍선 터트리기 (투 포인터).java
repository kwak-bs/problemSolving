package problemSolve5;

import java.util.HashSet;

public class PM_68646 {
	// PM / 68646번 / 풍선 터뜨리기 / 투 포인터 / Level3
	public static void main(String[] args) {
		
		solution(new int[] {9,-1,5});
	}
	
    public static int solution(int[] a) {
        int answer = 2; // 처음과 끝은 무조건 남음
        
        int l = a[0], r = a[a.length-1];
        
        for(int i=1; i<a.length; i++) { // 가운데 풍선을 걸러낸다.
        	if(l > a[i]) {
        		l = a[i];
        		answer++;
        	}
        	if(r > a[a.length-1-i]) {
        		r = a[a.length-1-i];
        		answer++;
        	}
        }
        
        return l == r ? answer-1 : answer; // l과 r이 같으면 중복 발생
    }
}
