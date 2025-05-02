import java.util.HashMap;

public class Racing {
    public String[] solution(String[] players, String[] callings) {
        HashMap<Integer, String> player = new HashMap<Integer, String>();

        for(int i = 0; i < players.length; i++) {
            player.put(i, players[i]);  // key 값은 숫자로 0부터, value는 players 배열 값으로
        }

        // 순위 바뀌는 부분
        for(int i = 0; i < callings.length; i++) {
            if(player.containsValue(callings[i])) { // 불린 이름을 찾아서 같으면
                String temp = player.get(i);    // 일단 해당 값 저장해두고
                player.replace(i - 1, temp);    // 음.. 이렇게 하면 안 되는데 ㅠㅠ
            }
        }
        
        return players;
    }

    public static void main(String[] args) {
        String[] player = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] res = {};

        Racing r = new Racing();
        res = r.solution(player, callings);
    }
}