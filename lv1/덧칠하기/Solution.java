class Solution {
    public int solution(int n, int m, int[] section) {
        // 벽 길이 n, 롤러 길이 m
        int answer = 0;
        //section[0]부터 m만큼 칠하고 마지막 인덱스까지 칠하면 종료
        int dest = 0;

        for (int idx  : section) {
            if (dest < idx && n > dest) {
                 answer++;
                 dest = idx + (m - 1);
            }
            else 
                continue;
         }
        
        return answer;
    }
}