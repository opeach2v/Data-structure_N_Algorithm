import java.util.Scanner;

public class Pizza {
    public int pizza(int slice, int n) {
        int result = 1;

        if(slice >= 2 && slice <= 10) {
            if(n / slice > 0) {
                result += n / slice;
                if(n % slice == 0) {
                    result--;
                }
            }
            else {
                result = 1;
            }
        }

        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        int slice, n;

        Scanner sc = new Scanner(System.in);

        slice = sc.nextInt();
        n = sc.nextInt();

        Pizza piz = new Pizza();

        piz.pizza(slice, n);

        sc.close();
    }
}