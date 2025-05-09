import java.util.HashMap;
public class ManyGift {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> friend = new HashMap<>();  // 친구 이름 담기(검색 빠르게 하기 위함)
        for(int i = 0; i < friends.length; i++) {
            friend.put(friends[i], i);  // i가 그 값이 들어잇는 인덱스가 됨
        }

        int[][] sendRecived = new int[friends.length][friends.length];    // 그 표..
        int[] sendCount = new int[friends.length];  // 선물 준 갯수
        int[] receivedCount = new int[friends.length];  // 받은 선물 갯수
        int[] giftIndex = new int[friends.length];  // 선물 지수 넣기
        int[] manyGiftName = new int[friends.length];   // 각자 선물 몇 개 받는지

        for(int i = 0; i < gifts.length; i++) {
            String[] name = gifts[i].split(" ");    // 0엔 선물 준 사람, 1엔 선물 받은 사람
            // 해당 인덱스의 값들 1씩 증가 시키기
            sendCount[friend.get((name[0]))]++;
            receivedCount[friend.get(name[1])]++;
            sendRecived[friend.get(name[0])][friend.get(name[1])]++;
        }

        for(int i = 0; i < friends.length; i++) {   // 선물 지수 넣기
            giftIndex[i] = sendCount[i] - receivedCount[i];
        }

        // 계산
        for(int i = 0; i < sendRecived.length; i++) {
            for(int j = 0; j < sendRecived[i].length; j++) {
                if(i != j) {
                    if(sendRecived[i][j] != 0) {    // 자기 자신끼리가 아니면서 선물을 주고 받았으면
                        if(sendRecived[i][j] > sendRecived[j][i]) { // i가 선물을 더 많이 줫으면
                            manyGiftName[i]++;   // i가 j에게 선물 하나 받음
                            sendRecived[j][i] = -1;
                        }
                        else if(sendRecived[i][j] < sendRecived[j][i]) {
                            manyGiftName[j]++;
                            sendRecived[i][j] = -1;
                        }
                    }
                    
                    if((sendRecived[i][j] == 0 && sendRecived[j][i] == 0) || sendRecived[i][j] == sendRecived[j][i]) {    // 주고 받은 수가 같다면
                        if(giftIndex[i] > giftIndex[j]) {   // i의 선물지수가 더 높으면
                            manyGiftName[i]++;
                        }
                        else if(giftIndex[i] < giftIndex[j]) {   // j의 선물지수가 더 높으면
                            manyGiftName[j]++;
                        }
                        else continue;
                    }
                }
            }
        }
        for(int a = 0; a < manyGiftName.length; a++) {
            if(answer < manyGiftName[a]) {
                answer = manyGiftName[a];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        int res = 0;

        ManyGift m = new ManyGift();
        res = m.solution(friends, gifts);
    }
}