class Solution {
    public int solution(String s) {
        //이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 
        //처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다
        //s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
        //만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
        int answer = 0;
        char front = s.charAt(0);
        int same = 0;
        int diff = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (front == ch) {
                same++;
            }
            else {
                diff++;
            }

            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
                if (i + 1 < s.length()) {
                    front = s.charAt(i + 1);
                }
            } 
            else if (i == s.length() - 1) {
                answer++;
            }
        }
        return answer;
    }
}