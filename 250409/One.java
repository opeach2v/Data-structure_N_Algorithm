public class One {
    public String solution(String s) {
        String answer = "";
        int count = 0;

        String[] str = s.split("");
        char c = 'a';   // 비교할 알파벳
        
        while(c <= 'z') {   // 알파벳 끝까지 비교하기 전까지
            for(int i = 0; i < str.length; i++) {   // c랑 비교해서 몇 번 있는지
                if(str[i].equals(String.valueOf(c))) {  // true면
                    count++;
                }
            }
            if(count == 1) {
                answer += String.valueOf(c); // count가 한 개인 문자 넣기
            }
            else {
                count = 0;
                c += 1;
            }
        }

        return answer;
    }
}

// 7시 35분 ~ 50qns