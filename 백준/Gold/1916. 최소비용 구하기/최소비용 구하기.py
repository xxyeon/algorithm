import sys
import heapq
input = sys.stdin.readline

n = int(input())
m = int(input())

distance = [int(1e9)] * (n+1)
#도시 간 비용정보 2차원 배열에 저장
data = list([] for _ in range(n+1))

#주어진 노드간 비용 저장
for _ in range(m):
    a, b, c = map(int, input().split())
    data[a].append((b, c))

a, b = map(int, input().split())

def dijkstra(start):
    q = []
    #자기자신과의 비용 0
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q) #start에서 now까지의 거리(dist)
        if distance[now] < dist: #distance에 있는 비용이 큐에서 꺼낸 비용보다 작다면 다름 요소 큐에서 꺼내기
            continue
        for i in data[now]: #현재 노드와 인접한 노드 확인
            cost = dist + i[1] #now -> i[0] 현재 노드를 거쳐서 다른 노드로 이동하는 비용이 더 작을 경우 distance update
            if distance[i[0]] > cost: 
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(a)
print(distance[b])
