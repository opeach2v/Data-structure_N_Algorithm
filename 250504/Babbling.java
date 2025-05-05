public class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        String str = "";
        int count = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            if(babbling[i].length() == 1) { // 길이 1인 발음은 없다.
                continue;
            }
            else {
                if(babbling[i].startsWith("a")) {   // a로 시작하면
                    count = 3;
                    for(int a = 0; a < count; a++) {
                        str += String.valueOf(babbling[i].charAt(a));
                    }
                    if(!str.equals("aya")) {
                        
                    }
                }
            }
        }

        return answer;
    }
}