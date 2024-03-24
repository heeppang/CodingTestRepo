import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> ing = new Stack<>(); // List로 했다가 망해봄. Stack의 후입선출..
        for (int i : ingredient)  {
            ing.push(i);

            if (ing.size() >= 4) {
                if (ing.get(ing.size()-1) == 1 &&
                ing.get(ing.size()-2) == 3 &&
                ing.get(ing.size()-3) == 2 &&
                ing.get(ing.size()-4) == 1) {
                    answer++;

                    ing.pop();
                    ing.pop();
                    ing.pop();
                    ing.pop();
                }
            }
        }

        

        return answer;
    }
}