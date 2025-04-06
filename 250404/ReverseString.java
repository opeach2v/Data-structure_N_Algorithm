
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        String myString, revString = "";

        Scanner sc = new Scanner(System.in);
        myString = sc.next();

        String[] s = myString.split("");

        for(int i = s.length-1; i >= 0; i--) {
            revString += s[i];
        }

        System.out.println(revString);

        sc.close();
    }
}