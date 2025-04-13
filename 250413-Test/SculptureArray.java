import java.util.ArrayList;

public class SculptureArray {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {   // 리스트에 값 넣기
            list.add(i, arr[i]);
        }
        // 왜 이런식으로 해야만 런타임 에러가 안 뜨는지 모르겠음. list의 배신이다
        for(int i = 0; i < query.length; i++) { // query만큼 순회
            if(i % 2 == 0) {    // 짝수 인덱스면
                for(int j = 0; j < query[i]; j++) {
                    list2.add(list.get(j));
                }
            }
            else if(i % 2 == 1) {  // 홀수 인덱스면
                for(int j = query[i]; j < list.size(); j++) {
                    list2.add(list.get(j));
                }
            }
            list.clear();
            list.addAll(list2);
            list2.clear();
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        int[] result = {};

        SculptureArray s = new SculptureArray();
        result =s.solution(arr, query);
    }
}