from itertools import combinations
from collections import deque
n, m = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


empty = []
for i in range(n):
  for j in range(m):
    if lab[i][j] == 0:
      empty.append((i,j))
copy_lab = [[0] * m for _ in range(n)] #원본 연구소 데이터 유지하기 위해 생성.
empty_collections = list(combinations(empty,3))
max = 0
#각 기둥 조합 lab에 적용 후 바이러스 퍼트리고 최대 안전지역인 거 출력
def bfs(x, y): #바이러스 퍼트리기위한 bfs
  queue = deque()
  queue.append((x,y))
  while queue:
    # print(queue.popleft())
    now_x, now_y = queue.popleft()
    for i in range(4):
      nx = now_x + dx[i]
      ny = now_y + dy[i]
      if nx < 0 or ny < 0 or nx >= n or ny >= m:
        continue
      if copy_lab[nx][ny] == 0: #아직 바이러스가 안퍼졌다면
        copy_lab[nx][ny] = 2
        queue.append((nx, ny))#바이러스의 상하좌우
      
for first, sec, third in empty_collections:
  #바이러스 퍼트리기 전에 연구소 원본 데이터 유지할 수 있도록 새로운 연구소 복사
  for i in range(n):
    for j in range(m):
      copy_lab[i][j] = lab[i][j]

  #복사된 연구소에 기둥세우기
  copy_lab[first[0]][first[1]] = 1
  copy_lab[sec[0]][sec[1]] = 1
  copy_lab[third[0]][third[1]] = 1
  
  #바이러스 퍼트리기
  for i in range(n):
    for j in range(m):
      if lab[i][j] == 2:
        bfs(i,j)
  cnt = 0
  #안전구역 세기
  for i in range(n):
    for j in range(m):
      if copy_lab[i][j] == 0:
        cnt += 1

  #안전구역 더 많은 것으로 max 교체
  if max < cnt:
    max = cnt

 
print(max)