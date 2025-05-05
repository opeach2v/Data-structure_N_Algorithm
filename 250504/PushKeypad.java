public class PushKeypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String leftHand = "*";    // 왼손 현재 위치
        String rightHand = "#";   // 오른손 현재 위치
        int leftCount = 0;  // 왼손이 이동해야하는 거리
        int rightCount = 0; // 오른손이 이동해야하는 거리

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) { // 왼손 사용
                answer += "L";
                leftHand = String.valueOf(numbers[i]);  // 해당 번호가 왼손 현재 위치가 됨
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {    // 오른손 사용
                answer += "R";
                rightHand = String.valueOf(numbers[i]);  // 해당 번호가 오른손 현재 위치가 됨
            }
            else {  // 나머지 2, 5, 8, 0의 경우 더 가까운 쪽
                if(numbers[i] == 2) {
                    switch (leftHand) { // 왼손
                        case "1":
                            leftCount = 1;
                            break;
                        case "2":
                            leftCount = 0;
                            break;
                        case "4":
                            leftCount = 2;
                            break;
                        case "5":
                            leftCount = 1;
                            break;
                        case "7":
                            leftCount = 3;
                            break;
                        case "8":
                            leftCount = 2;
                            break;
                        case "*":
                            leftCount = 4;
                            break;
                        case "0":
                            leftCount = 3;
                            break;
                        default:
                            break;
                    }

                    switch (rightHand) { // 오른손
                        case "2":
                            rightCount = 0;
                            break;
                        case "3":
                            rightCount = 1;
                            break;
                        case "5":
                            rightCount = 1;
                            break;
                        case "6":
                            rightCount = 2;
                            break;
                        case "8":
                            rightCount = 2;
                            break;
                        case "9":
                            rightCount = 3;
                            break;
                        case "#":
                            rightCount = 4;
                            break;
                        case "0":
                            rightCount = 3;
                            break;
                        default:
                            break;
                    }
                }

                if(numbers[i] == 5) {
                    switch (leftHand) { // 왼손
                        case "1":
                            leftCount = 2;
                            break;
                        case "2":
                            leftCount = 1;
                            break;
                        case "4":
                            leftCount = 1;
                            break;
                        case "5":
                            leftCount = 0;
                            break;
                        case "7":
                            leftCount = 2;
                            break;
                        case "8":
                            leftCount = 1;
                            break;
                        case "*":
                            leftCount = 3;
                            break;
                        case "0":
                            leftCount = 2;
                            break;
                        default:
                            break;
                    }

                    switch (rightHand) { // 오른손
                        case "2":
                            rightCount = 1;
                            break;
                        case "3":
                            rightCount = 2;
                            break;
                        case "5":
                            rightCount = 0;
                            break;
                        case "6":
                            rightCount = 1;
                            break;
                        case "8":
                            rightCount = 1;
                            break;
                        case "9":
                            rightCount = 2;
                            break;
                        case "#":
                            rightCount = 3;
                            break;
                        case "0":
                            rightCount = 2;
                            break;
                        default:
                            break;
                    }
                }

                if(numbers[i] == 8) {
                    switch (leftHand) { // 왼손
                        case "1":
                            leftCount = 3;
                            break;
                        case "2":
                            leftCount = 2;
                            break;
                        case "4":
                            leftCount = 2;
                            break;
                        case "5":
                            leftCount = 1;
                            break;
                        case "7":
                            leftCount = 1;
                            break;
                        case "8":
                            leftCount = 0;
                            break;
                        case "*":
                            leftCount = 2;
                            break;
                        case "0":
                            leftCount = 1;
                            break;
                        default:
                            break;
                    }

                    switch (rightHand) { // 오른손
                        case "2":
                            rightCount = 2;
                            break;
                        case "3":
                            rightCount = 3;
                            break;
                        case "5":
                            rightCount = 1;
                            break;
                        case "6":
                            rightCount = 2;
                            break;
                        case "8":
                            rightCount = 0;
                            break;
                        case "9":
                            rightCount = 1;
                            break;
                        case "#":
                            rightCount = 2;
                            break;
                        case "0":
                            rightCount = 1;
                            break;
                        default:
                            break;
                    }
                }

                if(numbers[i] == 0) {
                    switch (leftHand) { // 왼손
                        case "1":
                            leftCount = 4;
                            break;
                        case "2":
                            leftCount = 3;
                            break;
                        case "4":
                            leftCount = 3;
                            break;
                        case "5":
                            leftCount = 2;
                            break;
                        case "7":
                            leftCount = 2;
                            break;
                        case "8":
                            leftCount = 1;
                            break;
                        case "*":
                            leftCount = 1;
                            break;
                        case "0":
                            leftCount = 0;
                            break;
                        default:
                            break;
                    }

                    switch (rightHand) { // 오른손
                        case "2":
                            rightCount = 3;
                            break;
                        case "3":
                            rightCount = 4;
                            break;
                        case "5":
                            rightCount = 2;
                            break;
                        case "6":
                            rightCount = 3;
                            break;
                        case "8":
                            rightCount = 1;
                            break;
                        case "9":
                            rightCount = 2;
                            break;
                        case "#":
                            rightCount = 1;
                            break;
                        case "0":
                            rightCount = 0;
                            break;
                        default:
                            break;
                    }
                }

                if(leftCount == rightCount) {   // 둘 다 가까우면
                    if(hand.equals("right")) {
                        answer += "R";
                        rightHand = String.valueOf(numbers[i]);
                    }
                    else {
                        answer += "L";
                        leftHand = String.valueOf(numbers[i]);
                    }
                    
                }
                else if(leftCount < rightCount) {   // 왼손이 더 가까우면
                    answer += "L";
                    leftHand = String.valueOf(numbers[i]);
                }
                else {  // 오른손이 더 가까우면
                    answer += "R";
                    rightHand = String.valueOf(numbers[i]);
                }
            }
        }

        return answer;
    }
}