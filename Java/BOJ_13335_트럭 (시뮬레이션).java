package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13335 {
	// BOJ / 13335번 / 트럭 / 시뮬레이션 / 실버1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken()); // 트럭 수 
		int w = Integer.parseInt(stk.nextToken()); // 다리 길이
		int l = Integer.parseInt(stk.nextToken()); // 최대 하중 
		
		ArrayList<Integer> Truck = new ArrayList<>();
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			Truck.add(Integer.parseInt(stk.nextToken()));
		}
		int bridge[] = new int[w];
		
		int time = 0;
		while(true) {
			time++;

			int curBW = 0;
			int InTr = 0;

			// 현재 다리의 상황을 보자 
			for(int i=0; i<bridge.length; i++) {
				if(bridge[i] == 0) continue;
				curBW += bridge[i];
				InTr++;
			}

			// 현재 다리에 있는 트럭들 부터 옮기자.
			if(InTr > 0 ) {
				// 다리 맨 앞에 트럭이 있으면 밖으로 보내주자. 
				if(bridge[0] != 0) {
					InTr--;
					curBW -= bridge[0];
					bridge[0] = 0;
				}
				// 1부터 차례대로 앞으로 옮기자 
				for(int i=1; i<bridge.length; i++) {
					bridge[i-1] = bridge[i]; 
					bridge[i] = 0;
				}
			}
			
			// 다리 맨 뒤가 비었다면 트럭을 넣어주자 
			if(bridge[bridge.length-1] == 0) {
				// 그래도 현재 다리의 하중을 확인하자.
				if(Truck.size() > 0) {
					int ww = Truck.get(0);
					
					if(curBW + ww <=l) {
						bridge[bridge.length-1] = ww;
						InTr++;
						Truck.remove(0);
						
					}					
				}
			}

			if(Truck.size() == 0 && InTr == 0) {
				break;
			}
		}
		
		System.out.println(time);
	}
}
