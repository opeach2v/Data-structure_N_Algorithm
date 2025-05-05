import java.util.HashMap;

public class NoCompletion {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participants = new HashMap<>();

        // 해시값으로 넣어놓기
        for(String name : participant) {
            participants.put(name, participants.getOrDefault(name, 1) + 1);   // 중복 값 나올 시 value 증가
        }

        for(String compName : completion) {
            if(participants.containsKey(compName)) {    // 도착 명단에 존재하면
                participants.put(compName, participants.getOrDefault(compName, 1) - 1);
                int count = participants.getOrDefault(compName, 1) - 1;
                if(count == 0) {    // 카운트가 0이면 삭제 하기
                    participants.remove(compName);
                }
            }
        }

        for(String name : participants.keySet()) {
            answer = name;
        }

        return answer;
    }
}