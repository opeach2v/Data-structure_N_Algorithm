public class KakaoMBTI {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int R = 0, T = 0;   // 라이언형, 튜브형
        int C = 0, F = 0;   // 콘형, 프로도형
        int J = 0, M = 0;   // 제이지형, 무지형
        int A = 0, N = 0;   // 어피치형, 네오형
        
        for(int i = 0; i < survey.length; i++) {
            if(survey[i].equals("RT")) {
                switch(choices[i]) {
                    case 1:
                        R += 3;
                        break;
                    case 2:
                        R += 2;
                        break;
                    case 3:
                        R += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        T += 1;
                        break;
                    case 6:
                        T += 2;
                        break;
                    case 7:
                        T += 3;
                        break;
                }
            }
            else if(survey[i].equals("TR")) {
                switch(choices[i]) {
                    case 1:
                        T += 3;
                        break;
                    case 2:
                        T += 2;
                        break;
                    case 3:
                        T += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        R += 1;
                        break;
                    case 6:
                        R += 2;
                        break;
                    case 7:
                        R += 3;
                        break;
                }
            }
            else if(survey[i].equals("FC")) {
                switch(choices[i]) {
                    case 1:
                        F += 3;
                        break;
                    case 2:
                        F += 2;
                        break;
                    case 3:
                        F += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        C += 1;
                        break;
                    case 6:
                        C += 2;
                        break;
                    case 7:
                        C += 3;
                        break;
                }
            }
            else if(survey[i].equals("CF")) {
                switch(choices[i]) {
                    case 1:
                        C += 3;
                        break;
                    case 2:
                        C += 2;
                        break;
                    case 3:
                        C += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        F += 1;
                        break;
                    case 6:
                        F += 2;
                        break;
                    case 7:
                        F += 3;
                        break;
                }
            }
            else if(survey[i].equals("MJ")) {
                switch(choices[i]) {
                    case 1:
                        M += 3;
                        break;
                    case 2:
                        M += 2;
                        break;
                    case 3:
                        M += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        J += 1;
                        break;
                    case 6:
                        J += 2;
                        break;
                    case 7:
                        J += 3;
                        break;
                }
            }
            else if(survey[i].equals("JM")) {
                switch(choices[i]) {
                    case 1:
                        J += 3;
                        break;
                    case 2:
                        J += 2;
                        break;
                    case 3:
                        J += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        M += 1;
                        break;
                    case 6:
                        M += 2;
                        break;
                    case 7:
                        M += 3;
                        break;
                }
            }
            else if(survey[i].equals("AN")) {
                switch(choices[i]) {
                    case 1:
                        A += 3;
                        break;
                    case 2:
                        A += 2;
                        break;
                    case 3:
                        A += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        N += 1;
                        break;
                    case 6:
                        N += 2;
                        break;
                    case 7:
                        N += 3;
                        break;
                }
            }
            else if(survey[i].equals("NA")) {
                switch(choices[i]) {
                    case 1:
                        N += 3;
                        break;
                    case 2:
                        N += 2;
                        break;
                    case 3:
                        N += 1;
                        break;
                    case 4:
                        break;
                    case 5:
                        A += 1;
                        break;
                    case 6:
                        A += 2;
                        break;
                    case 7:
                        A += 3;
                        break;
                }
            }
        }

        if(R >= T) {
            answer += "R";
        }
        else {
            answer += "T";
        }

        if(C >= F) {
            answer += "C";
        }
        else {
            answer += "F";
        }

        if(J >= M) {
            answer += "J";
        }
        else {
            answer += "M";
        }

        if(A >= N) {
            answer += "A";
        }
        else {
            answer += "N";
        }

        return answer;
    }
}

// 17분 20초