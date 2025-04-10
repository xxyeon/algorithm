def solution(n, times):
    answer = 0
    t = max(times)
    end = t * n
    start = min(times)
    while start <= end:
        mid = (start + end) // 2
        p = 0
        for time in times:
            p += mid//time #각 시간에 몇명 검사할 수 있는지
        if p < n:
            start = mid+1
        elif p >= n:
            answer = mid
            end = mid-1
    return answer