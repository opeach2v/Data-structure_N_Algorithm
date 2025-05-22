import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buildingCount = sc.nextInt();
        int[] floors = new int[buildingCount];
        int sum = 0;

        for(int i = 0; i < buildingCount; i++) {
            floors[i] = sc.nextInt();
        }

        int num = 0;
        int count = 0;
        int floor = 0;
        for(int i = num; i < floors.length; i++) {
            if(i == num) {
                floor = floors[num];    // 해당 층
                continue;
            }

            if(floor > floors[i]) {
                count++;
            }
            else {  // floor <= floors[i]라면
                sum += count;
                count = 0;
                num++;
                i = num - 1;
            }
        }
        sum += count;

        System.out.println(sum);
    }
}