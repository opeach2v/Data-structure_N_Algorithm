import java.util.Scanner;

public class ParcelService {
    public static void main(String[] args) {
        int n, w;   // n은 택배 번호, w는 가로 길이
        int num;    // 꺼내려는 택배 상자
        int line = 1;    // 현재 계산 중인 박스 줄
        int index = 0;  // w에서 몇 번째인지
        int up = 0; // 꺼내야 하는 택배 상자 윗 줄에 있을 상자
        int result = 1; // 꺼내려는 상자(미리 1 저장) + 꺼내기 위해 꺼내야 하는 상자

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        num = sc.nextInt();

        int[] haha = new int[w];
        int[] haha2 = new int[w];    // haha의 반대

        // 1, 3, 5, 7, 9, 11, 13 등.. 저장
        int a = 1;
        for(int j = 0; j < w; j++) {
            if(a % 2 == 1) {
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

        for(int i = 1; i <= n; i++) {   // 모든 상자 검색
            if(i == num) {  // 꺼내야 하는 택배 상자 만나면
                line = num / w; // 몇 줄?
                if(num % w == 0) {
                    line--;
                }
                index = num % w;  // 몇번째 haha?
                if(index == 0) {
                    index++;
                }
                if(line == 1 || line == 3 || line == 5 || line == 7 || line == 9) {    // 홀수 줄
                    up = num + haha[index];
                    if(up > n) {
                        break;
                    }
                    else {
                        result++;
                        num = up;
                        line = 1;
                        index = 0;
                    }
                }
                else {  // 짝수 줄이면
                    up = num + haha2[index];
                    if(up > n) {
                        break;
                    }
                    else {
                        result++;
                        num = up;
                        line = 1;
                        index = 0;
                    }
                }
            }
        }

        System.out.println(result);

        sc.close();
    }
}