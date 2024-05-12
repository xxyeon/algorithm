from collections import deque
n, m, k, x = map(int, input().split())

node = [[] for _ in range(n)]

for _ in range(m):
  a, b = map(int, input().split())
  node[a-1].append(b)

distence = [-1]* n #-->메모리 초과 원인 -> 수정 1(0)노드에 대한 거리만 저장

# for i in node[0]:
#   distence[i-1] = 1
distence[x-1] = 0


def bfs(x):
  queue = deque()
  queue.append(x)
  while queue:
    v = queue.popleft()
    for i in node[v-1]:
      if distence[i-1] == -1:
        distence[i-1] = distence[v-1] + 1
        queue.append(i)
#최소거리 다 구한후 k와 동일한게 있나 탐색

bfs(x)

result = False
for i in range(n):
  if k == distence[i]:
    print(i+1)
    result = True

if not result:
  print(-1)