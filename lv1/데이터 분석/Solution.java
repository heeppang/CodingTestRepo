import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = null;
        Map<Integer, int[]> map = new HashMap<>();
        String[] order = new String[] {"code", "date", "maximum", "remain"};
        int idx = 0;
        int idx2 = 0;
        //data[i]의 원소는 [코드 번호(code), 제조일(date)-yyyymmdd , 최대 수량(maximum), 현재 수량(remain)] 형태입니다.
        //data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록

        for (int i = 0; i < order.length; i++) {
            if (order[i].equals(sort_by)) {
                idx = i;
            }
            if (order[i].equals(ext)) {
                idx2 = i;
            }
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i][idx2] < val_ext) {
                map.put(data[i][idx], data[i]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list); //내림차순
        answer = new int[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = map.get(list.get(i));
        }

        return answer;
    }
}