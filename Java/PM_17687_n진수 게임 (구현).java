package problemSolve5;

public class PM_17687 {
	// PM / 17687번 / n진수 게임 / 구현 / Level2 / 2018 카카오 블라인드 채용
	public static void main(String[] args) {
		solution(2,4,2,1);
	}
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        sb.append(0); // 0부터 시작 
        int i = 1; // 진행되는 게임 숫자 
        
        // 구해야하는 모든 숫자(모든 인원 포함)
        while(sb.length() < m*t) {
            sb.append(notation(i++, n));
        }
        
        // 튜브 차례마다 answer에 추가
        for(int j=p; j<=t*m; j+=m) {
            answer += sb.charAt(j-1);
        }
        return answer;
    }
    
    // 진법 변환.
    private static String notation(int num, int n) {
        String s = "";
        while(num != 0) {
            if(num % n < 10) {
                s = num%n + s;
            }
            else {
                s = String.valueOf((char)(num%n + 55)) + s;
            }
            num /= n;
        }
        
        return s;
    }
}
