package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1377 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		pair a[] = new pair [n];
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			a[i] = new pair(num, i);
		}
		
		Arrays.sort(a, new Comparator<pair>() {
			@Override
			public int compare(pair o1, pair o2) {
				return o1.num - o2.num;
			}
		});
		
		int max = 0; 
		
		for(int i=0; i<n; i++) {
			// 정렬 전 인덱스와 현재 인덱스를 뺌
			if(max < a[i].index - i) {
				max = a[i].index - i;
			}
		}
		// 제일 많이 이동한 칸수에 +1 한것이 
		// 버블 소트가 더 이상 정렬할게 없을때의 단계를 뜻한다. 
		System.out.println(max + 1);
	}
}

class pair{
	int num, index;
	
	public pair(int num, int index) {
		this.num = num;
		this.index = index;
	}
}