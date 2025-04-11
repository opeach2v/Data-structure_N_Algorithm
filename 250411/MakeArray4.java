public class MakeArray4 {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int[] result = {};

        stk[0] = arr[0];
        int i = 1;
        int j = 1;
        int count = 1;

        while(i < arr.length) {
            if(stk[0] == 0) {
                stk[0] = arr[i];
                i++;
                j++;
                count++;
                continue;
            }
            if(stk[j - 1] == arr[i]) {
                stk[j] = arr[i];
                i++;
                j++;
                count++;
                continue;
            }

            if(stk[j - 1] == 0) {    // 배열이 비었으면
                stk[j - 1] = arr[i];
                count++;
                if(i == arr.length-1) {
                    break;
                }
                i++;
                j++;
            }
            if(stk[j - 1] < arr[i]) {
                stk[j] = arr[i];
                count++;
                if(i == arr.length-1) {
                    break;
                }
                i++;
                j++;
                continue;
            }

            if(stk[j - 1] > arr[i]) {
                stk[j - 1] = 0;
                count--;
                j--;
            }
        }

        result = new int[count];
        int b = 0;
        int a = 0;
        while(b < stk.length) {
            if(stk[b] == 0) {
                b++;
            }
            else {
                result[a] = stk[b];
                a++;
                b++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 1, 8, 2, 9};
        int[] result = {};

        MakeArray4 m = new MakeArray4();
        result = m.solution(arr);
    }
}