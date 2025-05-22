import java.util.Scanner;

public class ObigNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        for(int i = 0; i < count; i++) arr[i] = sc.nextInt();
        
        for(int i = 0; i < count; i++) {
            int max = 0;
            for(int j = i + 1; j < count; j++) {
                if(arr[i] < arr[j]) {
                    max = arr[j];
                }
            }
            if(max != 0) System.out.print(max +" ");    // max가 0이 아니면
            else System.out.print("-1 ");   // max가 0이면 -1로
        }
    }
}