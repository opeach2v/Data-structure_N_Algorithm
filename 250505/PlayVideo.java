public class PlayVideo {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // 현재 위치 분, 초
        int mm = Integer.parseInt(pos.substring(0, 2));
        int ss = Integer.parseInt(pos.substring(3, 5));
        String posMs = pos.substring(0, 2) + pos.substring(3, 5);
        // 전체 동영상 길이의 분, 초
        int videoM = Integer.parseInt(video_len.substring(0, 2));
        int videoS= Integer.parseInt(video_len.substring(3, 5));
        // 오프닝 시작 분, 초
        String opStart = op_start.substring(0, 2) + op_start.substring(3, 5);
        // 오프닝 끝 분, 초
        int opEndM = Integer.parseInt(op_end.substring(0, 2));
        int opEndS = Integer.parseInt(op_end.substring(3, 5));
        String opEnd = op_end.substring(0, 2) + op_end.substring(3, 5);

        // 현재 위치가 오프닝 사이일 땐 오프닝 끝으로 이동
        if(Integer.parseInt(opStart) <= Integer.parseInt(posMs) && Integer.parseInt(opEnd) >= Integer.parseInt(posMs)) {  // 오프닝 사이에 위치해 있으면
            mm = opEndM;    // 오프닝 끝으로 이동
            ss = opEndS;
        }

        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("next")) {    // "next"일 때
                if((videoM == mm && videoS - ss < 10) || (videoM - 1 == mm && videoS - ss < -50)) {  // 전체 길이에서 10초 미만일 때
                    mm = videoM;    // 비디오 끝으로 이동
                    ss = videoS;
                }
                else {
                    ss += 10;   // 10초 증가
                    if(ss > 59) {   // 59초가 넘으면
                        mm += 1;    // 1분 증가
                        ss -= 60;   // 60초 뺌
                    }
                }
            }
            else {  // "prev"일 때
                if(mm == 0 && ss < 10) {    // 0분 10초 미만일 땐
                    ss = 0; // 비디오 시작으로 감
                }
                else {
                    ss -= 10;   // 10초 감소
                    if(ss < 0) {    // 0초보다 작아지면
                        mm -= 1;    // 1분 감소
                        ss += 60;   // 60초 더함
                    }
                }
            }
            if(ss >= 10) {
                posMs = String.valueOf(mm) + String.valueOf(ss);
            }
            else {
                posMs = String.valueOf(mm) +"0" +String.valueOf(ss);
            }
            if(Integer.parseInt(opStart) <= Integer.parseInt(posMs) && Integer.parseInt(opEnd) >= Integer.parseInt(posMs)) {  // 오프닝 사이에 위치해 있으면
                mm = opEndM;    // 오프닝 끝으로 이동
                ss = opEndS;
            }
        }

        if(mm >= 10) {   // 분이 10보다 크면
            answer += String.valueOf(mm) +":";
        }
        else {
            answer += "0" +String.valueOf(mm)+":";  // 앞에 0 붙여주기
        }

        if(ss >= 10) {  // 초가 10보다 크면
            answer += String.valueOf(ss);
        }
        else {
            answer += "0" +String.valueOf(ss);
        }

        return answer;
    }

    public static void main(String[] args) {
        String video_len = "10:00";
        String pos = "00:03";
        String op_start = "00:00";
        String op_end = "00:05";
        String[] command = {"prev", "next"};
        String res = "";

        PlayVideo p = new PlayVideo();
        res = p.solution(video_len, pos, op_start, op_end, command);

        System.out.println(res);
    }
}