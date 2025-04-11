public class BigNums {
    public String solution(String number, int k) {
        String answer = "";
        String[] numS = number.split("");
        int count = 0;  // 삭제되면 카운트++
        int num = 0;    // 1부터 삭제

        int max = 0;    // 가장 큰 숫자의 인덱스 저장
        int maxCount = 0;
        // 제일 큰 숫자 발견하기
        for(int i = 0; i < numS.length; i++) {
            if(Integer.parseInt(numS[max]) < Integer.parseInt(numS[i])) {
                max = i;
            }
            // 제일 큰 수와 제일 큰 수가 만나면 maxCount도 올리고, max 인덱스를 업데이트
            // 같은 수가 여러 개 잇을 경우엔 제일 뒷쪽에 있는 걸 기준으로 하기 위해서
            if(Integer.parseInt(numS[max]) == Integer.parseInt(numS[i])) {
                maxCount++;
                max = i;
            }
        }
        if(maxCount == numS.length) {    // 다 같은 숫자면 여기서 카운트만큼 삭제하고 리턴해서 끝냄
            for(int i = 0; i < numS.length - k; i++) {  // k를 뺀 값을 넣어서 리턴
                answer += numS[i];
            }
            return answer;
        }

        // 최종적으로 큰 숫자 앞에서 작은 수부터 삭제
        while_exit:
        if(max > 0 && max < numS.length - 1) {   // max인덱스가 0보다 클 때 여기 실행
            while(num < Integer.parseInt(numS[max])) {  // max번째 인덱스의 숫자가 되기 전까지
                for(int i = 0; i < max; i++) {
                    if(numS[i].equals("")) {
                        continue;
                    }
                    if(Integer.parseInt(numS[i]) == num) {
                        numS[i] = "";   // 비우기
                        count++;
                    }
                    if(count == k) {    // 카운트가 k만큼 되면
                        break while_exit;
                    }
                }
                if(count == k) {    // 카운트가 k만큼 되면
                    break;
                }
                num++;  // 다음 숫자로 다시 돌기
            }

            // 반복문을 빠져나왔는데도 카운트가 k만큼 안 됐으면
            num = 0;    // 다시 1로 만들어주기
            if(count < k) {
                while(num < Integer.parseInt(numS[max])) {
                    for(int i = max + 1; i < numS.length; i++) {    // max 인덱스 이후 비교
                        if(numS[i].equals("")) {
                            continue;
                        }
                        if(Integer.parseInt(numS[i]) == num) {
                            numS[i] = "";   // 비우기
                            count++;
                        }
                    }
                    if(count == k) {    // 카운트가 k만큼 되면
                        break;
                    }
                    num++;
                }
                
                // 뒤에도 비교 했는데 아직 카운트가 남았으면 max값만 남았다는 거
                if(count < k) { // 큰 값으로 비교하기
                    for(int i = 0; i < numS.length; i++) {
                        if(numS[i].equals("")) {
                            continue;
                        }
                        if(Integer.parseInt(numS[i]) == Integer.parseInt(numS[max])) {
                            numS[i] = "";   // 비우기
                            count++;
                        }
                        if(count == k) {    // 카운트가 k만큼 되면
                            break while_exit;
                        }
                    }
                }
            }
        }
        else {  // max가 0이거나 끝에 위치할 때
            if(max == 0) {
                while(num < Integer.parseInt(numS[max])) {  // max번째 인덱스의 숫자가 되기 전까지
                    for(int i = max + 1; i < numS.length; i++) {
                        if(numS[i].equals("")) {
                            continue;
                        }
                        if(Integer.parseInt(numS[i]) == num) {
                            numS[i] = "";   // 비우기
                            count++;
                        }
                        if(count == k) {    // 카운트가 k만큼 되면
                            break while_exit;
                        }
                    }
                    num++;  // 다음 숫자로 다시 돌기
                }
            }
            else if(max == numS.length - 1) {
                while(num <= Integer.parseInt(numS[max])) {  // max번째 인덱스의 숫자까지 카운트에 맞게 지우기
                    for(int i = 0; i < numS.length; i++) {
                        if(numS[i].equals("")) {
                            continue;
                        }
                        if(Integer.parseInt(numS[i]) == num) {
                            numS[i] = "";   // 비우기
                            count++;
                        }
                        if(count == k) {    // 카운트가 k만큼 되면
                            break while_exit;
                        }
                    }
                    num++;  // 다음 숫자로 다시 돌기
                }
            }
        }

        // 다 끝나고 문자열로 바꿔주기 (공백 제외)
        for (int i = 0; i < numS.length; i++) {
            if (!numS[i].equals("")) {
                // 공백 아니면
                answer += numS[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String num = "7771377";
        int k = 5;

        BigNums b = new BigNums();
        String result = b.solution(num, k);
    }
}