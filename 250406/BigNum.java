public class BigNum {
    public String solution(String number, int k) {
        String answer = "";
        int min = 0;
        String[] numS = number.split("");
        int[] saveIndex = new int[number.length() - k];  // 인덱스 저장 후 이걸로 잠시 저장해서 비교할..

        int count = 0;  // number.length - k 만큼 카운트 되면 끝나게 해야 함.
        int i = 0;
        int j = 0;
        while(count < k) {
            i = 0;
            while(i <= number.length() - k) {  // k만큼 제거 했을 때 남을 것을 예상
                for(j = 0; j < number.length(); j++) {
                    if(i == 6) {
                        break;
                    }
                    if(numS[saveIndex[i]].equals("")) {  // 비어있을 경우 한 번 건너뛰어서 저장
                        for(int a = 0; a < numS.length; a++) {
                            if(!numS[a].equals("")) {
                                saveIndex[i] = saveIndex[i + 1];
                                i++;
                            }
                            else {
                                j += 2;
                                break;
                            }
                        }
                    }
                    saveIndex[i] = j;
                    i++;
                }
                if(i == 6) {
                    i = 0;
                    break;
                }
            }
            for(i = 0; i < number.length() - k; i++) {
                if(Integer.parseInt(numS[saveIndex[i]]) < Integer.parseInt(numS[saveIndex[i + 1]])) {   // 첫 숫자가 다음 숫자보다 작을 경우
                    numS[saveIndex[i]] = numS[saveIndex[i]].replace(numS[saveIndex[i]], "");    // 그 숫자 없앰
                    count++;
                    break;
                }
                if(saveIndex[(number.length() - k) - 1] == number.length() - k) {   // 끝까지 왔을 때 카운트가 남아 있으면
                    if(count < k) { // 가장 작은 숫자를 삭제
                        min = saveIndex[0];
                        for(j = 1; j < number.length() - k; j++) {
                            if(Integer.parseInt(numS[min]) > Integer.parseInt(numS[saveIndex[j]])) {
                                int temp = min;
                                min = saveIndex[j];
                                saveIndex[j] = temp;    // 인덱스 바꾸기 (최종적으로 작은 값이 들은 인덱스가 min에 들어올 것)
                            }
                        }
                        // 최종적으로 가장 작은 값을 들은 인덱스의 값을 비우기
                        numS[min] = numS[min].replace(numS[min], "");
                        count++;
                        if(count == k) {
                            break;
                        }
                    }
                }
            }
        }

        for(i = 0; i < number.length(); i++) {
            if(!numS[i].equals("")) {
                answer += numS[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        String result = "";

        BigNum b = new BigNum();
        result = b.solution(number, k);

        System.out.println(result);
    }
}