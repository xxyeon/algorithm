#그래프이론? 부모노드 저장
#union find연산을 해서 부모 노드 찾아서 저장
#부모 노드는 인접행렬로 주어진 정보로 저장하면 될듯
from collections import deque
n = int(input())
parent = [-1 for i in range(n)]

info = list(list(map(int, input().split())) for _ in range(n))

lst = [[] for i in range(n)]
#인접 리스트로 변경
for i in range(n):
  for j in range(n):
    if info[i][j] == 1:
      lst[i].append(j)

answer = [[0] * n for _ in range(n)]


# #완전 탐색해서 노드를 방문할 때마다 행렬에 1로 표시
def bfs(answer, i): #i를 통해 갈 수 있는 노드탐색
  q = deque()
  q.append(i)
  while q:
    now = q.popleft()
    for j in lst[now]:
      if visited[j] == False:
        visited[j] = True
        answer[i][j] = 1
        q.append(j)

for i in range(n): #각 노드를 하나씩 다 방문하면서 visited를 중복계산하는 경우가 있긴함
  visited = [False] * n
  bfs(answer, i)#i로 bfs돌려소 visited가 True이면 i로 가는 길이 양수인 경로가 있다는 것이다.
  for j in range(n):
    if visited[j]:
      answer[i][j] = 1
  #만약i로 시작해서 visited[i]사 True이면 i->...->i로 cycle
  if visited[i] == True:
    answer[i][i] = 1
  

for i in answer:
  print(*i)
