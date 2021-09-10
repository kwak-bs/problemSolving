package problemSolve6;

public class PM_83201 {
	// PM / 83201번 / 위클리 챌린지 / 구현 / 2주차 
	public static void main(String[] args) {

		solution(new int[][] {
			{100,90,98,88,65},
			{50,45,99,85,77},
			{47,88,95,80,67},
			{61,57,100,80,65},
			{24,90,94,75,65}
		});
	}
	
    public static String solution(int[][] scores) {
        String answer = "";
        
        for(int i=0; i<scores.length; i++) {
        	int sum = 0;
        	int len = scores.length;
        	
        	int maxMin[] = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        	maxMin = getMaxMin(maxMin, scores, i);
        	
        	int maxMinCount[] = {0,0};
        	maxMinCount = getMaxMinCount(maxMinCount, scores, i,maxMin);

        	// 본인 점수가 최저 최저 이고 count가 1이면 len과 sum을 뺀다.
        	for(int j=0; j<scores.length; j++) {
        		if(i == j) {
        			if(maxMin[0] == scores[i][j] && maxMinCount[0] == 1) {
        				len--;
        				continue;
        			}
        			if(maxMin[1] == scores[i][j] && maxMinCount[1] == 1) {
        				len--;
        				continue;
        			}
        		}
        		sum += scores[j][i];
        	}
        	answer += gradeToString(len, sum);
        }
        return answer;
    }
    
    public static int[] getMaxMinCount(int[]maxMinCount, int[][]scores, int i,int []maxMin ) {
    	
    	for(int j=0; j<scores.length; j++) {
    		
    		if(scores[j][i] == maxMin[0]) {
    			maxMinCount[0]++;
    		}
    		if(scores[j][i] == maxMin[1]) {
    			maxMinCount[1]++;
    		}
    	}
    	return maxMinCount;
    }
    
    public static int[] getMaxMin(int[] maxMin, int[][] scores,int i) {
    	for(int j=0; j<scores.length; j++) {
    		if(maxMin[0] < scores[j][i]) {
    			maxMin[0] = scores[j][i];
    		}
    		if(maxMin[1] > scores[j][i]) {
    			maxMin[1] = scores[j][i];
    		}
    	}
    	
    	return maxMin;
    }
    
    public static String gradeToString(int len, int sum) {
    	String result = "";
    	
    	double grade = sum / len;
    	
    	if(grade >= 90) {
    		result += "A";
    	} 
    	else if(grade >=80 && grade < 90) {
    		result += "B";
    	}
    	else if(grade >= 70 && grade < 80) {
    		result += "C";
    	}
    	else if(grade >= 50 && grade < 70) {
    		result += "D";
    	}
    	else {
    		result += "F";
    	}
    	return result;
    }
}
