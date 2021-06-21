package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1655 {
	// BOJ / 1655번 / 가운데를 말해요 / 구현, 힙 / 골드2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			// 두 힙의 사이즈가 같으면 maxHeap에 추가.
			// 입력 값이 minHeap의 최솟값(peek)보다 크면 두 값을 swap
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.add(num);
			}
			// 두 힙의 사이즈가 다르면 minHeap에 추가 
			// 입력 값이 maxHeap의 최댓값(peek)보다 작으면 두 값을 swap
			else {
				minHeap.add(num);
			}
			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(tmp);
				}
			}
			// maxHeap의 top에 위치한 값이 중간값이 되게 한다. 
			sb.append(maxHeap.peek()+"\n");
		}
		System.out.println(sb);
	}
}
