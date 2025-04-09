public class BaboKeyborad {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length]; // targets 배열 만큼 결과가 있어야 함
        int result = 0; // count값 계속 저장함

        for(int i = 0; i < targets.length; i++) { //단어 하나씩 비교
            String[] tarS = targets[i].split("");   // 문자 단위로 비교하기 위해서
            for(int j = 0; j < tarS.length; j++) {
                int count =- 1;
                for(int b = 0; b < keymap.length; b++){  // keymap에 들어 있는 단어랑 비교
                    int c = 0;
                    if(count == -1){ //아직 같은 문자를 찾지 못했으면
                        for(String tarS : keymap[j].split("")){//이제 문자 하나씩 keymap위치 어디가 가까운지 비교//A,B,A,C,D
                            c++;
                            if(key_str.equals(str)){ //만약 keymap의 문자가 같으면 count에 저장
                                count = c;
                                break;
                            }
                        } //break로 탈출

                    }else{ //같은문자 찾았었으면
                        for(String key_str:keymap[j].split("")){
                            c++;
                            if(c>=count){
                                break;
                            } //이미 count보다 j가 더 늘어나면 break;
                            if(key_str.equals(str)){
                                count=c;
                            }
                        } //여기 break로 나옴
                    } //문자 하나 비교
                } //keymap에 있는 단어랑 targets 문자 하나랑 비교 끝

                if(count == -1){
                    result =- 1;
                    break;
                }
                else {
                    result += count;
                }

            }
            answer[i] = result;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        int[] result = {};

        BaboKeyborad babo = new BaboKeyborad();
        result = babo.solution(keymap, targets);

        System.out.print(result);
    }
}