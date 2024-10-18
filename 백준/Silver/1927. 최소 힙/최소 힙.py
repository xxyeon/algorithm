import heapq
import sys
n = int(sys.stdin.readline().rstrip())
q = []
for _ in range(n):
    x = int(sys.stdin.readline().rstrip())
    if x == 0:
        if len(q) == 0:
            print(0)
            continue
        print(heapq.heappop(q))
    else:
        heapq.heappush(q, x)