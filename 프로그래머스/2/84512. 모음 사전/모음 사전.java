class Solution {
    int count = 0;         // 전체 단어 생성 순서 카운터
    int result = 0;        // 정답 저장
    boolean isFound = false;

    public int solution(String word) {
        dfs("", word);
        return result;
    }

    private void dfs(String current, String target) {
        if (isFound) return;

        // 매번 단어를 하나 만들 때마다 count 증가
        if (!current.isEmpty()) count++;

        // 찾으면 count를 결과로 저장
        if (current.equals(target)) {
            result = count;
            isFound = true;
            return;
        }

        // 최대 길이 5까지만
        if (current.length() == 5) return;

        for (char c : "AEIOU".toCharArray()) {
            dfs(current + c, target);
        }
    }
}
