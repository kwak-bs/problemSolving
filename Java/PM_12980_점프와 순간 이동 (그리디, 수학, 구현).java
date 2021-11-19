package problemSolve7;

public class PM_12980 {
	// PM / 12980번 / 점프와 순간 이동 / 구현 / Level 2
	public static void main(String[] args) {
		
		solution(5000);
	}
	
    public static int solution(int n) {
        int answer = 0;
        
        while(n > 0) {
        	if(n % 2 == 0) {
        		n /= 2;
        	}
        	else {
        		n--;
        		answer++;
        	}
        }
        System.out.println(answer);
        return answer;
    }
}
