public class JumpMove {
    public int solution(int n) {
        int ans = 0;
        
        while(n > 0) {
            if(n % 2 == 1) {
                ans++;
                n /= 2;
            }
            else n /= 2;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int res = 0;

        JumpMove j = new JumpMove();
        res = j.solution(n);
    }
}