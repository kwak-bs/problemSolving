package problemSolve;

import java.util.ArrayList;
import java.util.Collections;

public class PM_68644 {
	//PM(프로그래머스) / 68644번 / 두 개 뽑아서 더하기 
	public static void main(String[] args) {
		
		int [] numbers = {5,0,2,7};
		PM_68644 c = new PM_68644();
		
		c.solution(numbers);
	}
	
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++) {
        	for(int j= i+1; j<numbers.length; j++) {
        		int sum = numbers[i] + numbers[j]; // 반복문을 돌면서 더해준다. 
        		
        		// sum이 al에 포함되어 있지 않으면 추가. 중복된 값은 넣지 않는다. 
        		if(al.contains(sum)) {
        			continue;
        		}
        		else {
        			al.add(sum);        			
        		}
        	}
        }        
        int[] answer = new int[al.size()];
        Collections.sort(al); // al을 오름차순 정렬한다.
        
        for(int i=0; i<al.size(); i++) {
        	answer[i] = al.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }
}
