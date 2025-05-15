import java.util.ArrayDeque;
import java.util.Deque;

public class SortingOnTheWay {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Deque<String> stack = new ArrayDeque<>();

        for(int i = 0; i < strings.length - 1; i++) {
            if(strings[i].charAt(n) < strings[i + 1].charAt(n)) {   // 만약 앞 쪽의 문자가 더 작다면 위치 바꾸기
                String temp = strings[i];
                strings[i + 1] = strings[i];
                strings[i] = temp;
            }
        }
        
        return answer;
    }
}