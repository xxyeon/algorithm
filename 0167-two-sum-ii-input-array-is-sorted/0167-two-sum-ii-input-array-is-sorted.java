class Solution {
    int[] answer = new int[2];
    public int[] twoSum(int[] numbers, int target) {
        //오름차순으로 정렬된 numbers 
        //target이 되는 두 수의 인덱스 + 1를 찾아라
        //한개의 답만 나옴. 동일한 요소 2개를 택할 수 없다.
        //numbers의 길이최대 3만-> 2중 for문 사용하면 9억이므로 시간초과 -> o(N)으로풀어야함
        //number 요소 범위 -1000 ~ 1000-> int 충분
        search(0, numbers.length-1, numbers, target);
        return answer;
    }
    private void search(int start, int end, int[] numbers, int target) {
        while(start <= end) {
            //start = 0, end = numbers.length
            //temp > target -> end -= 1
            //temp < target start + 1
            int temp = numbers[start] + numbers[end];
          
            if(temp > target) {
                // start += 1;
                end -= 1;
            } else if(temp < target) {
                start += 1;
            } else if(temp == target) {
                answer[0] = start + 1;
                answer[1] = end+ 1;
                break;
            }
        }
    }
}