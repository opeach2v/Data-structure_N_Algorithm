public class DivString {
    public int solution(String s) {
        int answer = 0;
        String[] sSplit = s.split("");
        String oneString = sSplit[0];   // 초기 비교 대상
        int sameStrCount = 1;  // oneString과 같을 때 카운트
        int diffStrCount = 0;  // 다를 때 카운트

        if(s.length() == 1) {
            return 1;
        }

        for(int i = 1; i < s.length(); i++) {
            if(oneString.equals(sSplit[i])) {   // 같으면 
                sameStrCount++;
            }
            else {
                diffStrCount++;
            }
            if(sameStrCount == diffStrCount) {  // 둘이 같아지면
                i++;
                if(i != s.length()) {
                    oneString = sSplit[i];  // 비교 대상 바꾸기(문자열 분리했다고 생각)
                    sameStrCount = 1;
                    diffStrCount = 0;   // 카운트 초기화
                    if(i == s.length() - 1) {   // 여기 들어와서 비교 대상이 문자열 길이와 같으면 한 번 더 분리된다고 생각하고
                        answer++;
                    }
                }
                answer++;
            }
            else if(sameStrCount != diffStrCount && i == s.length() - 1) {  // 두 횟수가 다른데 더 읽을 글자가 없음
                answer++;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abcde";
        int res = 0;

        DivString d = new DivString();
        res = d.solution(s);
    }
}