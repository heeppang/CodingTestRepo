import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        //Map에 각 스펠링 별 최소값을 담는다
        Map<Character, Integer> cntMap = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); ++i) {
                if (cntMap.containsKey(key.charAt(i))) {
                    cntMap.put(key.charAt(i), Math.min(i + 1, cntMap.getOrDefault(key.charAt(i), 100)));
                }
                else {
                    cntMap.put(key.charAt(i), i + 1);
                }
            }
        }

        for (int k = 0; k < targets.length; ++k) {
            String target = targets[k];
            for (int i = 0; i < target.length(); ++i) {
                if (cntMap.containsKey(target.charAt(i))) {
                    answer[k] += cntMap.get(target.charAt(i));
                }
                else {
                    answer[k] = -1;
                    break; 
                }
            }
        }
        return answer;
    }
}