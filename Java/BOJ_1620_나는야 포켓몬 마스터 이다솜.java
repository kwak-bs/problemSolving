package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
	//BOJ / 1620번 / 나는야 포켓몬 마스터 이다솜  / 해시 / 실4
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		// 입력으로 들어오는걸 int인지 String인지 구분을 어떻게 할까 고민하였으나 
		// 그냥 둘 다 스트링으로 넣기로 하였다.
		for(int i=0; i<n; i++) {
			String temp = br.readLine();
			map.put(temp, Integer.toString(i+1));
			map.put(Integer.toString(i+1), temp);
		}
		
		for(int i=0; i<m; i++) {
			String question = br.readLine();
			System.out.println(map.get(question));
		}
	}
}
