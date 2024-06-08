from collections import deque

n, m, v = map(int, input().split())

graph = [[] for _ in range(n)]
for _ in range(m):
  
  x, y = map(int, input().split())
  graph[x-1].append(y)
  graph[y-1].append(x)


#각 인접행렬에 대해 정렬해야함.
for i in range(len(graph)):
  graph[i].sort()

def dfs(start, visited):
  visited[start] = 1
  for i in graph[start-1]:
    if visited[i] != 1:
        
        print(i, end= " ")
        dfs(i, visited)

def bfs(start, visited):
  queue = deque()
  queue.append(start)
  visited[start] = 1
  while queue:
    v = queue.popleft()
  
    for i in graph[v-1]:
      if visited[i] != 1:
        print(i, end = " ")
        queue.append(i)
        visited[i] = 1

visited = [0 for _ in range(n+1)]
print(v, end=" ")
dfs(v, visited)
print()
visited = [0 for _ in range(n+1)]
print(v, end=" ")
bfs(v, visited)