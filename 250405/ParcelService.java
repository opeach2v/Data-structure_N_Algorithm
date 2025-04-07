// import java.util.Scanner;

public class ParcelService {
    public int solution(int n, int w, int num) {
        int index = 0;  // w에서 몇 번째인지
        int up = 0; // 꺼내야 하는 택배 상자 윗 줄에 있을 상자
        int result = 1; // 꺼내려는 상자(미리 1 저장) + 꺼내기 위해 꺼내야 하는 상자
        
        int[] haha = new int[w];
        int[] haha2 = new int[w];    // haha의 반대

        // 1, 3, 5, 7, 9, 11, 13 등.. haha에 저장
        int a = 1;
        for(int j = 0; j < w; j++) {
            if(a % 2 == 1) {    // 홀수들만 저장
                haha[j] = a;
                a++;
            }
            else {
                continue;
            }
            a++;
        }
        a = 0;
        // haha를 haha2에 반대로 저장
        for(int j = w-1; j >= 0; j--) {
            haha2[a] = haha[j];
            a++;
        }

        for(int i = 1; i <= n; i++) {   // 모든 상자 순차적으로 확인
            if(i == num) {  // 꺼내야 하는 택배 상자 만나면
                index = num % w;  // 몇번째 인덱스에 있는지
                // index가 0이면 그대로 배열 적용하면 됨.
                // But, 0다음엔 5, 4, 3, 2, 1이 됨. ex) 0 5 4 3 2 1 배열이라는 소리
                
                if(index != 0) {
                    up = num + haha2[index - 1];
                }
                else {
                    up = num + haha[0];
                }
                if(up > n) {
                    break;
                }
                else {
                    result++;
                    num = up;
                    index = 0;
                }
                
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 22, w = 6;   // n은 택배 번호, w는 가로 길이
        int num = 8;    // 꺼내려는 택배 상자
        int result = 0; // 꺼내려는 상자(미리 1 저장) + 꺼내기 위해 꺼내야 하는 상자

        // Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();
        // w = sc.nextInt();
        // num = sc.nextInt();
        
        ParcelService sol = new ParcelService();
        result = sol.solution(n, w, num);

        System.out.println(result);

        // sc.close();
    }
}