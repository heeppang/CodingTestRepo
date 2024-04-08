import java.util.*;
class Solution {
  //배열 내 중복 이슈가 있다면 HashSet을 썼겠지만 그냥 List 활용해서 중복은 피함
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match = 0;
        int zero = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : win_nums) {
            list.add(num);
        }

        for (int lotto : lottos) {
            if (lotto == 0) 
            {
                zero++;
            }
            else if (list.contains(lotto)) {
                match++;
            }    
        }

            

        answer[0] = getRank(zero + match);
        answer[1] = getRank(match);

        return answer;
    }

    public int getRank(int matching) {
        if (matching >= 2 && matching <= 6) {
            return 7 - matching;
        } else {
            return 6;
        }
    }
}
