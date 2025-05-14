public class SortingAsOnePleases {
    public String[] solution(String[] strings, int n) {
        for(int i = 0; i < strings.length - 1; i++) {
            for(int j = i; j < strings.length; j++) {
                if(strings[i].charAt(n) > strings[j].charAt(n)) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
                else if(strings[i].charAt(n) == strings[j].charAt(n)) {    // 둘이 같으면
                    if(strings[i].compareTo(strings[j]) >= 0) {   // 다음 것 비교
                        String tmp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = tmp;
                    }
                }
            }
        }

        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        String[] res = {};

        SortingAsOnePleases s = new SortingAsOnePleases();
        res = s.solution(strings, n);
    }
}