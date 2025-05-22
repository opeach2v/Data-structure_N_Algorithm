
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = -1;
        int h = 0;
        int w = 0;

        while(count != 0) {
            count = sc.nextInt();
            if(count == 0) break;
            
            int[] arr = new int[count];
            for(int i = 0; i < count; i++) {
                arr[i] = sc.nextInt();
                if(h != 0) {
                    if(h > arr[i] && w > 0) {
                        h = arr[i];   //
                        w++;
                    }
                    else w++;
                    continue;
                }
                h = arr[i];
                w++;
            }
        }
    }
}