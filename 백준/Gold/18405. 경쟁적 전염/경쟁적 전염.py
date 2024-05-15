from collections import deque
n, k = map(int, input().split())
lab = []

for _ in range(n):
  lab.append(list(map(int, input().split())))

s, x, y = map(int, input().split())
  
dx = [-1,1,0,0]
dy = [0,0,-1,1]


#k개 바이러스 퍼트리기
def bfs(): #각 바이러스가 있는 좌표가 들어있는 큐
  global max_num
  while queue:
    x, y, num, sec = queue.popleft() #x,y, 바이러스번호, 퍼진 시간
    if s == sec:
      return
    #번호가 가장 큰 바이러스가 퍼질때 1초가 지난다
    # if num == max_num:
    #   sec += 1 #큐에 번호가 가장 큰 바이러스가 2개이상있으면 다 못퍼트리게 되고 종료된다.
    #각 바이러스의 상하좌우가 비어있는지 확인 비어있으면 퍼트리고 큐에 추가
    for i in range(4): #매 초마다 상하좌우로 바이러스 퍼트림
      nx = x + dx[i]
      ny = y + dy[i]
      
      if nx >= n or ny >= n or ny < 0 or nx <0:
        continue
      if lab[nx][ny] == 0:
        lab[nx][ny] = num
        queue.append((nx,ny, num, sec + 1))#바이러스가 몇초에 퍼지는지 확인하기 위해 sec 추가

queue = deque()
#낮은 번호 순으로 큐에 저장해야함.
for v in range(1, k+1):
  for i in range(n):
    for j in range(n):
      if lab[i][j] == v:
        queue.append((i,j, v, 0)) #x,y, 바이러스 번호

bfs()

if lab[x-1][y-1] == 0:
  print(0)
else:
  print(lab[x-1][y-1])