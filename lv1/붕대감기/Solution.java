class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량을 담은 1차원 정수 배열 bandage
        //최대 체력을 의미하는 정수 health
        //몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열 attacks
        int combo = 0; // 콤보
        int count = 0; // 공격시기용
        int health2 = health; //체력용
        int lastAttack = attacks[attacks.length - 1][0]; //플레이가 몇초인지...

        for (int i = 0 ; i <= lastAttack; i++) {
            if (i == attacks[count][0]) {
                combo = 0;
                health2 -= attacks[count][1];
                count++;
                if (health2 <= 0) return -1;
            }
            else {
                if (health2 < health) combo++;
                health2 += bandage[1];

                if (combo == bandage[0]) {
                    health2 += bandage[2];
                    combo = 0;
                }
                else if (health2 >= health) combo = 0;
                if (health2 > health) health2 = health;
            }
        }
        
        return health2;
    }
}