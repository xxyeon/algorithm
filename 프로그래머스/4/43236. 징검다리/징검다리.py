def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    start = 0
    end = distance
    while start <= end:
        #제거한 돌의 수가 n보다 크다면 mid 줄이기, 작다면 mid 늘리기 (돌을 더 많이 제거할 수 있도록 최소거리 늘리기)
        mid = (start + end) // 2
        cnt = remove_rocks_cnt(mid, rocks, distance)
        if cnt > n:
            end = mid - 1
        elif cnt <= n:
            answer = mid
            start = mid + 1
        # else:
        #     #제거한 돌의 수가 동일하면 mid보다 더 늘릴 수 있는지 확인 (최소 중 최대를 구해야함)
        #     answer = mid
        #     start = mid + 1
    
    return answer

def remove_rocks_cnt(mid, rocks, distance):
    now = 0
    remove = 0
    for i in range(len(rocks)):
        gap = rocks[i] - now
        if gap < mid: #다음 돌 제거, mid 최솟값이라고 가정하고 mid 되기 위해 몇개의 돌을 제거해야하는지 count
            remove += 1
            continue
        else:
            now = rocks[i]
            
    #마지막 돌 제거을 제거해도 mid 보다 작다면
    if distance - now < mid:
        remove += 1 #마지막 돌 제거
    return remove