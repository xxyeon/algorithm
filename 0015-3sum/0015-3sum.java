import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        //nums[i] + nums[j] + nums[k] == 0. 인 서로다른 요소를 리턴
        //결과는 동일한 결과를 반환하면 안됨, 리턴값이 여러개일 수 있다.
        //nums의 길이 = 3000 -> 3중 반복문임 -> 100억을 넘어감 -> 시간 초과 이중 for -> 9백만 -> 가능 int 범위 가능
        //2개 요소 지정하고 인덱스 반환이 아니므로 정렬 가능 target 지정 -> for문으로 각 요소를 타켓으로 설정
        //그 다음에 투포인터로 -target이 되는 값을 구하기
        // -4, -1,-1 0, 1, 2 
        //Integer_MAX_VALUE 이면 사용 전, 0이면 모두 사용 -num 이면 양수 num 사용 가능, num이면 음수 사용 가능
        
        Arrays.sort(nums); //오름차순
        for(int i=0;i<nums.length - 2; i++) {
            
            int target = nums[i];
            if(target > 0 || (i > 0 &&target == nums[i-1])) {
                continue;
            };

            int start = i+1; //i와 같은 수 없 음
            int end = nums.length-1; //i와 같은 수 없음
            //000000000 100kb
            
            while(start < end && end < nums.length) {
                int num = nums[start] + nums[end];
                
                int ans = target + num;
                if(ans == 0) {
                    
                    //아직 두개 또한 한개 사용 가능하면
                    answer.add(new ArrayList<>());
                    answer.get(answer.size()-1).add(target);
                    answer.get(answer.size()-1).add(nums[start]);
                    answer.get(answer.size()-1).add(nums[end]);

                    //이미 정렬되어 있으므로 현재 start와 다음 start 가리키는 값이 다를때가지 반복
                    start += 1;
                    while (nums[start - 1] == nums[start] && start < end){
                        start += 1;
                    }

                }else if(ans > 0) {
                    end -= 1;
                }else if(ans < 0) {
                    start += 1;
                }
            }
        }
        return answer;
        
    }
}