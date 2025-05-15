import java.util.HashMap;

public class Keyboard {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<String, Integer> key = new HashMap<>(); // 문자와 해당 문자를 치기 위해 최소로 몇 번을 눌러야 하는지 저장
        for(int i = 0; i < keymap.length; i++) {
            String[] str = keymap[i].split("");
            for(int j = 1; j <= str.length; j++) {
                if(!key.isEmpty() && key.containsKey(str[j - 1])) {    // key가 비어있지 않으면서
                    if(j < key.get(str[j - 1])) {   // 들어있는 key보다 누르는 횟수가 적으면
                        key.replace(str[j - 1], j); // 해당 횟수로 변경
                    }
                }
                else key.put(str[j - 1], j);
            }
        }

        for(int i = 0; i < targets.length; i++) {
            String[] str = targets[i].split("");
            for(int j = 0; j < str.length; j++) {
                if(key.containsKey(str[j])) {   // 키가 존재하면
                    answer[i] += key.get(str[j]);   // 해당 키 횟수 넣기
                }
                else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        int[] res = {};

        Keyboard k = new Keyboard();
        res = k.solution(keymap, targets);
    }
}