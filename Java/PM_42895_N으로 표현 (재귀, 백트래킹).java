package problemSolve4;

public class PM_42895 {
	// PM / 42895번 / N으로 표현 / 재귀 ,백 트래킹  / Level3
    static int n, target;
    static int answer;
	public static void main(String[] args) {

		solution(5, 12);
	}
    public static int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        
        n = N;
        target = number;
        
        go(0, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void go(int depth, int num) {
        if(depth > 8) {
            answer = -1;
            return;
        }
        
        if(num == target) {
            answer = Math.min(answer, depth);
            return;
        }
        
        int temp = n;
        for(int i=0; i<8-depth; i++) {
            int count = depth + i + 1;
            // +
            go(count, num + temp);
            // - 
            go(count, num - temp);
            // x
            go(count, num * temp);
            // / 
            go(count, num / temp);
            
            temp = temp * 10 + n;
        }
    }
}
