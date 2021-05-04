package problemSolve5;

import java.util.Comparator;
import java.util.LinkedList;

public class PM_17683 {
	// PM / 17683번 / 방금그곡 / 구현, 문자열 / Level2 / 2018 카카오 블라인드 채용
	public void main(String[] args) {
		solution("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
	}
	
    public String solution(String m, String[] musicinfos) {
        String mem = convertedMelody(m);
        LinkedList<Music> musics = new LinkedList<>();
        
        for(int i=0; i<musicinfos.length; i++) {
            String[] t = musicinfos[i].split(",");
            Music music = new Music(i, getDiffSec(t[0], t[1]), t[2],
                                   convertedMelody(t[3]));
            // 기억한 멜로디 보다 기존 멜로디(구간 반복 포함)가 더 크고
            // 기억한 멜로디가 기존 멜로디에 포함되면 추가
            if(music.totalMelody.length() >= mem.length() &&
              music.totalMelody.contains(mem)) {
                musics.add(music);
            }
        }
        // 찾은 곡이 1개 이상일 경우
        if(musics.size() > 0) {
            musics.sort(new Comparator<Music>(){
                @Override
                public int compare(Music o1, Music o2) {
                    // 재생시간이 긴 순, 인덱스가 작은 순
                    if(o1.duration == o2.duration) {
                        return o1.idx - o2.idx;
                    }
                    return o2.duration - o1.duration;
                }
            });
            // 가장 앞에 있는 것이 답
            Music ans = musics.pollFirst();
            return ans.title;
        }
        else return "(None)"; // 곡이 검색되지 않은 경우
    }
    
    private int getDiffSec(String t1, String t2) {
        String time1[] = t1.split(":");
        String time2[] = t2.split(":");
        // 시가 같으면
        if(time1[0].equals(time2[0])) {
            return Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]);
        }
        int h = Integer.parseInt(time2[0]) - Integer.parseInt(time1[0]);
        return (60 * h + Integer.parseInt(time2[1])) - Integer.parseInt(time1[1]);
    }
    
    private String convertedMelody(String m) {
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        m = m.replaceAll("E#","e");
        return m;
    }
}

class Music {
    int idx; // 입력 순서
    int duration; // 재생 시간(분)
    String title; // 제목
    String totalMelody; // 재생시간에 따른 멜로디
    
    public Music(int idx, int duration, String title, String melody) {
        this.idx = idx;
        this.duration = duration;
        this.title = title;
        this.totalMelody = makeFullMelody(melody, this.duration);
    }
    
    private String makeFullMelody(String mel, int d) {
        // 틀어진 구간보다 기존 멜로디 구간이 더 크면 그냥 자름
        if(mel.length() >= d) {
            return mel.substring(0,d);
        }
        
        StringBuilder sb = new StringBuilder();
        // 틀어진 구간이 더 크면 기존 멜로디 구간을 계속 더함 
        while(sb.length() < d) {
            sb.append(mel);
        }
        // 반환할 때는 틀어진 구간까지만 반환
        return sb.toString().substring(0,d);
    }
}
