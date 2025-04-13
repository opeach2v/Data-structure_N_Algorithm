
public class MakeArray2 {
    public int[] solution(int l, int r) {
        int[] array = new int[r];   // r / l 에서 고쳤더니 런타임에러 사라짐
        int[] answer = {};
        int j = 0;
        int a = 0;

        for (int i = l; i <= r; i++) {
            if(i > 10) {
                a = i;
                while(a > 0) {
                    if(a % 10 == 0) {
                        a = a / 10;
                        continue;
                    }
                    if(a % 10 == 5) {
                        a = a / 10;
                        continue;
                    }
                    else {
                        break;
                    }
                }
                if(a == 0) {
                    array[j] = i;
                    j++;
                }
            }
            else {
                if(i % 10 == 5) {
                    array[j] = i;
                    j++;
                }
            }
        }

        if(array[0] == 0) {
            answer = new int[1];
            answer[0] = -1;

            return answer;
        }

        answer = new int[j];
        for(int i = 0; i < j; i++) {
            answer[i] = array[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int l = 500;
        int r = 555;

        int[] result = {};

        MakeArray2 m = new MakeArray2();
        result = m.solution(l, r);
    }
}