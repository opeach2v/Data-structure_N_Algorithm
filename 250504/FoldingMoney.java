import java.util.Arrays;

public class FoldingMoney {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        Arrays.sort(wallet);    // 0인덱스가 1인덱스보다 작음
        Arrays.sort(bill);

        // bill의 작은 값이 wallet의 작은 값보다 크거나 bill의 큰 값이 wallet의 큰 값보다 큰 동안 반복
        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            }
            else {
                bill[1] /= 2;
            }
            Arrays.sort(bill);
            answer++;
        }

        return answer;
    }
}