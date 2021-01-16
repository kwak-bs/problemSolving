package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2960 {
	// BOJ / 2960번 / 에라토스테네스의 체 / 수학, 구현, 정수론, 소수 판정, 에라토스테네스의 체 / 실4
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 2; i <= N; i++) { // N까지의 숫자를 List에 추가 
			al.add(i);
		}

		boolean finish = false;
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(!finish) {
			finish = true;
			
			if(!al.isEmpty()) {
				finish = false;
				int temp = al.get(0); 
				//System.out.println("템프는 : " + temp);
				
				for(int i = 1; i * temp <= N; i++) { // al안에 포함되어 tmp가 있으면 ans에 추가 하고 al에는 삭제해준다. 
					int tmp = temp*i;
					//System.out.println("tmp : " + tmp);
					if(al.contains(tmp)) {
						ans.add(tmp);
						al.remove(al.indexOf(tmp));
					}
				}	
			}
			else {
				finish = true;
			}
		}
		//System.out.println(ans.toString());
		System.out.println(ans.get(K-1));
	}

}
