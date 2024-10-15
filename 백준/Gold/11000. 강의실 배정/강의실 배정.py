import heapq
import sys
n = int(sys.stdin.readline().rstrip())

time = []
for _ in range(n):
    start, end = map(int, sys.stdin.readline().rstrip().split())
    time.append((end, start))
time.sort(key=lambda x : x[1])
q = []
heapq.heappush(q, time[0])
for i in range(1, n):
    prev_end, prev_start = heapq.heappop(q)
    end, start = time[i]
    if prev_end <= start: #이전 수업에 사용하던 강의실 배정
        heapq.heappush(q, (end, start))
    else: #새로운 강의실 배정
        heapq.heappush(q, (prev_end, prev_start))
        heapq.heappush(q, (end, start))


print(len(q))