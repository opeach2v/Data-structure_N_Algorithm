import java.util.*;

public class BaboKeyborad {
    public static void main(String[] args) {
        String[] keymap = {};
        String[] targets = {};
        int[] result = {};

        Scanner sc = new Scanner(System.in);
        
        String[] keyS = {};    // keymap split
        String[] tarS = {};    // target split

        for(int a = 0; a < keymap.length; a++) {   // 타겟 계산이 끝날 때까지 반복
            for(int b = 0; b < keymap[a].length(); b++) {
                keyS = keymap[a].split("");
            }
            for(int c = 0; c < targets.length; c++) {   // 타겟 계산이 끝날 때까지 반복
                for(int d = 0; d < targets[c].length(); d++) {
                    tarS = targets[c].split("");
                }
            }
        }

        for(int z = 0; z < result.length; z++) {
            System.out.println(result);
        }
        sc.close();
    }
}