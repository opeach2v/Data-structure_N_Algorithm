public class Trio {
    static int answer = 0;
    int i = 0;
    int j = 1;
    int k = 2;
    public int solution(int[] number) {
        if(k == number.length) {
            j++;
            k = j + 1;
        }
        if(j == number.length - 1) {
            i++;
            j = i + 1;
            k = j + 1;
        }
        if(i == number.length - 2) {
            return answer;
        }

        if(number[i] + number[j] + number[k] == 0) answer++;
        k++;

        return solution(number);
    }

    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int answer = 0;
        int i = 0;
        int j = 1;
        int k = 2;
        int res = 0;

        Trio t = new Trio();
        res = t.solution(number, answer, i, j, k);
    }
}