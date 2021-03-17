package problemSolve3;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO_2021_광고삽입 {

	public static void main(String[] args) {

		KAKAO_2021_광고삽입 c = new KAKAO_2021_광고삽입();
		
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String logs[] = {
				"01:20:15-01:45:14", 
				"00:40:31-01:00:00", 
				"00:25:50-00:48:29", 
				"01:30:59-01:53:29", 
				"01:37:44-02:02:30"
				};
		c.solution(play_time, adv_time, logs);
	}
	static int [] ad = new int [360000];
    public String solution(String play_time, String adv_time, String[] logs) {

        
    	for(String s : logs) {
    		int start = strToSec(s.substring(0,8));
    		int finish = strToSec(s.substring(9,17));
    		
    		// 시청자 수 누적 
    		for(int i=start; i<finish; i++) {
    			ad[i]++;
    		}
    	}
    	
    	int n = strToSec(play_time); // 전체 구간 길이
    	int l = strToSec(adv_time); // 광고 구간 길이 
    	
    	int idx = 0;
    	long sum = 0;
    	long max = 0;
    	
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i=0; i<l; i++) {
    		sum += ad[i];
    		q.add(ad[i]);
    	}
    	max = sum;
    	
    	// 큐를 이용한 투 포인터
    	for(int i=l; i<n; i++) {
    		sum += ad[i];
    		q.add(ad[i]);
    		sum -= q.poll();
    		
    		if(sum > max) {
    			idx = i-l+1;
    			max = sum;
    		}
    	}
    	
        String answer = secToStr(idx);
        System.out.println(answer);
        return answer;
    }
    // 문자열 -> 초 변환
    public static int strToSec(String s) {
    	int sec = 0;
    	
    	String h = s.substring(0,2);
    	String m = s.substring(3,5);
    	String c = s.substring(6,8);

    	sec += Integer.parseInt(h) * 60 * 60;
    	sec += Integer.parseInt(m) * 60;
    	sec += Integer.parseInt(c);
    	
    	return sec;
    }
    // 초 -> 문자열 변환 
    public static String secToStr(int n) {
    	String s = "";
    	
    	int c = n%60;
    	n /= 60;
    	int m = n %60;
    	n /= 60;
    	
    	int h = n;
    	
    	if(h <10) s+="0";
    	s += String.valueOf(h);
    	s += ":";
    	
    	if(m <10) s+="0";
    	s += String.valueOf(m);
    	s += ":";
    	
    	if(c <10) s+="0";
    	s += String.valueOf(c);
    	
    	return s;
    }
}
