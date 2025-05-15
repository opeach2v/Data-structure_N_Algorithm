import java.util.HashMap;

public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> score = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);    // 각 사람과 해당 추억 점수
        }

        for(int i = 0; i < photo.length; i++) {
            for(int j = 0; j < photo[i].length; j++) {
                if(score.containsKey(photo[i][j])) {    // name에 존재하면
                    answer[i] += score.get(photo[i][j]);    // 해당 추억 점수 저장
                }
            }
        }

        return answer;
    }
}