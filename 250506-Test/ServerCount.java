import java.util.ArrayList;

public class ServerCount {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        ArrayList<Integer> currentServer = new ArrayList<>(); // 각 시간마다 한 번에 생성된 서버 갯수
        ArrayList<Integer> serverTime = new ArrayList<>();  // 각 서버마다 흘러가는 시간
        int serverCount = 0;    // 현재의 서버 갯수

        for(int i = 0; i < players.length; i++) {
            if(!serverTime.isEmpty()) {
                for(int j = 0; j < serverTime.size(); j++) {
                    serverTime.set(j, serverTime.get(j) + 1);   // 1초씩 추가
                    if(serverTime.get(j) > k) {    // k인 게 있으면
                        serverCount -= currentServer.get(j);
                        currentServer.remove(j);
                        serverTime.remove(j);
                        j--;
                    }
                }
            }

            if(players[i] >= m) {
                if(serverCount != 0) {
                    if(serverCount < players[i] / m) {
                        currentServer.add((players[i] / m) - serverCount); // k시간만큼 유지될 서버 개수
                        serverTime.add(1);  // 시간 1초부터
                        answer += (players[i] / m) - serverCount;   // 증설 총 횟수
                        serverCount += (players[i] / m) - serverCount;
                    }
                }
                else {  // 증설되어있는 서버가 없으면
                    currentServer.add(players[i] / m);
                    serverTime.add(1);
                    serverCount = players[i] / m;
                    answer += players[i] / m;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        int res = 0;

        ServerCount s = new ServerCount();
        res = s.solution(players, m, k);
    }
}