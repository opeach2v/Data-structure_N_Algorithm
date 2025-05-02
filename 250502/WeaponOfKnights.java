public class WeaponOfKnights {
    public int solution(int number, int limit, int power) {
        int answer = 1; // 기사 1번은 무조건 공격력 1임(불쌍해...)
        int knight = 2; // 기사 2번부터
        int offensivePower = 2; // 각 공격력 구할 것. 1일 때와 기사 번호와 같은 번호는 항상 약수이기 때문에 미리 넣어놓기
        
        // 2번 기사부터 각 기사단원의 공격력 계산하기
        while(knight <= number) {
            for(int j = 2; j <= knight / 2; j++) {
                if(knight % j == 0) {
                    offensivePower++;   // 약수만큼 ++
                }
                if(offensivePower > limit) {    // 공격력이 초과하면
                    offensivePower = power;     // 협약으로 정해진 공격력 제한 수치로 조정
                    break;
                }
            }
            answer += offensivePower;
            offensivePower = 2; // 초기화
            knight++;   // 다음 기사 등장
        }

        return answer;
    }

    public static void main(String[] args) {
        int number = 2;
        int limit = 3;
        int power = 2;
        int res = 0;

        WeaponOfKnights w = new WeaponOfKnights();
        res = w.solution(number, limit, power);
    }
}

// int[] offensivePower = new int[number]; // 각 기사단원의 공격력이 담길 곳
        
//         // 각 기사단원의 공격력 계산하기
//         for(int i = 2; i <= offensivePower.length; i++) {
//             for(int j = 1; j <= i; j++) {
//                 if(i % j == 0) {
//                     offensivePower[i - 1]++;
//                 }
//                 if(offensivePower[i - 1] > limit) { // 공격력이 초과되면
//                     offensivePower[i - 1] = power;
//                     break;
//                 }
//             }
//             answer += offensivePower[i - 1];    // 바로 공격력 더해주기
//         }