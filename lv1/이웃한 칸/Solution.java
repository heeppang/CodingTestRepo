import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int N = board.length;
        if (N <= 1)
            return 0;

        /*
         * 1. 정수를 저장할 변수 n을 만들고 board의 길이를 저장합니다.
         * 2. 같은 색으로 색칠된 칸의 개수를 저장할 변수 count를 만들고 0을 저장합니다.
         * 3. h와 w의 변화량을 저장할 정수 리스트 dh, dw를 만들고 각각 [0, 1, -1, 0], [1, 0, 0, -1]을 저장합니다.
         * 4. 반복문을 이용해 i 값을 0부터 3까지 1 씩 증가시키며 아래 작업을 반복합니다.
         * 4-1. 체크할 칸의 h, w 좌표를 나타내는 변수 h_check, w_check를 만들고 각각 h + dh[i], w + dw[i]를
         * 저장합니다.
         * 4-2. h_check가 0 이상 n 미만이고 w_check가 0 이상 n 미만이라면 다음을 수행합니다.
         */

        int[] dh = new int[] { 0, 1, -1, 0 };
        int[] dw = new int[] { 1, 0, 0, -1 };
        Map<Integer, Map<Integer, Integer>> path = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h_check = h + dh[i];
                int w_check = w + dw[i];

                if ((N > h_check && h_check >= 0) && (N > w_check && w_check >= 0)) {
                    if (!(h == h_check && w == w_check) && board[h][w].equals(board[h_check][w_check])) {
                        Map<Integer, Integer> innerMap = new HashMap<>();
                        innerMap.put(h_check, w_check);

                        if (!path.containsValue(innerMap)) {
                            answer++;
                            path.put(answer, innerMap);
                        }
                    }
                }
            }
        }

        return answer;
    }
}