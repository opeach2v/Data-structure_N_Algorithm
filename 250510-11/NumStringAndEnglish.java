import java.util.LinkedList;
import java.util.Queue;

public class NumStringAndEnglish {
    public int solution(String s) {
        Queue<Integer> NumEnglish = new LinkedList<>();  // 큐 사용

        String[] str = s.split("");
        for(int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "z":   // zero
                    NumEnglish.offer(0);    // 큐에 0 넣기
                    i += 3;
                    break;
                case "o":   // one
                    NumEnglish.offer(1);    // 큐에 1 넣기
                    i += 2;
                    break;
                case "t":   // two or three
                    if(str[i + 1].equals("w")) {    // two
                        NumEnglish.offer(2);    // 큐에 2 넣기
                        i += 2;
                    }
                    else {  // three
                        NumEnglish.offer(3);    // 큐에 3 넣기
                        i += 4;
                    }
                    break;
                case "f":   // four or five
                    if(str[i + 1].equals("o")) {    // four
                        NumEnglish.offer(4);    // 큐에 4 넣기
                        i += 3;
                    }
                    else {  // five
                        NumEnglish.offer(5);    // 큐에 5 넣기
                        i += 3;
                    }
                    break;
                case "s":   // six or seven
                    if(str[i + 1].equals("i")) {    // six
                        NumEnglish.offer(6);    // 큐에 6 넣기
                        i += 2;
                    }
                    else {  // seven
                        NumEnglish.offer(7);    // 큐에 7 넣기
                        i += 4;
                    }
                    break;
                case "e":   // eight
                    NumEnglish.offer(8);    // 큐에 8 넣기
                    i += 4;
                    break;
                case "n":   // nine
                    NumEnglish.offer(9);    // 큐에 9 넣기
                    i += 3;
                    break;
                default:    // 애초에 숫자일 경우
                    NumEnglish.offer(Integer.parseInt(str[i])); // 그 숫자 바로 넣기
                    break;
            }
        }

        s = ""; // 문자열 초기화 후
        for(int i = 0; i < NumEnglish.size(); i++) {
            s += String.valueOf(NumEnglish.poll()); // 첫번째 값들 계속 더해주기
            i--;
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        int res = 0;

        NumStringAndEnglish n = new NumStringAndEnglish();
        res = n.solution(s);

        System.out.println(res);
    }
}