import java.util.Scanner;

public class RemoveString {
    public static void main(String[] args) {
        String letter;
        String my_string = "";
        String result = "";
        
        Scanner sc = new Scanner(System.in);
        my_string = sc.next();
        letter = sc.next();

        String[] s = my_string.split("");

        for(int i = 0; i < s.length; i++) {
            if(s[i].equals(letter)) {
                continue;
            }
            else {
                result += s[i];
            }
        }

        System.out.println(result);

        sc.close();
    }
}
