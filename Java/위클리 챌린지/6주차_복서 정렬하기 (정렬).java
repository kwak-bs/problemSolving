package problemSolve6;

import java.util.Arrays;
import java.util.Comparator;

public class PM_85002 {
	// PM / 85002�� / ��Ŭ�� ç���� / ���� / 6����
	public static void main(String[] args) {
		
		int[] weights = {50,82,75,120};
		String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
		solution(weights, head2head);
	}
	
    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        
        info[] scores = new info[weights.length];
        
        scores = setScores(scores, weights, head2head);
        scores = sortScores(scores);
        
        for(int i=0; i<scores.length; i++) {
        	answer[i] = scores[i].player;
        }
        return answer;
    }
    
    public static info[] sortScores(info[] scores) {
    	
    	Arrays.sort(scores, new Comparator<info>() {
			@Override
			public int compare(info o1, info o2) {
				// �·��� ������ 
				if(o1.winRate == o2.winRate) {

					// ���ſ� ������ �̱� ȸ���� ������ 
					if( o1.weightWin == o2.weightWin) {
						// �����Ե� ������ 
						if(o1.weight == o2.weight) {
							return o1.player - o2.player;
						}
						return o2.weight - o1.weight;
					}
					return o2.weightWin - o1.weightWin;
				}
				// double�� ����� int������ ��ȯ
				if(o2.winRate - o1.winRate < 0) {
					return -1;
				}
				else if(o2.winRate - o1.winRate > 0) {
					return 1;
				}
				return 0;
			}
    	});
    	
    	return scores;
    }
    
    public static info[] setScores(info[] scores, int[] weights, String[] head2head) {
        for(int i=0; i<head2head.length; i++) {
        	double win=0.0; // �̱� Ƚ�� 
        	double total=0.0; // �̱�� �� �� Ƚ�� (N ����)
        	double winRate=0.0; // �·� 
        	int weightWin = 0; // ���ſ� ������ �̱� Ƚ�� 
        	int weight = weights[i]; // �ڱ� ������ 
        	int player = i+1; // �ڱ� ��ȣ 
        	char status; // N, W, L ����
        	for(int j=0; j<head2head[i].length(); j++) {
        		if(i == j) continue;
        		
        		status = head2head[i].charAt(j);
        		if(status == 'W' || status == 'L') total++;
        		if(status == 'W') {
        			win++;
        			if(weight < weights[j]) weightWin++;
        		}
        	}
        	if(total != 0.0) {
        		winRate = win / total ;
        	}
        	scores[i] = new info(player, winRate, weightWin, weight);
        }
    	return scores;
    }

    static class info {
    	int player, weightWin, weight;
    	double winRate;
    	public info(int player, double winRate, int weightWin, int weight) {
    		this.player = player;
    		this.winRate = winRate;
    		this.weightWin = weightWin;
    		this.weight = weight;
    	}
    }
}
