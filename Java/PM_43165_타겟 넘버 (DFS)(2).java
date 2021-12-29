package problemSolve7;

public class PM_43165 {
	// PM / 49191�� / dfs / Ÿ�� �ѹ� / Level2
	public static void main(String[] args) {
		
		int [] numbers = {1,1,1,1,1};
		solution(numbers, 3);
	}

    public static int solution(int[] numbers, int target) {        
        return dfs(numbers, target, 0 ,0);
    }
    
    public static int dfs(int[] numbers, int target, int sum, int depth) {
        
        if(depth == numbers.length){ 
            if(sum == target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
        return dfs(numbers, target, sum+numbers[depth], depth+1) + dfs(numbers, target, sum-numbers[depth], depth+1); 
    }
}
