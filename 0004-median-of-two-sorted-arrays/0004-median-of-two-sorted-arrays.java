import java.util.*;
class Solution {
    int p1 = 0;
    int p2 = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //두 배열을 합칠 필요가 없다. 두 배열이 정렬되어있다는 가정
        //두 배열을 합친 길이가 n이라고하고면. n이 홀수이면, n/2, 짝수이 n/2+1, n/2의 평균이 middle
        //nums1과 nums2의 포인터를 각각 p1, p2 nums1, nums2에서 포인터를 가지고 제일 작은 수를 찾는다.
        //-> nums1[p1]>nums2[p2]이면 p1을 오른쪽으로 옮기고, 그반대이면 P2 를 옮긴다. => 두 배열에서 가장 작은 요소를 찾을 수 있음
        //m+n이 홀수이면 위 과정을 (n+m+1)/2번 반복 -> (n+m+1)/2 번째로 작은 요소 찾기 (m+n)/2+1
        //짝수이면 (m+n)/2 + 1 번 반복, 마지막 2스탭에서 나온 결과의 평균 구하기
        int len = nums1.length + nums2.length;
        double answer = 0;
        if(len % 2 == 0) {
            //짝수인 경우
            //len/2 len/2+1 두개의 평균
            
            for(int i=0; i < len/2+1; i++) {
                int temp = getMin(nums1, nums2);
                if(i == len/2-1 || i == len/2) {
                    answer += temp;
                }
                
            }
            System.out.println(answer);
            answer /= 2;
        } else {
            //홀수인 경우
            //len/2+1
            for(int i=0;i<len/2 + 1; i++) {
                answer = getMin(nums1, nums2);
            }
        }
        return answer;
    }

    private int getMin(int[] nums1, int[] nums2) {
        if(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] <= nums2[p2]) {
                        int temp = nums1[p1];
                        p1++;
                        return temp;
            } else if(nums2[p2] < nums1[p1]) {
                int temp = nums2[p2];
                p2++;
                return temp;
            }
        } else if(p1 < nums1.length) {
            return nums1[p1++];
        } else if(p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }
}