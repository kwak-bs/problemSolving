package problemSolve7;

public class PM_43165_2 {
	// PM / 43165¹ø / dfs / Å¸°Ù ³Ñ¹ö / Level2
	public static void main(String[] args) {
		
		int [] numbers = {1,1,1,1,1};
		solution(numbers, 3);
	}
	static int answer= 0;
    public static int solution(int[] numbers, int target) {      
    	
    	dfs(numbers, target, 0 , 0);
    	System.out.println(answer);
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int sum, int depth) {
    	
    	if(numbers.length == depth) {
    		if(sum == target) {
    			answer++;
    			return;
    		}
    		else return;
    	}
    	
    	dfs(numbers, target, sum + numbers[depth], depth+1);
    	dfs(numbers, target, sum - numbers[depth], depth+1);
    }
}
