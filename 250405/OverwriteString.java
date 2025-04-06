import java.util.Scanner;

public class OverwriteString {
    public static void main(String[] args) {
        String my_string;
        String overwrite_string;
        int s;

        Scanner sc = new Scanner(System.in);
        my_string = sc.next();
        overwrite_string = sc.next();
        s = sc.nextInt();

        String[] myString = my_string.split("");
        String[] overString = overwrite_string.split("");

        int len = overString.length;

        int j = s;
        for(int i = 0; i < len; i++) {
            myString[j] = overString[i];
            j++;
        }
        
        my_string = "";
        for(int i = 0; i < myString.length; i++) {
            my_string += myString[i];
        }
        System.out.println(my_string);

        sc.close();
    }
}