import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = s.split("")[i];
            if (map.containsKey(key)) {
                map.put(key, i);
                answer[i] = i - map.get(key);
            }
            else {
                map.put(key, i);
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}