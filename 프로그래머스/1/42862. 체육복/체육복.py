def solution(n, lost, reserve):
    
    both = set(lost) & set(reserve)
    lost = list(set(lost) - both)
    reserve = list(set(reserve) - both)
    lost.sort()
    answer = n - len(lost)
    for l in lost:
        if l-1 in reserve:
            reserve.remove(l-1)
            answer += 1
            continue
        if l+1 in reserve:
            reserve.remove(l+1)
            answer += 1

    return answer