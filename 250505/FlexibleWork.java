public class FlexibleWork {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0; // 일주일동안 늦지 않은 직원의 수

        // 첫 번째 직원부터 n번째 직원까지 비교
        for(int i = 0; i < timelogs.length; i++) {
            int count = 0;  // 카운트가 5가 되면 성실 직원이므로 answer가 늘어남
            int yo1 = startday; // 미리 저장(각 직원마다 startday가 똑같아야 하니까)
            int schedule = schedules[i];   // 스케쥴 계산
            schedule += 10;   // 10분 더해보기
            if((schedule % 100) >= 60) { // 먄약 분이 60분을 넘어가면
                int hour = schedule / 100;   // 시 떼기
                schedule %= 100;  // 분 떼서
                schedule -= 60;   // 60분 제외 해주기
                hour += 1;  // 1시간 추가
                schedule = hour * 100 + schedule;
            }
            // 일주일동안 비교
            for(int j = 0; j < timelogs[i].length; j++) {
                if(yo1 != 6 && yo1 != 7) {  // 토일을 제외하고 계산
                    if(timelogs[i][j] <= schedule) count++;
                    else break;
                }
                if(yo1 == 7) {  // 요일이 일요일이면
                    yo1 = 1;    // 다음은 월요일
                }
                else {
                    yo1++;
                }
            }
            if(count == 5) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] sche = {755, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;
        int res = 0;

        FlexibleWork f = new FlexibleWork();
        res = f.solution(sche, timelogs, startday);
    }
}