import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        //첫째자리가 가장큰거 순으로 int를 String으로 바꿔서 정렬
        String[] arr = Arrays.stream(numbers).boxed().map(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) { 
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if (arr[0].equals("0")){
            return "0";
        }
        
        for (String s : arr) {
            answer += s;
        }
        return answer;
    }
}