def solution(name):
    answer = 0
    idx = []
    start = -1
    end = -1
    distance = len(name) - 1
    
    for i, a in enumerate(name):
        # 상하 이동 계산
        answer += min(ord(a) - ord('A'), ord('Z') - ord(a) + 1)

        # A 연속 구간 찾기
        if a == 'A':
            if start == -1:#A시작
                start = i
            end = i
        else:
            if start != -1:
                idx.append((start, end))
                start = -1 #A가 아니면 start = -1로 초기화

    # 마지막이 A로 끝나는 경우 추가
    if start != -1:
        idx.append((start, end))

    # A 구간 회피 경로 계산
    for start, end in idx:
        if start == 0 and end == len(name) - 1: #name 전체가 A일 경우
            return 0
        
        left = start - 1
        right = len(name) - (end + 1)
        
        if start == 0:
            left = 0
        
            
        
        distance = min(distance, left * 2 + right, right * 2 + left)

    return answer + distance
