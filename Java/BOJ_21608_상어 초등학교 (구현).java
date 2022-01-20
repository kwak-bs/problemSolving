package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21608 {
	// BOJ / 21608번 / 상어 초등학교 / 구현  / 실버1
	static int n, map[][], like[][], max1, max2, answer;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static ArrayList<student> condition1;
	static ArrayList<student> condition2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		answer = 0;
		init();
		calSatisfaction();
		System.out.println(answer);
	}
	
	public static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		like = new int[(n*n) + 1][4];
		StringTokenizer stk;
		for(int i=0; i<n*n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int student = Integer.parseInt(stk.nextToken());
			for(int j=0; j<4; j++) {
				like[student][j] = Integer.parseInt(stk.nextToken());
			}
			setStudent(student, like[student]);
		}
	}
	
	public static void calSatisfaction() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int st = map[i][j];
				int count = 0;
				for(int k=0; k<4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(!isRange(nr, nc)) continue;
					
					int nearSt = map[nr][nc];
					for(int l=0; l<4; l++) {
						if(nearSt == like[st][l]) count++;
					}
				}
				int temp = count == 10 ? 0 : (int)Math.pow(10, count-1);
				answer+= temp;
			}
		}
	}
	
	public static void setStudent(int student, int[] like) {
		
		condition1 = new ArrayList<>();
		condition2 = new ArrayList<>();

		max1 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] != 0) continue;
				checkCondition1(i,j, like);
			}
		}
		// 조건 1에서 충족 됐으면 학생 앉히고 리턴.
		if(condition1.size() == 1) {
			int r = condition1.get(0).r;
			int c = condition1.get(0).c;
			map[r][c] = student;
			return;
		}
		// 조건 2 검사
		max2 = 0;
		for(student st : condition1) {
			checkCondition2(st.r, st.c);
		}
		
		// list는 어차피 행과 열 오름차순으로 정렬 되므로, list에 저장되어 있는 조건 2의 갯수는 조건 3을 만족한 상태이다. 
		// 그냥 첫 번째 인덱스 삽입해주면된다. 
		int r = condition2.get(0).r;
		int c = condition2.get(0).c;
		map[r][c] = student;
	}
	
	public static void checkCondition2(int r, int c) {
		
		int count = 0;
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			
			if(!isRange(nr,nc)) continue;
			if(map[nr][nc] == 0 ) count++;
		}
		
		if(max2 < count) {
			max2 = count;
			condition2.clear();
			condition2.add(new student(r, c));
		}
		else if(max2 == count) {
			condition2.add(new student(r, c));
		}
	}
	public static void checkCondition1(int r, int c, int[] like) {
		
		int count = 0;
		
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			if(!isRange(nr,nc)) continue;
			for(int j=0; j<4; j++) {
				if(map[nr][nc] == like[j]) {
					count++;
					break;
				}
			}
		}
		
		if(max1 < count) {
			max1 = count;
			condition1.clear();
			condition1.add(new student(r,c));
		}
		else if(max1 == count) {
			condition1.add(new student(r,c));
		}
	}
	
	public static boolean isRange(int r, int c) {
		
		if(r >=0 && r<n && c>=0 && c<n) {
			return true;
		}
		return false;
	}
	
	private static class student implements Comparable<student>{
		int r,c;
		
		public student(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(student o) {
			
			if(this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}
	}
}
