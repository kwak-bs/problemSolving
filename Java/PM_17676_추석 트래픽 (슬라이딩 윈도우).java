package problemSolve5;

public class PM_17676 {
	// PM / 17676번 / 추석 트래픽 / 구현, 문자열  / Level3 / 2018 KAKAO BLIND RECRUITMENT [1차]
	public static void main(String[] args) {
		solution(new String[] {"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"});
	}
	
    public static int solution(String[] lines) {
        int answer = 0;
        int [] startTimes = new int[lines.length];
        int [] endTimes = new int[lines.length];
        getTimes(lines, startTimes, endTimes);
        
        // start점을 기준으로 1초 
        for(int i=0; i<startTimes.length; i++) {
        	int cnt = 0;
        	int start = startTimes[i];
        	int endWindow = startTimes[i] + 1000;
        	
        	// start ~ endWindow 안에 있는지 확인 
        	for(int j=0; j < lines.length; j++) {
        		// start부분이 걸친 경우
        		if(startTimes[j] >= start && startTimes[j] < endWindow) cnt++;
        		// end 부분이 걸친 경우
        		else if(endTimes[j] >= start && endTimes[j] < endWindow) cnt++;
        		// window보다 더 큰 범위인 경우
        		else if(startTimes[j] <= start && endTimes[j] >= endWindow) cnt++;
        	}
        	
        	answer = answer > cnt ? answer : cnt;
        }
             
        // end점을 기준으로 1초
        for(int i=0; i<endTimes.length; i++) {
        	int cnt = 0;
        	int start = endTimes[i];
        	int endWindow = endTimes[i] + 1000;
        	
        	// start ~ endWindow 안에 있는지 확인 
        	for(int j=0; j < lines.length; j++) {
        		// start부분이 걸친 경우
        		if(startTimes[j] >= start && startTimes[j] < endWindow) cnt++;
        		// end 부분이 걸친 경우
        		else if(endTimes[j] >= start && endTimes[j] < endWindow) cnt++;
        		// window보다 더 큰 범위인 경우
        		else if(startTimes[j] <= start && endTimes[j] >= endWindow) cnt++;
        	}
        	
        	answer = answer > cnt ? answer : cnt;
        }
        return answer;
    }
    
    public static void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
    	
    	for(int i=0; i<lines.length; i++) {
    		String[] log = lines[i].split(" ");
    		String[] time = log[1].split(":");
    		
    		int process = (int)(Double.parseDouble(log[2].substring(0,log[2].length()-1))* 1000) ;
    		int endTime = 0;
    		int startTime = 0;
    		
    		endTime += Integer.parseInt(time[0]) * 60 * 60 * 1000;
    		endTime += Integer.parseInt(time[1]) * 60 * 1000;
    		endTime += (int)(Double.parseDouble(time[2]) * 1000);
    		
    		startTime = endTime - process + 1;
    		
    		endTimes[i] = endTime;
    		startTimes[i] = startTime;
    	}
    }
}
 