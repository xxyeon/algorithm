m, n = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort() #과자 길이 정렬 후 이분 탐색 

#과자 길이를 대상으로 이분 탐색
answer = 0
start, end = 1, lst[-1]

while start <= end: 
    mid = (start + end) // 2

    cnt = 0
    for i in range(n): #과자길이 mid에 대해서 몇명에게 나눠줄 수 있는지 count
        cnt += lst[i] // mid
    if cnt < m: #나눠줄수있는 과자가 조카 수보다 적다면 -> 과자 길이 줄이기
        end = mid - 1
    elif cnt >= m: #조카 수보다 많이 나눠줄 수 있다면 -> 과자길이 늘리기
        answer = mid
        start = mid + 1

print(answer)