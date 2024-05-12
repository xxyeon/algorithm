from collections import deque

n, m = map(int, input().split())
lst = []
for _ in range(n):
  lst.append(list(map(int, input())))

cnt = 0
def dfs(x, y, graph):
  if 0>x or x>n-1 or y<0 or y>m-1:
    return False
  if graph[x][y] == 1:
    return False
  
 
  elif graph[x][y] == 0:
    graph[x][y] = 1

  #상 하 좌 우 -> 해당 노드의 상하좌우를 재귀로 부르면서 확인해준다. (인접노드 확)
    dfs(x-1, y, graph)
    dfs(x+1, y, graph)
    dfs(x, y-1, graph)
    dfs(x, y+1, graph)
    return True

for i in range(n):
  for j in range(m):
    if dfs(i,j,lst):
      cnt += 1

print(cnt)
  
