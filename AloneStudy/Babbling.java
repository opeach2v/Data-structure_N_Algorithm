public class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        int count = 0;

        for(int i = 0; i < babbling.length; i++) {
            // 딱 이 단어들만 있을 때의 비교
            if(babbling[i].equals("aya") || babbling[i].equals("ye")
                || babbling[i].equals("woo") || babbling[i].equals("ma")) {
                answer++;
            }
            else {  // 다른 단어들과 조합됐을 때의 비교
                count = babbling[i].length();
                while(count > 0) {
                    if(babbling[i].contains("aya")) {   // aya포함 돼있으면
                        count -= 3;
                    }
                    if(babbling[i].contains("ye")) {
                        count -= 2;
                    }
                    if(babbling[i].contains("woo")) {
                        count -= 3;
                    }
                    if(babbling[i].contains("ma")) {
                        count -= 2;
                    }
                    else {
                        break;
                    }
                }
                if(count == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int result = 0;

        Babbling b = new Babbling();
        result = b.solution(babbling);
    }
}

// 26분 30초 ~