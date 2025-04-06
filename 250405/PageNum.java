import java.util.Scanner;

public class PageNum {
    public static void main(String[] args) {
        int n;  // 페이지 수
        int[] numCount = new int[10]; // 0~9까지 카운트
        int c = 0;
        int d = 0;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            if(i < 10) {
                numCount[i]++;
            }
            else {
                c = i;
                while(c > 0) {
                    d = c % 10;
                    numCount[d]++;
                    c /= 10;
                }
            }
        }

        for(int i = 0; i < 10; i++) {
            System.out.print(numCount[i] + " ");
        }

        sc.close();
    }
}