public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];  // answer[0]이 최고, answer[1]이 최저 순위임
        int lowCount = 0;  // 맞는 번호 카운트 (최저)
        int highCount  = 0; // 맞는 카운트 (최고)

        // 순위 생각해보기
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] != 0) {    // 0이 아니라면
                for(int j = 0; j < win_nums.length; j++) {
                    if(lottos[i] == win_nums[j]) {  // 당첨번호랑 같다면
                        lowCount++;
                        highCount++;
                        break;
                    }
                }
            }
            else {  // 0이라면(가려진 거)
                highCount++;
            }
        }

        // 최저 순위
        switch (lowCount) {
            case 2: // 2개 일치하면
                answer[1] = 5;
                break;
            case 3: // 3개 일치하면
                answer[1] = 4;
                break;
            case 4: // 4개 일치하면
                answer[1] = 3;
                break;
            case 5: // 5개 일치하면
                answer[1] = 2;
                break;
            case 6: // 6개 일치하면
                answer[1] = 1;  // 1등!
                break;
            default:
                answer[1] = 6;
                break;
        }

        // 최고 순위
        switch (highCount) {
            case 2: // 2개 일치하면
                answer[0] = 5;
                break;
            case 3: // 3개 일치하면
                answer[0] = 4;
                break;
            case 4: // 4개 일치하면
                answer[0] = 3;
                break;
            case 5: // 5개 일치하면
                answer[0] = 2;
                break;
            case 6: // 6개 일치하면
                answer[0] = 1;  // 1등!
                break;
            default:
                answer[0] = 6;
                break;
        }

        return answer;
    }
}