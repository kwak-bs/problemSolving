package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1713 {
	// BOJ / 1713번 / 후보 추천하기 / 구현 / 실버2
	static PriorityQueue<int []> photoInfo;
	static int time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int k = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> recInfo = new HashMap<>(); // 추천인, 추천받은 수
		photoInfo = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {
					return o1[2] - o2[2]; 
				}
				return o1[1] - o2[1];
			}

		}); // 사진, 추천 수 , 시간
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		time = 1;
		while(k-- > 0) {
			int t = Integer.parseInt(stk.nextToken());

			recInfo.put(t, recInfo.getOrDefault(t, 0)+1);
			boolean pass = false;
			if(inPhotoCheck(t)) {
				pass = true;
			}
			if(!pass) {
				if(photoInfo.size() < n) {
					photoInfo.add(new int[] {t, recInfo.get(t), time});
				}
				else {
					int[] photo = photoInfo.poll();
					recInfo.put(photo[0], 0);
					photoInfo.add(new int[] {t, recInfo.get(t), time});
				}				
			}
			time++;
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		while(photoInfo.size() > 0) {
			int[] photo = photoInfo.poll();
			
			answer.add(photo[0]);
		}
		Collections.sort(answer);
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
	// 현재 걸려있는 사진 중에 추천받은 후보가 있는지 확인
	public static boolean inPhotoCheck(int t) {
		int len = photoInfo.size();
		Queue<int[]> temp = new LinkedList<>();
		boolean ok = false;
		while(len-- > 0) {
			int []photo = photoInfo.poll();
			if(photo[0] == t ) {
				temp.add(new int[] {photo[0], photo[1] + 1,photo[2]});
				ok = true;
			}
			else {
				temp.add(new int[] {photo[0], photo[1], photo[2]});
			}
			
		}
		len = temp.size();
		while(len--> 0) {
			int[] photo = temp.poll();
			photoInfo.add(new int[] {photo[0], photo[1], photo[2]});
		}
		return ok;
	}
}
