package problemSolve4;

public class PM_12911 {
	// PM / 12911번 / 다음 큰 숫자 / 구현, 수학  / Level2 
	public static void main(String[] args) {
		solution(78);
	}    
	
	public static int solution(int n) {
        int answer = 0;
        int c = Integer.bitCount(n);
        
        while(true) {
            n++;
            int cc = Integer.bitCount(n); 
            
            if(cc == c) {
                answer = n;
                break;
            }
        }
        return answer;
    }

}
