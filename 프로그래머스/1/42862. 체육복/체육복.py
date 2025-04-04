def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()

    # 여벌 체육복이 있지만 도난당한 학생 찾기
    both = set(lost) & set(reserve)
    lost = list(set(lost) - both)
    reserve = list(set(reserve) - both)

    answer = n - len(lost)

    for l in lost:
        if l - 1 in reserve:
            reserve.remove(l - 1)
            answer += 1
        elif l + 1 in reserve:
            reserve.remove(l + 1)
            answer += 1

    return answer
