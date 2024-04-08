//별것도 아닌데 잠깐 고생을 하였다....
//다른 사람 풀이에 45에서 마이너스 들어가는 걸 보고 충격받음
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] isThere = new boolean[10];

        for (int i = 0; i < isThere.length; i++){
            isThere[i] = false;
        }

        for (int num : numbers) {
            isThere[num] = true;
        }

        for (int i = 0; i < isThere.length; i++) {
            if (isThere[i] == false)
                answer += i;
        }
        
        return answer;
    }
}
