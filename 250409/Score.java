public class Score {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avg = new double[score.length];

        for(int i = 0; i < score.length; i++) { // 평균 담기
            avg[i] = (double)(score[i][0] + score[i][1]) / 2;
        }

        int grade = 1;  // 등수
        int max = 0;    // 제일 높은 점수의 인덱스 찾기 위함
        int count = 0;
        while(grade <= score.length) {
            if(answer[max] != 0) {
                max += 1;
                continue;
            }
            for(int i = 1; i < score.length; i++) { // 가장 높은 점수 찾기
                if(avg[max] < avg[i]) {
                    if(answer[i] != 0) {    // 값이 있다면
                        continue;
                    }
                    max = i;   // 더 큰 점수가 있는 인덱스로 바꿔줌
                }
                if(avg[max] == avg[i]) { // 같으면
                    continue; // 일단 건너뛰기
                }
            }
            answer[max] = grade;
            for(int i = 0; i < score.length; i++) {
                if(avg[max] == avg[i]) {    // 가장 높은 점수의 점수와 같다면
                    answer[i] = grade;
                    count++;
                }
            }
            // 더이상 같은 점수가 없으면
            grade += count;
            count = 0;
            max = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        // int[][] score = {{80, 70}, {70, 80} , {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
        int[][] score = {{70, 40}, {40, 70}, { 50, 60}};
        int[] result = {};

        Score s = new Score();
        result = s.solution(score);

        System.out.println(result);
    }
}