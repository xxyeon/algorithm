class Solution {
    int cntZero = 0;
    int cntOne = 0;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        //2^10 n=10 -> arr크기 1024 * 1024 -> 2^20 => 완탐 가능
        //s영역을 나눠서 각각 탐색. 모두 동일하면 탐색 대상에서 제외, 아닌 것은 다시 4등분 후 탐색
        //압축 대상이 되는 공간이 나눠진다면 4등분됨 -> 동일한 압축 방식 적용, 전체 영역 크기가 전달되어야함.
        //나누는 크기 -> 전체길이 / 2
        //0~전체길이 / 2-1 -> 전체길이 / 2 ~
        compress(0,0,arr.length, arr);
        answer[0] = cntZero;
        answer[1] = cntOne;
        
        return answer;
    }
    private void compress(int x, int y, int len, int[][] arr) {
        if(len == 0) {
            //압축 대상이 없다면
            return;
        }
        //정사각형 한변의 길이 len
        int num = arr[x][y];
        boolean flag = true;
        for(int i = x; i< x+len;i++) {
            for (int j=y;j<y+len;j++) {
                if(num != arr[i][j]) {
                    //압축하지 못하면
                    flag = false;
                    break;
                }
            }
            if(flag == false) {
                break;
            }
        }
        if(flag == true) {
            //압축 성공
            if(num == 0) {
                cntZero++;
            }else if(num==1) {
                cntOne++;
            }
        } else {
            //다시 4등분 후 압축
            //압축실패
            int next = len/2; 
            compress(x, y, next, arr);
            compress(x+next, y, next, arr);
            compress(x, y+next, next, arr);
            compress(x + next, y + next, next, arr);
        }
        
        
    }
}