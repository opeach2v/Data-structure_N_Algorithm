public class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        int count = 0;
        String s = "";
        String compS = "";
        
        for(int i = 0; i < babbling.length; i++) {
            if(babbling[i].length() == 1) { // 길이 1인 발음은 없다.
                continue;
            }
            else {
                if(babbling[i].equals("aya") || babbling[i].equals("ye") 
                    || babbling[i].equals("woo") || babbling[i].equals("ma")) {
                    answer++;
                }
                else {
                    String[] str = babbling[i].split("");
                    while(count < babbling[i].length()) {
                        if(str[count].equals("a") && (babbling[i].length() - count) >= 3 && !s.equals("aya")) {    // "aya"
                            s = "";
                            for(int j = count; j < count + 3; j++) {
                                s += str[j];
                            }
                            if(s.equals("aya")) {
                                count += 3;
                                compS += s;
                                continue;
                            }
                            else break;
                        }
                        if(str[count].equals("y") && (babbling[i].length() - count) >= 2 && !s.equals("ye")) {    // "ye"
                            s = "";
                            for(int j = count; j < count + 2; j++) {
                                s += str[j];
                            }
                            if(s.equals("ye")) {
                                count += 2;
                                compS += s;
                                continue;
                            }
                            else break;
                        }
                        if(str[count].equals("w") && (babbling[i].length() - count) >= 3 && !s.equals("woo")) {    // "woo"
                            s = "";
                            for(int j = count; j < count + 3; j++) {
                                s += str[j];
                            }
                            if(s.equals("woo")) {
                                count += 3;
                                compS += s;
                                continue;
                            }
                            else break;
                        }
                        if(str[count].equals("m") && (babbling[i].length() - count) >= 2 && !s.equals("ma")) {    // "ma"
                            s = "";
                            for(int j = count; j < count + 2; j++) {
                                s += str[j];
                            }
                            if(s.equals("ma")) {
                                count += 2;
                                compS += s;
                                continue;
                            }
                            else break;
                        }
                        else {
                            break;
                        }
                    }
                    if(babbling[i].equals(compS) || babbling[i].equals(compS) 
                        || babbling[i].equals(compS) || babbling[i].equals(compS)) {    // 만들어진 s와 같다면
                        answer++;
                    }
                    compS = "";
                    s = "";
                    count = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int res = 0;

        Babbling b = new Babbling();
        res = b.solution(babbling);
    }
}