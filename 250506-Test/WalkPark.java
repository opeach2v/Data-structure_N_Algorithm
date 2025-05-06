public class WalkPark {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int h = 0, w = 0;   // 상하, 좌우(처음엔 시작 지점 좌표 가짐)

        // 시작 위치 찾기
        find:
        for(int i = 0; i < park.length; i++) {
            // 시작지점이 포함되어있는지 검사
            if(park[i].contains("S")) { // S가 포함되어 잇으면
                h = i;  // 행 시작 위치 저장
                String[] location = park[i].split("");
                for(int j = 0; j < park[i].length(); j++) {
                    if(location[j].equals("S")) {
                        w = j;  // 열 시작 위치 찾음
                        break find;
                    }
                }
            }
        }

        // 본격적 이동
        for(int i = 0; i < routes.length; i++) {
            String[] move = routes[i].split(" ");   // op와 이동 거리로 나뉨
            
            noMove:
            switch (move[0]) {
                case "N":   // 북쪽으로 이동
                    if(h > 0) { // h가 0이 아니어야 위로 이동 가능
                        int mh = Integer.parseInt(move[1]); // 이동할 거리
                        if(h - mh >= 0) {
                            // 이동 위치에 잇을 장애물 판단
                            for(int m = 1; m <= mh; m++) {   // 거리만큼 반복
                                if(h - m == 0) break;   // 반복 과정에 0이 되면 빠져나가기
                                String[] location = park[h - m].split("");
                                if(location[w].equals("X")) {   // 장애물이면
                                    break noMove;  // 못 감
                                }
                            }
                            h -= mh;
                        }
                        else break;
                    }
                    break;
                case "S":   // 남쪽으로 이동
                    if(h < park.length - 1) { // h가 park.length - 1이 아니어야 아래로 이동 가능
                        int mh = Integer.parseInt(move[1]);   // 이동할 거리
                        if(h + mh <= park.length - 1) {
                            // 이동 위치에 잇을 장애물 판단
                            for(int m = 1; m <= mh; m++) {   // 거리만큼 반복
                                if(h + m == park.length - 1) break;   // 반복 과정에 끝이 되면 빠져나가기
                                String[] location = park[h + m].split("");
                                if(location[w].equals("X")) {   // 장애물이면
                                    break noMove;   // 못 감
                                }
                            }
                            h += mh;
                        }
                        else break;
                    }
                    break;
                case "W":   // 서쪽으로 이동
                    if(w > 0) { // w가 0이 아니어야 왼쪽으로 이동 가능
                        int mw = Integer.parseInt(move[1]); // 이동할 거리
                        if(w - mw >= 0) {
                            // 이동 위치에 잇을 장애물 판단
                            for(int m = 1; m <= mw; m++) {   // 거리만큼 반복
                                if(w - m == 0) break;   // 반복 과정에 0이 되면 빠져나가기
                                String[] location = park[h].split("");
                                if(location[w - m].equals("X")) {   // 장애물이면
                                    break noMove;  // 못감
                                }
                            }
                            w -= mw;
                        }
                        else break;
                    }
                    break;
                case "E":   // 동쪽으로 이동
                    if(w < park[h].length() - 1) { // w가 park[h].length() - 1이 아니어야 오른쪽으로 이동 가능
                        int mw = Integer.parseInt(move[1]); // 이동할 거리
                        if(w + mw <= park[h].length() - 1) {    // 공원을 넘어가지 않을 때만 이동
                            // 이동 위치에 잇을 장애물 판단
                            for(int m = 1; m <= mw; m++) {   // 거리만큼 반복
                                if(w + m == park[h].length() - 1) break;   // 반복 과정에 끝이 되면 빠져나가기
                                String[] location = park[h].split("");
                                if(location[w + m].equals("X")) {   // 장애물이면
                                    break noMove;  // 못 감
                                }
                            }
                            w += mw;
                        }
                        else break;
                    }
                    break;
                default:
                    break;
            }
        }

        answer[0] = h;  // 세로 좌표
        answer[1] = w;  // 가로 좌표
        return answer;
    }

    public static void main(String[] args) {
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};
        int[] res = {};

        WalkPark w = new WalkPark();
        res = w.solution(park, routes);
    }
}