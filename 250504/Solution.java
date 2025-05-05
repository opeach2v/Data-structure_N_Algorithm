class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String[] skipS = skip.split("");
        String[] abc = new String[index];
        char c;
        int a = 0;
        int count = 0;  // skip과 비교하고 쓸 것

        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c == 'z') {  // c가 z까지 왔으면 -31
                            c = 'a';
                        }
                        else {
                            c++;    // 알파벳 뒤로 1만큼 보냄
                        }
            int j = 0;
            while(j < skipS.length) {
                if(!Character.toString(c).equals(skipS[j])) {   // skip에 있는 알파벳이 아니라면
                    count++;
                    j++;
                    if(count == skipS.length) { // 둘이 같아지면 겹치는 문자가 없다는 거
                        abc[a] = Character.toString(c); // 하나씩 넣어줌.ex) a면 위에 ++해줬으니까 b부터 넣어지는 거.
                        a++;
                        if(c == 'z') {  // c가 z까지 왔으면 -31
                            c = 'a';
                        }
                        else {
                            c++;    // 해당 알파벳 건너뛰기
                        }
                        j = 0;
                        count = 0;
                        if(a == index) {    // a가 index랑 같아지면 빠져나가야 함
                            break;
                        }
                    }
                }
                else {  // skip에 있는 알파벳이 맞으면
                    if(Character.toString(c).equals("z")) {  // c가 z까지 왔으면 -31
                        c = 'a';
                    }
                    else {
                        c++;    // 해당 알파벳 건너뛰기
                    }
                    j = 0;
                    count = 0;
                }
            }
            answer += abc[index - 1];
            a = 0;
            count = 0;
        }

        return answer;
    }
}