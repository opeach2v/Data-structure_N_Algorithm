import java.util.Scanner;

public class Oasis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        int sum = 0;

        for(int i = 0; i < count; i++) arr[i] = sc.nextInt();

        for(int i = 0; i < count - 1; i++) {
            for(int j = i + 1; j < count; j++) {
                if(arr[i] < arr[j]) {   // 큰 사람을 만나면
                    sum++;
                    break;  // 뒤엔 더 비교할 필요 x
                }
                else {
                    sum++;
                } 
            }
        }

        System.out.println(sum);
    }
}