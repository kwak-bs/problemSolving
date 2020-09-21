package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250 {
	//BOJ / 10250번 / ACM 호텔 / 수학, 구현, 사칙연산 / 브3
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); //입력
			int h = Integer.parseInt(st.nextToken()); // 층
			int w = Integer.parseInt(st.nextToken()); // 방
			int n = Integer.parseInt(st.nextToken()); // 사람
			
			int per = 0;
			int floor = 0;
			int room = 1;
			String f = "";
			String r = "";
			
			while(per < n ) { // 사람과 층은 같이 증가, 층은 마지막 층까지 올라갔을 경우 room++
				per++;
				floor++;
				
				if(floor > h) {
					floor = 1;
					room++;
				}
			}
			
			StringBuffer sb = new StringBuffer();
			f = Integer.toString(floor);
			
			if(room < 10) {
				r = "0"+Integer.toString(room);
			}
			else {
				r = Integer.toString(room);
			}
			sb.append(f);
			sb.append(r);
			System.out.println(sb.toString());
			per = 0;
			floor = 0;
			room = 0;
		}
	}
}
