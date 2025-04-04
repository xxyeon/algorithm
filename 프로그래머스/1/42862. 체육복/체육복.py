def solution(n, lost, reserve):
    n_lost = lost.copy()
    
    for l in n_lost:
        if l in reserve:
            reserve.remove(l)
            lost.remove(l)
    lost.sort()
    answer = n - len(lost)
    for l in lost:
        if l-1 in reserve:
            reserve.remove(l-1)
            answer += 1
        elif l+1 in reserve:
            reserve.remove(l+1)
            answer += 1

    return answer