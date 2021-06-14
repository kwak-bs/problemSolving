package problemSolve5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PM_17678 {
	// PM / 17678번 / 셔틀버스 / 구현, 힙 / Level3 / 2018 KAKAO BLIND
	public static void main(String[] args) {
		solution(1,1,1,new String[] {"23:59"});
	}
	
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Crue> pq = new PriorityQueue<>(new Comparator<Crue>() {
        	@Override
        	public int compare(Crue o1, Crue o2) {
        		return o1.time - o2.time;
        	}
        });
        
        for(int i=0; i<timetable.length; i++) {
        	int time = CalTime(timetable[i]);
        	pq.add(new Crue(i, time));
        }
        

        int bus = CalTime("09:00");
        // 임시로 넣어둠
        Crue corn = pq.peek();
        // 총 버스의 수 
        for(int i=0; i<n; i++) {
        	int people = 0;
        	
        	// 버스 마다 탑승하는 인원 수 
        	for(int j=0; j<m; j++) {
        		
        		if(!pq.isEmpty()) {
        			Crue now = pq.peek();
        			// 버스 도착 시간 이하로 도착했으면 버스에 탑승
        			if(now.time <= bus) {
        				corn = pq.poll();
        				people++;
        			}
        		}
                // 마지막 버스일때
                // 1. 자리가 없다(사람이 가득 차있다.) => 마지막 탄 사람에서 -1 해준다. 
                // 2. 자리가 있다. => 마지막 버스 도착 시간으로 갱신한다. 
        		if(i == n-1 && people == m) {
        			 corn = new Crue(corn.index, corn.time-1);
        		}
        		else if(i == n-1 && people < m) {
        			corn = new Crue(corn.index, bus);
        		}
        	}
        	// 다음 버스 도착 시간
        	bus += t;
        }
        
        answer = strToInt(corn.time);
        System.out.println(answer);
        return answer;
    }
    
    public static int CalTime(String strTime) {
    	String timeArr[] = strTime.split(":");
    	
    	int hour = Integer.parseInt(timeArr[0]) * 60;
    	int min = Integer.parseInt(timeArr[1]);
    	
    	int time = hour + min;
    	return time;
    }
    
    public static String strToInt (int time) {
    	String result = "";
    	int h = 0;
    	int m = 0;
    	if(time >= 60) {
    		h = time / 60;
    		time %= 60;
    	}
    	m = time;
    	String hStr = h+"";
    	String mStr = m+"";
    	if(h < 10) {
    		hStr = "0"+hStr;
    	}
    	if(m < 10) {
    		mStr = "0"+mStr;
    	}
    	
    	result = hStr+":"+mStr;
    	return result;
    }
    
    private static class Crue {
    	int index;
    	int time; 
    	public Crue(int index, int time) {
    		this.index = index;
    		this.time = time;
    	}
    }
}
