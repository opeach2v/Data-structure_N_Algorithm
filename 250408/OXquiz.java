public class OXquiz {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] qna = {};
        int op = 0;
        String a = "";
        String b = "";
        String re = "";
        
        for(int i = 0; i < quiz.length; i++) {  // 퀴즈 문제 수만큼
            qna = quiz[i].split("=");   // = 을 기준으로 나눔 (그럼 식과 답으로 나뉨)
            // 식 쪽 계산
            for(int j = 0; j < qna[0].length(); j++) {
                if(!((qna[0].charAt(j) >= '0' && qna[0].charAt(j) <= '9') || qna[0].charAt(j) == '-')) {    // 식이 숫자가 아니면(op라는 뜻)
                    op = j + 1; // 숫자 뒤 공백 한 번 뛰어넘고 같이 저장
                    break;
                }
            }
            // 답 쪽 계산
            for(int k = 1; k < qna[1].length(); k++) {
                re += qna[1].charAt(k); // 답 넣기
            }

            for(int g = 0; g < op - 1; g++) {   //
                a += qna[0].charAt(g);   // op 앞 쪽 숫자 넣어주기
            }
            for(int g = op + 1; g < qna[0].length(); g++) {
                b += qna[0].charAt(g);    // op 뒤 쪽 숫자 넣어주기
            }

            String c = "";
            c += qna[0].charAt(op);
            switch(c.charAt(0)) {
                case '+':
                    if(Integer.parseInt(a) + Integer.parseInt(b.trim()) == Integer.parseInt(re)) {  // 식이 성립하면
                        answer[i] = "O";
                    }
                    else {
                        answer[i] = "X";
                    }
                    break;
                case '-':
                    if(Integer.parseInt(a) - Integer.parseInt(b.trim()) == Integer.parseInt(re)) {  // 식이 성립하면
                        answer[i] = "O";
                    }
                    else {
                        answer[i] = "X";
                    }
                    break;
                default:
                    break;
            }
            a = "";
            b = "";
            re = "";
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] quiz = {"-58 - 9999 = -10059", "3 - 1 = 2"};
        String[] result = {};

        OXquiz ox = new OXquiz();
        result = ox.solution(quiz);

        System.out.println(result);
    }
}
