import java.util.ArrayList;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();    // 스타상일 때 앞의 점수 저장해놓는 용도
        
        String n = " ";  // 숫자 임시 저장하기
        for(String s : dartResult.split("")) {
            if(n.equals(" ") && (s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
                n = s;
                continue;
            }
            else {  // 비어 있지 않는데
                if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {  // 숫자면
                    n += s;
                    continue;
                }
                if(s.equals("S")) {
                    list.add(Integer.parseInt(n));
                }
                else if(s.equals("D")) {
                    list.add(Integer.parseInt(n) * Integer.parseInt(n));
                }
                else if(s.equals("T")) {
                    list.add(Integer.parseInt(n) * Integer.parseInt(n) * Integer.parseInt(n));
                }
            }
            if(list.size() == 3) {
                answer += list.get(0);
                list.remove(0);
            }

            if(s.equals("#")) { // 아차상이면
                if(list.size() >= 2) {
                    answer += list.get(0);  // 전 거 그냥 저장해주고
                    list.remove(0); // 아차상은 가장 최근 것만 바꾸기 때문에 ..
                }
                list.set(0, list.get(0) * (-1));    // -로 바꿔주기
            }
            else if(s.equals("*")) {
                if(list.size() == 2) {
                    answer += list.get(0) * 2;
                    list.remove(0);
                }
                list.set(0, list.get(0) * 2);
            }

            n = " ";
        }
        
        if(!list.isEmpty()) {
            for(int i = 0; i < list.size(); i++) {
                answer += list.get(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String dartRe = "1S2D*3T";
        int res = 0;

        DartGame d = new DartGame();
        res =d.solution(dartRe);
    }
}