import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scoreMap = new HashMap<>();
        int[] answer = new int[photo.length];
        for (int i = 0; i < yearning.length; ++i) {
            scoreMap.put(name[i], yearning[i]);
        }

        int j = 0;
        for (String[] element : photo) {
            for (String str : element) {
                answer[j] += scoreMap.getOrDefault(str, 0);
            }
            j++;
        }

        for (int i = 0; i < name.length; ++i) {
            if (yearnMap.containsKey(name[i])) {
                answer[i] = yearnMap.get(name[i]);
            }
        }

        return answer;
    }
}