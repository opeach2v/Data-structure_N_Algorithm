public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] arrivalUser = new int[N + 1]; // 스테이지에 도달한 유저의 수
        int[] failureRate = new int[N + 1]; // 스테이지에 도달했지만 실패한 유저의 수(인덱스 0은 안 씀)
        double[] failure = new double[N + 1];   // 실패율 저장
        int[] stage = new int[N + 1];

        for(int i = 0; i < stage.length; i++) {
            stage[i] = i;
        }

        // 스테이지에 도달한 유저의 수
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] <= N) {
                for(int j = 1; j <= stages[i]; j++) {
                    arrivalUser[j]++;
                }
            }
            else {
                for(int j = 1; j <= N; j++) {
                    arrivalUser[j]++;
                }
            }
        }

        // 스테이지에 도달했지만 실패한 유저의 수 저장
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] <= N) {
                failureRate[stages[i]]++; // 스테이지 순서대로 카운트
            }
        }

        // 카운트 다 하면 실패율에 / N 해줌
        for(int i = 1; i < failureRate.length; i++) {
            if(failureRate[i] != 0) {   // 해당 스테이지에 있는 사람이 있으면
                failure[i] = (double) failureRate[i] / arrivalUser[i];    // 실패율 저장
            }
            else {
                failure[i] = 0.0;
            }
        }

        // 실패율 내림차순하기
        for(int i = 1; i < failure.length - 1; i++) {
            for(int j = failure.length - 1; j > i; j--) {
                if(failure[j - 1] < failure[j]) {
                    double temp = failure[j - 1];
                    failure[j - 1] = failure[j];
                    failure[j] = temp;

                    // 스테이지 번호도 같이 이동
                    int temp2 = stage[j - 1];
                    stage[j - 1] = stage[j];
                    stage[j] = temp2;
                }
            }
        }

        // 실패율 높은 순으로 answer에 넣기
        for(int i = 0; i < answer.length; i++) {
            answer[i] = stage[i + 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] stages = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] res = {};

        FailureRate f = new FailureRate();
        res = f.solution(N, stages);
    }
}