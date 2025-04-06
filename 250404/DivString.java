import java.util.Scanner;

public class DivString {
    public static void main(String[] args) {
        String s = "";
        int fcount = 0, scount = 0; // 첫글자와 같은 문자 카운트, 다른 글자 나온 카운트

        Scanner sc = new Scanner(System.in);
        s = sc.next();

        String[] cut = s.split("");   // 분리된 문자열
        String t = "";
        String first = "";

        String[] s2 = new String[10];
        
        int allCount = 0;

        for(int i = 0; i <= s.length(); i++) {
            if(first == "") {
                first = cut[i]; // 첫글자 저장
                fcount++;
                t = cut[i];
                continue;
            }

            if(i == s.length()) {
                s2[allCount] = t;
                allCount++;
                break;
            }

            if(cut[i].equals(first)) {
                fcount++;
                t += cut[i];
                if(fcount == scount) {
                    s2[allCount] = t;
                    allCount++;
                    t = "";
                    first = "";
                    fcount = 0;
                    scount = 0;
                    continue;
                }
            }
            else {  // cut[i] != first
                scount++;
                t += cut[i];
                if(fcount == scount) {
                    s2[allCount] = t;
                    allCount++;
                    t = "";
                    first = "";
                    fcount = 0;
                    scount = 0;
                    continue;
                }
            }
        }

        if(s.length() % 2 == 1) {   // 홀수
            allCount++;
        }

        System.out.println(allCount);

        sc.close();
    }
}
