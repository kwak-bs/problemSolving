package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1269 {
	//BOJ / 1269번 / 대칭 차집합  / 해시 / 실3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		Set<Integer> aSet = new HashSet<>();
		Set<Integer> bSet = new HashSet<>();
		Set<Integer> tempSet = new HashSet<>(); // aSet과 똑같은 set
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<a; i++) {
			int num = Integer.parseInt(stk.nextToken());
			aSet.add(num);
			tempSet.add(num);
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<b; i++) {
			bSet.add(Integer.parseInt(stk.nextToken()));
		}
		
		int ab = 0; // a-b
		int ba = 0; // b-a
		
		// tempSet(aSet)에 해당하는 value가 aSet과 bSet에 있으면 삭제해준다.
		for(int value : tempSet) {
			if(bSet.contains(value)) {
				bSet.remove(value);
				aSet.remove(value);
			}
		}
		
		ab = aSet.size();
		ba = bSet.size();
		
		System.out.println(ab + ba);
	}
}
