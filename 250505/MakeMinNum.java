import java.util.Arrays;

public class MakeMinNum {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A); // 오름차순 정렬을 한다
        Arrays.sort(B);

        int i = 0;
        int j = B.length - 1;

        while(i < A.length && j >= 0) {
            answer += A[i] * B[j];
            i++;
            j--;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int res = 0;

        MakeMinNum m = new MakeMinNum();
        res = m.solution(A, B);
    }
}