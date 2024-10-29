#새로운 파일이 생기면서 기존에 있는 파일들의 비용과 새로 만들어진 파일 비용을 비교해야하므로 우선순위 큐 사용
import heapq
import sys
t = int(sys.stdin.readline().rstrip())
total_cost = []
for _ in range(t):
    cost = 0
    q = []
    k = int(sys.stdin.readline().rstrip())
    files = list(map(int, sys.stdin.readline().rstrip().split()))
    for i in range(k):
        heapq.heappush(q, files[i])
    while len(q) > 1:
        cost1 = heapq.heappop(q)
        cost2 = heapq.heappop(q)
        cost += cost1+cost2 #새파일 만드는데 발생하는 비용
        
        heapq.heappush(q, cost1+cost2)
    print(cost)