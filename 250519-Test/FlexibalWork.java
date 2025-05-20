public class FlexibalWork {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i = 0; i < timelogs.length; i++) {
            int count = 0;
            int yo1 = startday;
            // 출근 시간 관련
            if((schedules[i] + 10) % 100 > 59) {   // 59보다 크면
                schedules[i] += 110 - 60;
            }
            else schedules[i] += 10;

            for(int j = 0; j < timelogs[i].length; j++) {
                if(yo1 == 6 || yo1 == 7) {
                    count++;
                }
                else {
                    if (schedules[i] >= timelogs[i][j]) {    // 타임로그보다 출근하기로 한 시간이 작거나 같으면
                    count++;
                    }
                }
                
                // 요일 관련
                if(yo1 == 7) { // 현재 yo1dl 7이면 월요일(1)로 넘어감
                    yo1 = 1;
                }
                else yo1++;
            }

            if(count == 7) answer++;    // 카운트가 7이면 모든 잘 출근햇다는...
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] sche = {730, 855, 700, 720};
        int[][] time = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
        int start = 1;
        int res = 0;

        FlexibalWork f = new FlexibalWork();
        res = f.solution(sche, time, start);
    }
}