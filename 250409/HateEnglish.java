public class HateEnglish {
    public long solution(String numbers) {
        long answer = 0;
        String result = "";
        String[] nums = numbers.split("");
        int i = 0;
        while(i < nums.length) {
            if(nums[i].equals("o")) {   // one이면
                i += 3; // 3칸 뒤로
                result += "1";
            }
            else if(nums[i].equals("t")) {   // two나 three
                if(nums[i+1].equals("w")) {
                    i += 3; // 3칸 뒤로
                    result += "2";
                }
                else {
                    i += 5;
                    result += "3";
                }
            }
            else if(nums[i].equals("f")) {  // four이나 five
                if(nums[i+1].equals("o")) {
                    i += 4;
                    result += "4";
                }
                else {
                    i += 4;
                    result += "5";
                }
            }
            else if(nums[i].equals("s")) {  // six이나 seven
                if(nums[i+1].equals("i")) {
                    i += 3;
                    result += "6";
                }
                else {
                    i += 5;
                    result += "7";
                }
            }
            else if(nums[i].equals("e")) {
                i += 5;
                result += "8";
            }
            else if(nums[i].equals("n")) {
                i += 4;
                result += "9";
            }
            else if(nums[i].equals("z")) {
                // zero는 앞에 올 수 없기 때문에 결과 값 넣는 곳이 공백이면
                if(result.equals("")) {    
                    i += 4;
                    continue;
                }
                i += 4;
                result += "0";
            }
            if(i > numbers.length()) {
                i--;
            }
        }

        answer = Long.parseLong(result);    // 미친... Integer.parseInt로 변환해서 넣으려고 해서 오류남

        return answer;
    }

    public static void main(String[] args) {
        String numbers = "zeroninetwothreesevenfourzerofivesixseveneightnine";
        long result = 0;

        HateEnglish h = new HateEnglish();
        result = h.solution(numbers);

        System.out.println(result);
    }
}
