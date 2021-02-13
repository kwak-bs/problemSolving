package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_1406 {
	// BOJ / 1406번 / 에디터 / 자료구조 / 실3
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Character> ll = new LinkedList<>();
		
		for(int i=0; i<str.length(); i++) {
			ll.add(str.charAt(i));
		}
		// 그냥 LinkedList로 풀면 시간초과뜸. ListIterator 인터페이스를 이용하자.
		ListIterator<Character> iter = ll.listIterator();
		
		// 초기 커서는 맨 뒤. 
		// next() : 리스트의 다음 요소를 반환하고, 커서(cursor)의 위치를 순방향으로 이동시킴.
		while(iter.hasNext()) {
			iter.next();
		}
		
		while(n-- > 0) {
			String command = br.readLine();
			char c [] = command.toCharArray();
			
			switch(c[0]) {
				case 'L' : 
					// 이 리스트를 반복자가 해당 리스트를 역방향으로 순회할 때 다음 요소를 가지고 있으면
					// true를 반환, 더 이상 다음 요소를 가지고 있지 않으면 false를 반환.
					if(iter.hasPrevious()) {
						// 리시트의 이전 요소를 반환하고, 커서 위치를 역방향으로 이동.
						iter.previous();
					}
					break;
					
				case 'D' :
					if(iter.hasNext()) {
						iter.next();
					}
					break;
					
				case 'B' :
					if(iter.hasPrevious()) {
						iter.previous();
						// remove()는 next() 혹은 previous()에 의해 반환된
						// 가장 마지막 요소를 리스트에서 제거함
						iter.remove();
					}
					break;
					
				case 'P' : 
					char subC = c[2];
					iter.add(subC);
					break;
			}
		}
		
		for(Character ans : ll) {
			sb.append(ans);
		}
		System.out.println(sb);
	}
}
