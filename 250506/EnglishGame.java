import java.util.HashMap;

public class EnglishGame {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] turn = new int[n + 1];    // 해당 사람의 번호(인덱스)와 차례 저장(값)
        int count = 0;  // n번까지

        // 나중에 겹치는 단어 있는지 찾기 위한..
        HashMap<Integer, String> word = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            word.put(i, words[i]); // 순서대로 넣기
        }

        for(int i = 0; i < words.length; i++) {
            count++;
            turn[count]++;  // 차례대로 차례 증가
            if(count == 1 && turn[count] == 1) continue;    // 첫 번째 차례면 다음으로 넘어가기 (비교할 게 없음)
            for(int j = 0; j < i; j++) {    // 지금 차례 전까지 돌면서
                if(word.get(j).equals(words[i])) {    // 그 전에 말한 단어 중에 지금 단어랑 같은 게 있다면
                    answer[0] = count;
                    answer[1] = turn[count];
                    return answer;
                }
            }
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) { // 맨 뒷 글자와 앞 글자가 이어지지 않으면
                answer[0] = count;
                answer[1] = turn[count];
                return answer;
            }
            if(count == n) {    // 끝 사람까지 다 했으면 카운트 초기화
                count = 0;
            }
        }
        // 여기 나왔다는 건 끝말잇기가 무사히 끝났다는 것
        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }
    
    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] res = {};

        EnglishGame e = new EnglishGame();
        res = e.solution(n, words);
    }
}