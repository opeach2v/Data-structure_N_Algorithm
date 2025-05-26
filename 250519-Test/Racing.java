import java.util.HashMap;

public class Racing {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> player = new HashMap<>();
        int i = 0;  // 1등부터 ...(인덱스는 0부터..)
        for(String s : players) {
            player.put(s, i);
            i++;
        }

        for(i = 0; i < callings.length; i++) {
            if(player.containsKey(callings[i])) {   // 해당 키 찾아서
                String temp = players[player.get(callings[i])]; // 해당 인덱스 키의 값을 가지고
                player.put(callings[i], player.get(callings[i]) - 1);   // 등수도 바꿔주고
                players[player.get(callings[i])] = players[player.get(callings[i]) - 1];
                player.put(players[player.get(callings[i]) - 1], player.get(players[player.get(callings[i]) - 1]) + 1);
                players[player.get(callings[i])] = temp;    // 추월 시키고 
            }
        }

        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] res = {};

        Racing r = new Racing();
        res = r.solution(players, callings);
    }
}