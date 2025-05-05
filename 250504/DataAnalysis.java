import java.util.Arrays;

public class DataAnalysis {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] storage = new int[data.length][4];   // 임시 저장
        int size = 0;   // 나중에 값이 들어있는 storage 만큼만 구하려고
        int storage_idx = 0;
        int[][] answer = {};
        int code = 0, date = 1, maximum = 2, remain = 3;
        // 차례대로 코드 번호, 제조일, 최대 수량, 현재 수량 인덱스 

        for(int i = 0; i < data.length; i++) {
            if(ext.equals("code")) {
                if(data[i][code] < val_ext) {  // val_ext보다 값 추출
                    for(int j = 0; j < data[i].length; j++) {
                        storage[storage_idx][j] = data[i][j];
                    }
                    size++;
                    storage_idx++;
                }
            }
            else if(ext.equals("date")) {
                if(data[i][date] < val_ext) {  // val_ext보다 작은은 값 추출
                    for(int j = 0; j < data[i].length; j++) {
                        storage[storage_idx][j] = data[i][j];
                    }
                    size++;
                    storage_idx++;
                }
            }
            else if(ext.equals("maximum")) {
                if(data[i][maximum] < val_ext) {  // val_ext보다 작작은 값 추출
                    for(int j = 0; j < data[i].length; j++) {
                        storage[storage_idx][j] = data[i][j];
                    }
                    size++;
                    storage_idx++;
                }
            }
            else if(ext.equals("remain")) {
                if(data[i][remain] < val_ext) {  // val_ext보다 작은 값 추출
                    for(int j = 0; j < data[i].length; j++) {
                        storage[storage_idx][j] = data[i][j];
                    }
                    size++;
                    storage_idx++;
                }
            }
        }

        answer = new int[size][4];

        // 다 추출한 뒤 answer에 넣고
        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < 4; j++) {
                answer[i][j] = storage[i][j];
            }
        }

        final int[] sort_idx = new int[1];
        switch (sort_by) {
            case "code":
                sort_idx[0] = 0;
                break;
            case "date":
                sort_idx[0] = 1;
                break;
            case "maximum":
                sort_idx[0] = 2;
                break;
            case "remain":
                sort_idx[0] = 3;
                break;
            default:
                break;
        }
        
        // sort_by에 맞게 오름차순 정렬
        Arrays.sort(answer, (o1, o2) -> 
            Integer.compare(o1[sort_idx[0]], o2[sort_idx[0]]));

        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        int[][] res = {};

        DataAnalysis d = new DataAnalysis();
        res = d.solution(data, ext, val_ext, sort_by);
    }
}