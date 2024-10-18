import heapq
import sys
#파이썬 heapq는 최소힙, 최대힙으로 사용하려면 (-x, x) 로 push
n = int(sys.stdin.readline().rstrip())
q = []
for _ in range(n):
    x = int(sys.stdin.readline().rstrip())
    if x == 0:
        if len(q) == 0:
            print(0)
            continue
        print(-heapq.heappop(q))
    else:
        heapq.heappush(q, -x)