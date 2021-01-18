package problemSolve;

import java.util.ArrayList;

public class PM_68935 {
	//PM(프로그래머스) / 68935번 / 3진법 뒤집기 
	public static void main(String[] args) {

	      int n = 45;
	      
	      PM_68935 c = new PM_68935();
	      

	      c.solution(n);
	}
	
    public int solution(int n) {
        int answer = 0;
     
        ArrayList<Integer> al = new ArrayList<>();
       
        // 앞뒤 반접 (3진법) 한번에 표현
        while(n >= 3 ) {
        	int tmp = n % 3 ;
        	al.add(tmp);
        	n /= 3;
        }
        // 나머지 몫까지 넣어주기
        al.add(n);
        
        
        // 10진법으로 표현
        for(int i=0; i<al.size(); i++) {
        	answer += al.get(i) * Math.pow(3, al.size()-i-1);
        }
        
        System.out.println(answer);
        return answer;
    }
}
