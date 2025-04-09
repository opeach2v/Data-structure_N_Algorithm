public class Login {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        
        for(int i = 0; i < db.length; i++) {    // db 갯수 만큼 돌리기
            for(int j = 0; j < id_pw.length; j++) { // id랑 pw만큼 돌리기. 0은 아이디, 1은 비번
                if(id_pw[j].equals(db[i][j])) { // 아이디 존재하면
                    if(id_pw[j + 1].equals(db[i][j + 1])) { // 그 아이디의 비밀번호랑 비교했는데 있으면
                        answer = "login";   // 로그인 완
                        return answer;
                    }
                    else {  // 비번이 없으면
                        answer = "wrong pw";
                        return answer;
                    }
                }
                else {  // 아이디 존재 안 하면 다음 db로 넘어가야 함
                    break;
                }
            }
        }
        // 여기까지 왔다는 건 DB에도 없다는 뜻이라서 fail로 끝냄
        answer = "fail";
        return answer;
    }

    public static void main(String[] args) {
        String[] id_pw = {"meosseugi", "1234"};
        String[][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
        String result = "";

        Login l = new Login();
        result = l.solution(id_pw, db);

        System.out.println(result);
    }
}
