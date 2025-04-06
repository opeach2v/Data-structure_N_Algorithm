import java.util.*;

public class ChangeABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        String[] array = a.split("");

        for(int i = 0; i < array.length; i++) {
            // 문자로 가져오기
            char c = array[i].charAt(0);
            if(c >= 'A' && c <= 'Z') {  // 알파벳 대문자
                c += 32;    // 소문자로 바꾸기
                array[i] = String.valueOf(c); // 문자열로 바꿔서 저장
            }
            else {
                c -= 32;    // 소문자로 바꾸기
                array[i] = String.valueOf(c); // 문자열로 바꿔서 저장
            }
        }
        a = "";
        for(int i = 0; i < array.length; i++) {
            a += array[i];
        }

        System.out.println(a);

        sc.close();
    }
}