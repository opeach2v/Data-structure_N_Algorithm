public class PushStr {
    public int solution(String A, String B) {
        int answer = 1;
        String[] as = A.split("");
        String temp = "";
        int count = 0;

        if(A.equals(B)) {    // 그냥 그 자체가 같으면
            return 0;
        }
        else {
            while(count <= A.length()) { // 다시 처음으로 돌아올 때까지 반복
                // 오른쪽으로 밀었을 때 (1)
                temp = as[as.length - 1];    // 맨 뒷 글자 저장
                for(int i = as.length - 1; i > 0; i--) {
                    as[i] = as[i - 1];  // 오른쪽으로 이동해서 저장
                }
                as[0] = temp;
                A = ""; // 문자열 비워주기
                count++;
                for(int i = 0; i < as.length; i++) {
                    A += as[i]; // 문자열로 만든 다음
                }
                if(A.equals(B)) {   // 비교: A랑 B랑 같으면 리턴해주고 나감
                    return answer;
                }
                else {
                    answer++;   // 한 번 더 돌려야 해서
                }
            }
            // 그냥 나왔다는 건 A와 B가 같아질 수 없다는 거라서
            return -1;
        }
    }
}