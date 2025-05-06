public class Failure {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] failStage = new int[N + 1];   // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수
        int[] arrivedStage = new int[N + 1];    // 스테이지 도달한 플레이어 수
        double[] failure = new double[N + 1]; // 실패율 저장

        // 스테이지 넣어주기
        for(int i = 0; i < answer.length; i++) {
            answer[i] = i + 1;
        }

        for(int i = 0; i < stages.length; i++) {
            if(stages[i] > N) {
                for(int j = 1; j <= N; j++) {
                    arrivedStage[j]++;  // 스테이지에 도달한 플레이어수 구하기 위해
                }
            }
            else {
                failStage[stages[i]]++;
                for(int j = 1; j <= stages[i]; j++) {
                    arrivedStage[j]++;  // 스테이지에 도달한 플레이어수 구하기 위해
                }
            }
        }

        // 실패율 저장
        for(int i = 1; i <= N; i++) {
            if(arrivedStage[i] != 0) {
                failure[i] = (double) failStage[i] / arrivedStage[i];
            }
        }

        // 내림차순 정렬
        for(int i = 1; i <= failure.length - 1; i++) {
            for(int j = failure.length - 1; j > i; j--) {
                if(failure[j - 1] < failure[j]) {
                    double temp = failure[j - 1];
                    failure[j - 1] = failure[j];
                    failure[j] = temp;

                    // 스테이지 위치도 바꿔줌
                    int temp2 = answer[j - 2];
                    answer[j - 2] = answer[j - 1];
                    answer[j - 1] = temp2;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] res = {};

        Failure f = new Failure();
        res = f.solution(N, stages);
    }
}