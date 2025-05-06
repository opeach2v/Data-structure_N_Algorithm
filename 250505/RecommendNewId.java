import java.util.ArrayList;

public class RecommendNewId {
    public String solution(String new_id) {
        String answer = "";

        ArrayList<String> newId = new ArrayList<>();
        for(String s : new_id.split("")) {
            newId.add(s);   // 리스트에 하나하나 분해해서 넣어줌
        }

        // 1단계) 모든 대문자를 대응하는 소문자로 치환
        for(int i = 0; i < newId.size(); i++) {
            char c = (newId.get(i)).charAt(0);  // 대문자 비교 후 소문자 변경용
            if(c >= 'A' && c <= 'Z') {    // 대문자면
                c += 32;    // 소문자로 변경
                newId.remove(i);    // 해당 인덱스는 삭제하고
                newId.add(i, String.valueOf(c));    // 해당 인덱스에 다시 넣기
            }
        }

        // 2단계) 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제외
        for(int i = 0; i < newId.size(); i++) {
            char c = (newId.get(i)).charAt(0);  // 비교용
            if(!(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9') && (c != '-') && (c != '_') && (c != '.')) { // 모두 아닐 시엔
                newId.remove(i);    // 해당 인덱스 삭제
                i--;
            }
        }
        
        // 3단계) 마침표(.)가 2번 이상 연속되면 하나의 마침표(.)로 치환
        int count = 0;  // 마침표 개수 세기
        for(int i = 0; i < newId.size(); i++) {
            char c = (newId.get(i)).charAt(0);  // 마침표 찾기용
            if(c == '.') {  // 마침표면
                count++;
                if(count == 2) {
                    newId.remove(i);    // 마지막 마침표 지우기
                    count--;    // 카운트 하나 삭제
                    i--;
                }
            }
            else {
                count = 0;  // 마침표 뒤에 다른 게 오면 카운트 초기화
            }
        }

        // 4단계) 마침표(.)가 처음이나 끝에 위치하면 제거
        if(newId.size() != 0) {
            if((newId.get(0)).charAt(0) == '.') {   // 처음이 마침표면
                newId.remove(0);
            }
        }
        if(newId.size() != 0) {
            if((newId.get(newId.size() - 1)).charAt(0) == '.') {    // 마지막이 마침표면
                newId.remove(newId.size() - 1);
            }
        }

        // 5단계) 빈 문자열이면 new_id에 a대입
        if(newId.size() == 0) { // 비었으면
            newId.add("a");
        }

        // 6단계) 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자 제거하기
        if(newId.size() >= 16) { // 16자 이상이라면
            while(newId.size() >= 16) {
                newId.remove(newId.size() - 1);
            }
        }
        // 만약 다 제거하고 나서 끝이 마침표면 제거
        if((newId.get(newId.size() - 1)).charAt(0) == '.') {
            newId.remove(newId.size() - 1);
        }

        // 7단계) 아이디 길이가 2자 이하라면 마지막 문자를 아이디 길이가 3이 될 때까지 반복해서 끝에 붙임
        if(newId.size() <= 2) {
            String s = newId.get(newId.size() - 1); // 마지막 문자 추출
            while(true) {
                newId.add(s);   // 추가
                if(newId.size() == 3) { // 3이 되면 빠져나가기
                    break;
                }
            }
        }

        // 문자열에 붙여서 리턴시키기
        for(int i = 0; i < newId.size(); i++) {
            answer += newId.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String new_id = "=.=";
        String res = "";

        RecommendNewId r = new RecommendNewId();
        res = r.solution(new_id);
    }
}