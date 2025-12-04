import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //재정렬해서 동일한 결과를 묶어서 리턴
        //각 문자열의 길이는 100
        //소문자 영어로 이루어짐. 동일한 문자가 있다면 재정렬해서 동일한 문자열을 만들수 가 있다.
        //ㄴ\
       //재정렬해서 동일한 결과를 묶어서 리턴
        //각 문자열의 길이는 100
        //소문자 영어로 이루어짐. 동일한 문자가 있다면 재정렬해서 동일한 문자열을 만들수 가 있다.
        //ㄴ\
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            StringBuilder sb = new StringBuilder();
            for(char c : ch) {
              sb.append(c);
            }
            map.putIfAbsent(sb.toString(), new ArrayList<String>());
            map.get(sb.toString()).add(s);
        }
        List<List<String>> answer = new ArrayList<>(map.values());
        return answer;
    }
}