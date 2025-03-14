def solution(citations):
    answer = 0
    for h in range(10001):
        upper = 0
        rest = 0
        for citation in citations:
            if h <= citation:
                upper += 1
            elif h >= citation:
                rest += 1
        if upper >= h and rest <= h:
            answer = max(answer, h)
    return answer