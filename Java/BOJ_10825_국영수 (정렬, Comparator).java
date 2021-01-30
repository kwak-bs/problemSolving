package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10825 {
	// BOJ / 10825번 / 국영수 / 정렬 / 실버 4
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int n = Integer.parseInt(br.readLine());
		grade std []= new grade[n];
		
		for(int i =0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			String name = stk.nextToken();
			int kor = Integer.parseInt(stk.nextToken());
			int eng = Integer.parseInt(stk.nextToken());
			int math = Integer.parseInt(stk.nextToken());
			
			std[i] = new grade(name, kor, eng, math);
		}
		
		Arrays.sort(std, new Comparator<grade>() {

			@Override
			public int compare(grade o1, grade o2) {
				// 국어 점수가 같으면  영어 오름차순
				if(o1.korean == o2.korean) {
					
					// 국어 , 영어 점수가 같으면 수학 내림차순
					if(o1.english == o2.english) {
						
						// 모든 점수가 같으면 사전 순 
						if(o1.math == o2.math) {
							return (o1.name).compareTo(o2.name);
						}
						return o2.math - o1.math;
					}
					return o1.english-o2.english;	
				}
				// 국어 점수가 감소하는 순서
				return o2.korean - o1.korean;
			}
			
		});
		
		for(grade value : std) {
			System.out.println(value.name);
		}
	}
}

class grade {
	String name;
	int korean, english, math;
	
	grade(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}