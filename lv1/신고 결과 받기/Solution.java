import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> countMap = new HashMap<>(); // 이름,신고당한 건수
        Map<String, Set<String>> targetMap = new HashMap<>(); // 유저, 누구를 신고했는지 
        Map<String, Integer> resultMap = new HashMap<>(); // 메일 갯수

        for (String str : id_list) {
            targetMap.put(str, new HashSet<String>());
            resultMap.put(str, 0);
        }

        for (String str : report) {
            String reporter = str.split(" ")[0]; // 한놈
            String reportedUser = str.split(" ")[1]; // 당한 놈

            
            if (!targetMap.get(reporter).contains(reportedUser)){
                countMap.put(reportedUser, countMap.getOrDefault(reportedUser, 0) + 1);
                targetMap.get(reporter).add(reportedUser);
            }
            
        }

        for (String key : targetMap.keySet()) {
            Set<String> users = targetMap.get(key);
            for (String user : users) {
                if (countMap.get(user) >= k) {
                    resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = resultMap.get(id_list[i]);
        }

        return answer;
    }
}

//id_list	report	k	result
//["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
//["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
//return 하는 배열은 id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담으면 됩니다.
//한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.