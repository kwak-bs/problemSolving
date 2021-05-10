package problemSolve5;

public class PM_12952 {
	// PM / 12952번 / N-Queen / 백트래킹  / Level3 
	public static void main(String[] args) {
		solution(4);
	}
	static int[] arr;
	static int count = 0;
	static int N;
    public static int solution(int n) {
        int answer = 0;
        
        arr = new int[n];
        N=n;
        nQueen(0);
        System.out.println(count);
        answer = count;
        return answer;
    }
    public static void nQueen(int depth) {
    	
    	if(depth == N) {
    		count++;
    		return;
    	}
    	
    	for(int i=0; i<N; i++) {
    		arr[depth] = i;
    		if(possibility(depth)) {
    			nQueen(depth+1);
    		}
    	}
    }
    
    public static boolean possibility(int col) {

    	for(int i=0; i<col; i++) {
    		// 같은 행에 존재하는 경우
    		if(arr[i] == arr[col]) {
    			return false;
    		}
    		// 대각선에 존재하는 경우 (열의 차 = 행의 차)
    		else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
    			return false;
    		}
    	}
    	return true;
    }
}
