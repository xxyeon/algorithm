#MST
#우선순위큐?
import heapq
#(가중치, 노드)
v, e = map(int, input().split())
graph = [[] for _ in range(v+1)]
q = [] #우선순위큐
visited = [False] * (v+1)
visited[0] = True
for i in range(e):
    v1, v2, cost = map(int, input().split())
    graph[v1].append((cost, v2))
    graph[v2].append((cost, v1))



#이런식으로 풀면도지않을까..?
#최소 스패닝 트리 한번 최초 방문이 최소 cost를 이용한 것임(우선순위큐를 사용한다면) 방문을 했다면 다시 방문할 필요가 없음

def bfs(start, total_cost):
    heapq.heappush(q, (0, start))
 
    while q:
        cost, node = heapq.heappop(q)
        if visited[node]:
            continue
        visited[node] = True 
        total_cost += cost
        for cost, v in graph[node]: #각 node에 연결된 간선을 cost가 적은 순으로 탐색하므로 한번 방문했으면 다시 검사하지 않아도됨. 해당 노드를 방문했다는 것은 이미 해당 노드에 연결된 간선 중에서 최소 비용으로 계산이 되었음을 의미함
            if visited[v] == False:
                heapq.heappush(q, (cost, v))
    return total_cost
        
        
answer = bfs(1, 0)
print(answer)