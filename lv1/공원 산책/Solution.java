import java.util.*;;

class Solution {
    static Map<String, Integer> go;
    static {
        go = new HashMap<>();
        go.put("E", 1); // +1
        go.put("W", -1); // -1
        go.put("N", -1); // +1
        go.put("S", 1); //
    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String[][] parkPath = new String[park.length][park[0].split("").length]; // 지도처럼...

        int height = 0;
        int width = 0;

        // 시작점 셋팅 - 3번 사례를 보면 항상 0,0 은 아님
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].split("").length; j++) {
                parkPath[i][j] = park[i].split("")[j];
                if (park[i].split("")[j].equals("S")) {
                    height = i; //h
                    width = j; //w
                }
            }
        }

        for (String route : routes) {
            String way = route.split(" ")[0];
            int far = Integer.parseInt(route.split(" ")[1]);
            switch (way) {
                case "E", "W":
                    width = move(parkPath, height, width, way, far);
                    break;
                case "N","S":
                    height = move(parkPath, height, width, way, far);
                    break;
            }
        }
        answer[0] = height;
        answer[1] = width;

        return answer;
    }

    // 주어진 방향으로 거리만큼 이동
    int move(String[][] parkMap, int height, int width, String way, int far) {
        int moves = far * go.get(way);
        if (way.equals("E") || way.equals("W")) {
            int newWidth = width + moves;
            if (newWidth >= 0 && newWidth < parkMap[0].length) {
                if (moves < 0) {
                    for (int i = width; i >= width + moves; i--) {
                        if (parkMap[height][i].equals("X")) {
                            return width;
                        } 
                    }
                } else {
                    for (int i = width; i <= width + moves; i++) {
                        if (parkMap[height][i].equals("X")) {
                            return width;
                        } 
                    }
                }
                return newWidth;
            }
            else return width;
        }
        else {
            int newHeight = height + moves;
            if (newHeight >= 0 && newHeight < parkMap.length) {
                if (moves < 0) {
                    for (int i = height; i >= height + moves; i--) {
                        if (parkMap[i][width].equals("X")) {
                            return height;
                        } 
                    }
                } else {
                    for (int i = height; i <= height + moves; i++) {
                        if (parkMap[i][width].equals("X")) {
                            return height;
                        } 
                    }
                }
                return newHeight;
            } 
            else return height;
        }
    }
}