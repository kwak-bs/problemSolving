package problemSolve5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class song implements Comparable<song> {
    int no;
    String genre;
    int play;
    public song(int no, String genre, int play) {
        this.no = no;
        this.genre = genre;
        this.play = play;
    }
    
    @Override 
    public int compareTo(song o) {

        // 재생 횟수가 같으면 번호 오름차순
        if(this.play == o.play) {
            return this.no - o.no;
        }
        // 다르면 재생 횟수 내림 차순
        return o.play - this.play;

    }
}
public class PM_42579 {
	// PM / 42579번 / 베스트앨범 / 해쉬, 정렬 / Level3
	public static void main(String[] args) {
		
		solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});

	}
    public static int[] solution(String[] genres, int[] plays) {
        
        HashMap<String,Integer> genreList = new HashMap<>();
        HashMap<String, Integer> genreChk = new HashMap<>();
        ArrayList<song> songList = new ArrayList<>();
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++) {
            genreList.put(genres[i], genreList.getOrDefault(genres[i], 0)+plays[i]);
        }

        for(int i=0; i<genres.length; i++) {
            songList.add(new song(i, genres[i], plays[i]));
        }
    
        Collections.sort(songList, new Comparator<song>() {
            @Override
            public int compare(song s1, song s2) {
                // 장르가 같으면 compareTo 메소드로 
                if(s1.genre.equals(s2.genre)) {
                    return s1.compareTo(s2);
                }
                // 장르가 다르면 장르별 총 재생횟수 내림차순
                else {
                    return -(genreList.get(s1.genre) - genreList.get(s2.genre));
                }
            }
        });
        // 장르별 2개씩만 베스트엘범에 넣어준다.
        for(song s : songList) {
            if(genreChk.containsKey(s.genre)&&genreChk.get(s.genre) == 2) continue;
            genreChk.put(s.genre, genreChk.getOrDefault(s.genre, 0)+1);
            
            bestAlbum.add(s.no);
        }
        int [] answer = new int[bestAlbum.size()];
        for(int i=0; i<bestAlbum.size(); i++) {
            answer[i] = bestAlbum.get(i);
        }
        return answer;
    }
}
