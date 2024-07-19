# 몸에 부딪히거나 벽에 닿으면 게임끝
#L:왼쪽회전, D:오른쪽회전
#뱀의 방향이 상하좌우 인지에 따라 방향전환이 다름
#상하좌우 = 0123
from collections import deque
dic = {"상":{"L":"좌", "D":"우"}, "하":{"L":"우", "D":"좌"},
      "좌":{"L":"하", "D":"상"},"우":{"L":"상", "D":"하"}}
dx = [-1,1,0,0]
dy = [0,0,-1,1]
  
  
n = int(input())
map = [[0] * n for _ in range(n)]


k = int(input())
#map에 사과 위치시키기
for _ in range(k):
  row, col = input().split()
  map[int(row)-1][int(col)-1] = 1
  
l = int(input())
#큐에 방향 변환 정보 넣기
q = deque()
for _ in range(l):
  x, c = input().split()
  q.append((int(x), c))

# x, y = 0, 0 #현재 뱀의 위치
# n_direct = "우"
# total_sec = 0
# nx, ny = 0, 0
snake = []
def sol():
  x, y = 0, 0 #현재 뱀의 위치
  snake.append((x,y))
  map[x][y] = 2
  n_direct = "우"
  total_sec = 0
  nx, ny = 0, 0
  while True:
    # #방향정보 꺼내서 이동 시작
    # for sec, direct in q:
    #   sec -= total_sec

    if len(q) >= 1 and total_sec == q[0][0]: #방향전환 할 시간이 오면 방향 변경
      s, d = q.popleft()
      n_direct = dic[n_direct][d] #회전한 결과
    if n_direct == "상":
      nx, ny = x + dx[0], y + dy[0]
    elif n_direct == "하":
      nx, ny = x + dx[1], y + dy[1]
    elif n_direct == "좌":
      nx, ny = x + dx[2], y + dy[2]
    elif n_direct == "우":
      nx, ny = x + dx[3], y + dy[3]
    #뱀이 몸에 닿거나 벽에 닿으명 종료
    if nx < 0 or nx >= n or ny < 0 or ny >= n or map[nx][ny] == 2:
      return total_sec + 1
    if map[nx][ny] == 0:#사과가 없다면
      #꼬리 삭제
      tx, ty = snake.pop(0)
      map[tx][ty] = 0
      #머리이동
      snake.append((nx,ny))
      map[nx][ny] = 2 #머리 옮기고

    elif map[nx][ny] == 1: #사과가 있다면
      map[nx][ny] = 2
      snake.append((nx,ny))
      
    total_sec += 1
    x, y = nx, ny 
  
print(sol())