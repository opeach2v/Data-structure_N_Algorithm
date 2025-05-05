public class FoldingMoney {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMin = 0, walletMax = 0;   // 지갑의 길이 작은 값, 큰 값
        int billMin = 0, billMax = 0;   // 돈의 길이 작은 값, 큰 값

        // 지갑 길이 계산
        if(wallet[0] > wallet[1]) {
            walletMax = wallet[0];
            walletMin = wallet[1];
        }
        else {
            walletMax = wallet[1];
            walletMin = wallet[0];
        }

        // 돈 길이 계산
        if(bill[0] > bill[1]) {
            billMax = bill[0];
            billMin = bill[1];
        }
        else {
            billMax = bill[1];
            billMin = bill[0];
        }

        // bill의 작은 값이 wallet의 작은 값보다 크거나 bill의 큰 값이 wallet의 큰 값보다 큰 동안 반복
        while (billMin > walletMin || billMax > walletMax) { 
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
                billMax = bill[1];
                billMin = bill[0];
            }
            else {
                bill[1] /= 2;
                billMax = bill[0];
                billMin = bill[1];
            }
            answer++;
        }

        return answer;
    }
}