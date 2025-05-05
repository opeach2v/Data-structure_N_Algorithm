import java.util.ArrayList;
import java.util.HashMap;

public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] reportNum = new int[id_list.length];  // 신고 당한 횟수(id_num의 이름이랑 순서 같음)
        ArrayList<String> stopId = new ArrayList<>();   // 정지된 아이디 저장되는 곳
        HashMap<String, Integer> idList = new HashMap<>();  // 아이디(key), 인덱스(value)로 저장됨
        HashMap<String, Integer> reportList = new HashMap<>();  // 중복으로 신고된 거 잡아내기
        
        // hashmap에 저장
        for(int i = 0; i < id_list.length; i++) {
            idList.put(id_list[i], i);
        }
        for(int i = 0; i < report.length; i++) {
            reportList.put(report[i], 1);   // 값이 똑같으면 중복처리 돼서 1개만 저장됨
        }

        report = new String[reportList.size()]; // 초기화하고
        int idx = 0;
        for(String s : reportList.keySet()) {    // 다시 넣어줌
            report[idx] = s;
            idx++;
        }

        for(int i = 0; i < report.length; i++) {
            String[] reportId = report[i].split(" ");   // 0번 인덱스는 신고한 사람, 1번 인덱스가 신고당한 사람
            reportNum[idList.get(reportId[1])]++;   // 신고당한 사람의 신고 당한 횟수++
            if(reportNum[idList.get(reportId[1])] == k) {   // 신고 당한 횟수가 k만큼 되면
                stopId.add(reportId[1]);    // 정지당한 아이디가 저장됨
            }
        }
        
        if(stopId.size() != 0) {    // 정지당한 아이디가 있으면
            // 정지 당한 아이디를 신고한 사람에게 알림 주기
            for(int i = 0; i < report.length; i++) {    // 신고 내역 돌면서
                String[] reportId = report[i].split(" ");   // 0번 인덱스는 신고한 사람, 1번 인덱스가 신고당한 사람
                for(int j = 0; j < stopId.size(); j++) {
                    if(reportId[1].equals(stopId.get(j))) { // 신고 내역에 정지당한 아이디 중에 있으면 
                        answer[idList.get(reportId[0])]++;  // 신고한 사람 횟수++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; 
        int k = 3;
        int[] res = {};

        ReportResult r = new ReportResult();
        res = r.solution(id_list, report, k);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] +" ");
        }
    }
}