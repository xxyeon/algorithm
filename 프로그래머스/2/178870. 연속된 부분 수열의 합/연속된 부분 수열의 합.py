def solution(sequence, k):
    answer = []
    #투포인터 사용 start, end
    #start와 end 를 0으로 시작해서 합계가 k 보다 작다면 end를 1씩 증가
    # k == 합계이면 원소 개수 비교해서 더 작은 원소 개수로 치환
    # start = 1로 했을때, start=3으로 했을 때, start = 4로 했을 때 위 과정 반복
    end = 0
    n = len(sequence)
    invertal = n
    idx = []
    sum = 0
    for start in range(len(sequence)):
        while sum < k and end < n:
            sum += sequence[end]
            end += 1
        #k==sum을 만족했을 때 요소길이 비교
        if sum == k and invertal > end-1-start:
            #최소 인덱스 저장
            idx = [start, end-1]
            invertal = end-1-start
        #start로 start부터 len(sequence)-1까지 모두 탐색해서 합계가 k인 요소의 개수를 찾은 후 다음 start로 변경후 위 과정을 반복해야하므로 sum에서 현재 start를 빼준다
        # start =0 일때 start =1 일때....
        sum -= sequence[start]
        
    return idx