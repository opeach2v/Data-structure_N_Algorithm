import java.util.ArrayList;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        int sum = 0;    // 각 영역 점수 더하고 결과에 넣기 위한..
        int sumNum = 0; // 각 영역 점수
        String num = "";    // 각 영역의 정수 넣기(10일 경우가 있어서 ㅠ)
        ArrayList<Integer> score = new ArrayList<>(); // 스타상을 위해 해당 영역과 전 점수 계산을 위한
        String[] darts = dartResult.split("");

        for(int i = 0; i < darts.length; i++) {
            num += darts[i];
            if(num.length() == 1) i++;
            if(darts[i].charAt(0) == '0') { // 아직 두 번째가 0이면 정수가 10이라는 소리
                num += darts[i];
                i++;    // i 한번 증가
            }
            // 본격 계산 시작
            if(darts[i].equals("S")) {    // 싱글(1제곱)
                sum = Integer.parseInt(num);   // 숫자 넣기
            }
            else if(darts[i].equals("D")) {    // 더블(2제곱)
                sumNum = Integer.parseInt(num);   // 숫자 넣기
                sum = Integer.parseInt(num);
                sum *= sumNum;
            }
            else if(darts[i].equals("T")) {    // 트리플(3제곱)
                sumNum = Integer.parseInt(num);   // 숫자 넣기
                sum = Integer.parseInt(num);
                for(int j = 0; j < 2; j++) { // 3번 돌기
                    sum *= sumNum;
                }
            }

            score.add(sum); // 일단 점수 넣어놓고
            // 스타상, 아차상에 따른 점수 증감
            if((i != darts.length - 1) && darts[i + 1].equals("*")) {  // 맨 끝이 아니면서 스타상
                i++;
                if(score.size() == 2) { // 2개의 점수 들어 있으면
                    for(int s = 0; s < 2; s++) {
                        score.set(s, score.get(s) * 2); // 그 전 점수까지 2배로 변경
                    }
                    // 그 전 점수는 더해주고 지우기
                    answer += score.get(0);
                    score.remove(0);
                }
                else {
                    score.set(0, score.get(0) * 2);    // 해당 점수만 2배 변경
                }
            }
            else if((i != darts.length - 1) && darts[i + 1].equals("#")) {  // 맨 끝이 아니면서 아차상이면
                i++;
                if(score.size() == 2) { // 2개 점수 들어있으면
                    score.set(score.size() - 1, score.get(score.size() - 1) * (-1));    // 마지막 거만 -로 바꿔주고
                    
                    answer += score.get(0);
                    score.remove(0);    // 전 점수는 더해주고 삭제
                }
                else score.set(score.size() - 1, score.get(score.size() - 1) * (-1));    // 마지막 거만 -로 바꿔주기
            }
            else {
                if(score.size() == 2) {
                    answer += score.get(0);
                    score.remove(0);
                }
            }

            sum = 0;    // 초기화
            num = "";   // 정수도 초기화
        }

        if(score.size() != 0) { // 만약 마지막 값이 남아있으면 마저 더해주기
            for(int i = 0; i < score.size(); i++) {
                answer += score.get(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String dart = "1D2S3T*";
        int res = 0;

        DartGame d = new DartGame();
        res = d.solution(dart);

        System.out.println(res);
    }
}