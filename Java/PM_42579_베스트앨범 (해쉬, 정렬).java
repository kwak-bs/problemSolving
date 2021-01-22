package problemSolve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PM_42579 {
	//PM(프로그래머스) / 42579번 / 베스트 앨범
	
	class Song implements Comparable<Song> {
		int id, play;
		String genre;
		
		public Song(int id, int play, String genre) {
			this.id = id;
			this.play = play;
			this.genre = genre;
		}
		
		// compareTo 재정의
		// 재생횟수가 같으면 id 오름차순
		@Override
		public int compareTo(Song o) {
			
			if(this.play == o.play) {
				return this.id - o.id;
			}
			// 다르면 재생횟수 내림차순
			else {
				return o.play - this.play;
			}
		}
	}
	public static void main(String[] args) {
		
		PM_42579 c = new PM_42579();
		
		String genres [] = {"classic","pop","classic","classic","pop"};
		int plays [] = {500,600,150,800,2500};
		
		c.solution(genres, plays);

	}
	
    public int[] solution(String[] genres, int[] plays) {

        
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, Integer> albumMap = new HashMap<>();
        
        // songList에 song객체 순서대로 넣어주고 genreMap에 장르별 play횟수 count.
        for(int i=0; i<genres.length; i++) {
        	int id = i;
        	int play = plays[i];
        	String genre = genres[i];
        	
        	songList.add(new Song(id, play, genre));
        	
        	if(genreMap.containsKey(genres[i])) {
        		genreMap.put(genre, genreMap.get(genre) + play);
        	}
        	else {
        		genreMap.put(genre, play);
        	}
        }
        
        Collections.sort(songList, new Comparator<Song>() {

			@Override
			public int compare(Song o1, Song o2) {
				// 장르가 같으면 Song에서 선언한 compareTo 메소드로 간다.
				// 즉, 같은 장르면 재생횟수 -> 고유번호 순으로 비교
				if(o1.genre.equals(o2.genre)) {
					return o1.compareTo(o2);
				}
				// 다른 장르면 map에 저장되어 있는 장르별 재생횟수 내림차순
				else {
					return -(genreMap.get(o1.genre) - genreMap.get(o2.genre));
				}
			}	
		});
        

        int count = 1;
        for(Song song : songList) {
        	// albumMap에 장르를 차례로 저장하고  bestAlbum에 index를 저장한다.
        	// albumMap에 들어간 장르의 갯수가 각각 2이면 해당 장르 저장을 멈추고 다음 장르로 넘어간다.
        	if(!albumMap.containsKey(song.genre)) {
        		albumMap.put(song.genre, 1);
        		bestAlbum.add(song.id);
        		
        	}
        	else {
        		if(albumMap.get(song.genre) == 2) {
        			continue;
        		}
        		albumMap.put(song.genre, albumMap.get(song.genre) + 1);
        		bestAlbum.add(song.id);
        	}
        }
        int[] answer = new int [bestAlbum.size()];

        for(int i=0; i<bestAlbum.size(); i++) {
        	answer[i] = bestAlbum.get(i);
        }
        
        // 정답 확인
        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
    

}
