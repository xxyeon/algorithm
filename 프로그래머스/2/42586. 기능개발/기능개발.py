from collections import deque
def solution(progresses, speeds):
    answer = []
    #각 배포마다 몇개의 기능이 배포되는지..
    #각 기능마다 몇일 후 배포가 가능한지 저장하고 앞에서부터 배포해보기(큐 사용)
    #앞에서 꺼내보면서 다음 기능도 배포할 수 있다면 cnt 늘리기
    q = deque([])
    for p, s in zip(progresses, speeds):
        rest = (100-p)//s
        if (100-p)%s != 0:
            rest += 1
        q.append(rest)
        
    temp = []
    idx = 0
    while q:
        day = q.popleft()
        if not temp:
            temp.append([day])
        else:
            if temp[idx][0] < day:
                temp.append([day])
                idx += 1
            else:
                temp[idx].append(day)
    answer = list(map(len, temp))
        
    return answer