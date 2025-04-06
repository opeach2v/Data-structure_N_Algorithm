public class RemoveAd {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        String add = "";
        String[] strArrS = {};
        int index = 0;  // answer 인덱스 값

        int i = 0;
        int a = 0;
        int b = 1;
        while(i < strArr.length) {
            strArrS = strArr[i].split("");

            while(a < strArrS.length - 1) {
                while(b < strArrS.length) {
                    add = strArrS[a] + strArrS[b];
                    if(add.equals("ad")) {
                        strArr[i] = strArr[i].replace(strArr[i], "");
                        index--;
                        break;
                    }
                    else {
                        b++;
                        break;
                    }
                }
                if(add.equals("ad")) {
                    break;
                }
                else {
                    a++;
                }
            }
            i++;
            a = 0;
            b = 1;
            index++;
        }

        answer = new String[index];
        i = 0;
        while (i < index) {
            for(int j = 0; j < strArr.length; j++) {
                if(!strArr[j].equals("")) {
                    answer[i] = strArr[j];
                    i++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] strArr = {"and","notad","abcd"};
        String[] answer = {};

        RemoveAd r = new RemoveAd();
        answer = r.solution(strArr);

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer);
        }
    }
}