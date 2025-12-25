import java.util.*;
class Solution {

    int[] arr;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //m+n짝수면 (m+n) / 2 - 1, (m+n) / 2 인덱스 요소 더한후 / 2
        // 홀수면 (m+n) / 2 인덱스 요소
        //이분탐색으로 본인 자리 찾아가기
        //하나의 배열로  -> O(n+m) 링크드리스트 요소 탐색 O(N) bianrysearch -> log(n)
        //m+n정렬 -> 퀼정렬 
        //두 배열을 하나로 합쳐야함.
        int len = nums1.length+nums2.length;
        arr = new int[len];
        for(int i=0;i<nums1.length;i++) {
            // System.out.println(arr.length);
            arr[i] = nums1[i];
        }
        for(int i=nums1.length; i<len; i++) {
            arr[i] = nums2[i-nums1.length];
        }

        Arrays.sort(arr);
        double answer = len%2 == 0 ? (double)(arr[len/2-1] + arr[len/2]) / 2 : arr[len/2];
        return answer;
    }
}