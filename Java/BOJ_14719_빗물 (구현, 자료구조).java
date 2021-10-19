package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14719 {
	// BOJ / 14719�� / ���� / ����, �ڷᱸ�� / ���5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int h = Integer.parseInt(stk.nextToken());
		int w = Integer.parseInt(stk.nextToken());
		int map[][] = new int[h][w];
		int answer = 0;
		stk = new StringTokenizer(br.readLine(), " ");
		// map �ʱ�ȭ
		for(int i=0; i<w; i++) {
			int wall = Integer.parseInt(stk.nextToken());
			for(int j=h-1; j>=h-wall; j--) {
				map[j][i] = 1;
			}
		}
		// �� �������� �ݺ����� �����Ѵ�. 
		for(int i=0; i<h; i++) {
			// �� ���� ���� �����Ѵ�. 
			ArrayList<Integer> wall = new ArrayList<>();
			for(int j=0; j<w; j++) {
				if(map[i][j] == 1) {
					wall.add(j);
				}
			}
			// ���� 2�� �̻���� �� ������ �ε����� ���� ���°����� �����ϰ� ���� �����Ѵ�.
			if(wall.size() > 1) {
				int left = wall.get(0);
				for(int k=1; k<wall.size(); k++) {
					answer += (wall.get(k) - left - 1);
					left = wall.get(k); 
				}
			}
		}
		
		System.out.println(answer);
	}
}
