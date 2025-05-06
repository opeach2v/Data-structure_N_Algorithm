public class BandageWrapping {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int suc = 0;    // 연속 성공 시 증가하는 체력 변화량
        int time = 0;   // 시간 흘러감
        int healthMax = health; // 최대 체력
        int idx = 0;    // attacks의 인덱스

        while(time <= attacks[attacks.length - 1][0]) {  // 시간이 마지막 공격까지 지나감
            if(time == attacks[idx][0]) { // 공격 당한 시간이랑 time이 같아지면
                health -= attacks[idx][1];    // 공격 당함. 체력 깎임
                if(health <= 0) {   // 체력이 0이하가 되면 죽음
                    return -1;
                }
                if(idx < attacks.length - 1) {
                    idx++;  // 다음 공격 시간 계산을 위해
                }
                suc = 0;    // 공격 당하면 연속 성공 초기화
                time++;
            }
            else {
                time++;
            }

            if(health < healthMax && time != attacks[idx][0] && time < attacks[attacks.length - 1][0])  {   // 현재 체력이 최대 체력보다 적으면
                suc++;
                health += bandage[1];   // 초당 체력 증가
                if(suc == bandage[0]) { // 추가 회복량 시전 시간과 같아지면
                    health += bandage[2];   // 추가 회복량 만큼 더해주기
                    suc = 0;
                }
                if(health > healthMax) {    // 최대 체력보다 많아지면
                    health = healthMax; // 최대 체력으로 맞추기
                }
            }
        }

        answer = health;

        return answer;
    }

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int res = 0;

        BandageWrapping b = new BandageWrapping();
        res = b.solution(bandage, health, attacks);

        System.out.println(res);
    }
}