import heapq
INF = int(1e9)
n, v = map(int, input().split())
k = int(input())

graph = [[] for _ in range(n)]
distance = [INF] * (n+1)
distance[k] = 0

for _ in range(v):
  u, v, w = map(int, input().split())
  graph[u-1].append((v, w))
  
def dijkstra(start):
  q = []
  heapq.heappush(q, (0, start))
  while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
      continue
    for i in graph[now-1]:
      cost = dist + i[1]
      if cost < distance[i[0]]:
        distance[i[0]] = cost
        heapq.heappush(q,(cost, i[0]))
dijkstra(k)
for i in range(1, n+1):
  if distance[i] == INF:
    print("INF")
  else: 
    print(distance[i])
