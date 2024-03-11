import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> idxList = new ArrayList<>();
        //today는 "YYYY.MM.DD
        //약관 종류는 A~Z중 알파벳 대문자 하나
        //유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하
        //privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자
        // 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return

        for (String str : terms) {
            termMap.put(str.split(" ")[0], Integer.parseInt(str.split(" ")[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String key = privacies[i].split(" ")[1];

            LocalDate dT = LocalDate.parse(privacies[i].split(" ")[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            if (LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd")).compareTo(dT.plusMonths(termMap.get(key))) >= 0) {
                idxList.add(i + 1);
            }
        }

        Collections.sort(idxList);

        return idxList.stream().mapToInt(Integer::intValue).toArray();
    }
}