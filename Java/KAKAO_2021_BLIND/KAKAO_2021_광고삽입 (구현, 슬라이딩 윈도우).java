package problemSolve6;

import java.util.LinkedList;
import java.util.Queue;

public class PM_72414 {
	// PM / 72414번 / 광고 삽입 / 구현, 슬라이딩 윈도우  / Level3 / 2021 KAKAO BLIND
	public static void main(String[] args) {
		
		solution("02:03:55","00:14:15", new String [] {
				"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
		});
	}
	static int total_sec [] = new int[360000];
	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		
		for(int i=0; i< logs.length; i++) {
			int log_start = StringToSec(logs[i].substring(0,8));
			int log_end = StringToSec(logs[i].substring(9,17));
			
			// 총 시청자 수 누적 
			for(int s=log_start; s<log_end; s++) {
				total_sec[s]++;
			}
		}
		
		int play_time_sec = StringToSec(play_time); // 전체 재생 길이
		int adv_time_sec = StringToSec(adv_time); // 전체 광고 길이
		
		
		int answer_start_sec = 0;
		long sum_viewer = 0;
		Queue<Integer> sum_viewer_q = new LinkedList<>();
		// 큐를 이용한 슬라이딩 윈도우 
		for(int i=0; i<adv_time_sec; i++) {
			sum_viewer += total_sec[i];
			sum_viewer_q.add(total_sec[i]);
		}
		
		long max = sum_viewer;
		
		for(int i=adv_time_sec; i<=play_time_sec; i++) {
			sum_viewer += total_sec[i];
			sum_viewer_q.add(total_sec[i]);
			sum_viewer -= sum_viewer_q.poll();
			
			if(sum_viewer > max) {
				answer_start_sec = i - adv_time_sec + 1;
				max = sum_viewer;
			}
		}
		answer = SecToString(answer_start_sec);
	
        return answer;
    }
	
	public static int StringToSec(String time) {
			
		String time_array[] = time.split(":");
		int hourToSec = Integer.parseInt(time_array[0]) * 60 * 60;
		int minToSec = Integer.parseInt(time_array[1]) * 60;
		int Sec = Integer.parseInt(time_array[2]);
		
		return hourToSec + minToSec + Sec;
	}
	
	public static String SecToString (int sec) {
		
		String hourToString = Integer.toString(sec / 3600);
		sec %= 3600;
		String minToString = Integer.toString(sec / 60);
		sec %= 60;
		String secToString = Integer.toString(sec);
		
		if(Integer.parseInt(hourToString) < 10) hourToString = "0"+hourToString;
		if(Integer.parseInt(minToString) < 10) minToString = "0"+minToString;
		if(Integer.parseInt(secToString) < 10) secToString = "0"+secToString;
		return hourToString+":"+minToString+":"+secToString;
	}
} 
