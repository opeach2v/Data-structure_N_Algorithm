public class BaboKeyboardRe {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i = 0; i < targets.length; i++) {   // 단어 하나씩 비교
            int result = 0; // count값 저장용
            for(String tarS : targets[i].split("")) {
                int count =- 1;
                for(int j = 0; j < keymap.length; j++) {    // keymap에 들어있는 단어랑 비교
                    int c = 0;
                    if(count == -1) {   // 아직 같은 문자 찾지 못했으면
                        for(String keyS : keymap[j].split("")) {
                            c++;
                            if(keyS.equals(tarS)) {
                                count = c;
                                break;
                            }
                        }
                    }
                    else {
                        for(String keyS : keymap[j].split("")) {
                            c++;
                            if(c >= count) {
                                break;
                            }   // 이미 count보다 c가 더 늘어나면 break
                            if(keyS.equals(tarS)) {
                                count = c;
                            }
                        }
                    }
                }
                if(count == -1) {
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
}
