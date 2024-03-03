import java.util.*;

class Solution {
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0; // 가장 많은 선물 갯수

        HashMap<String, Integer> giftMap = new HashMap<>(); // 선물지수
        HashMap<String, HashMap<String, Integer>> giveAndTake = new HashMap<>(); // 누구한테 몇개줬는지.. 개빡치네
        HashMap<String, Integer> rankMap = new HashMap<>(); // 최종적으로 갯수 저장

        // 친구 이름과 선물 갯수를 저장한다.
        for (String name : friends) {
            giftMap.put(name.trim(), 0);
            giveAndTake.put(name.trim(), new HashMap<>());
            rankMap.put(name.trim(), 0);
        }

        for (String fromTo : gifts) {
            String from = fromTo.split(" ")[0].trim();
            String to = fromTo.split(" ")[1].trim();

            if (giftMap.containsKey(to)) {
                giftMap.put(to, giftMap.get(to) - 1); // 받았으면 선물지수 -1
            }
            if (giftMap.containsKey(from)) {
                giftMap.put(from, giftMap.get(from) + 1); // 줬으면 선물지수 +1
            }
            
            giveAndTake.get(from).put(to, giveAndTake.get(from).getOrDefault(to, 0) + 1);
        } // 전체적인 갯수는 여기서 끝
        
        // 1. 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
        // 2. 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
        // 3. 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {
            String friend1 = friends[i].trim();
            list.add(friend1);
            for (int j = 0; j < friends.length; j++) {
                String friend2 = friends[j].trim();
                //하 디버깅하니까 두번 돌아버림 ^^ 돌아버리겠네
                if (!list.contains(friend2)) { // 둘이 동일 인물이 아닐 때
                    int giftCount1 = giveAndTake.get(friend1).getOrDefault(friend2, 0);
                    int giftCount2 = giveAndTake.get(friend2).getOrDefault(friend1, 0);
                    // 1. 서로 주고 받은 적이 없는 경우
                    if (giftCount1 == giftCount2)  {
                        if (giftMap.get(friend1) > giftMap.get(friend2)) {
                            rankMap.put(friend1, rankMap.getOrDefault(friend1, 0) + 1);
                        }
                        else if (giftMap.get(friend2) > giftMap.get(friend1)) {
                            rankMap.put(friend2, rankMap.getOrDefault(friend2, 0) + 1);
                        }
                    }
                    // 2. 서로 주고 받은 적이 있는 경우
                    else {
                        if (giftCount1 > giftCount2) {
                            rankMap.put(friend1, rankMap.getOrDefault(friend1, 0) + 1);
                        }
                        else if (giftCount2 > giftCount1){
                            rankMap.put(friend2, rankMap.getOrDefault(friend2, 0) + 1);
                        }
                    }
                }
            }
        }

        for (int i : rankMap.values()) {
            if (answer < i) answer = i;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] friends = new String[] {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.println(solution(friends, gifts));
    }
}