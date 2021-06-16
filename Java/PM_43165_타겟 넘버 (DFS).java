package problemSolve5;

public class PM_43165 {
	// PM / 43165¹ø / Å¸°Ù ³Ñ¹ö / DFS / Level2  
	public static void main(String[] args) {
		solution(new int[] {1,1,1,1,1}, 3);
	}
	static int count;
	static boolean v[];
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        count = 0;
        v = new boolean[numbers.length];
        
        dfs(0, numbers, target, 0);
        answer = count;
        System.out.println(answer);
        return answer;
    }
    
    public static void dfs(int depth, int[] numbers, int target, int sum) {
    	
    	if(depth == numbers.length) {
    		if(sum == target) count++;
    		return;
    	}
    	
    	dfs(depth+1, numbers, target, sum + numbers[depth]);
    	dfs(depth+1, numbers, target, sum - numbers[depth]);
    }
}
