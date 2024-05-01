import sys
n = int(sys.stdin.readline().rstrip())
k = int(sys.stdin.readline().rstrip())
matrix = [[0] * n for _ in range(n)]

#사과 위치 시키기
for _ in range(k):
  x, y = map(int, sys.stdin.readline().rstrip().split())
  matrix[x-1][y-1] = 1

l = int(sys.stdin.readline().rstrip())

#지금 뱀의 진행 방향, 상하좌우
status = [0,1,2,3] 

#맨 처음 뱀의 진행 방향: 우
arrow = status[3]

#움직이는 시간
sec = 0
#뱀의 시작 위치 [0][0]
row = 0
col = 0
matrix[row][col] = 2

#뱀의 위치 정보
p = [[0,0]]

#뱀의 이동 정보
dis = []
#뱀 이동.

outer_for = True

for _ in range(l):
  x, c = sys.stdin.readline().rstrip().split()
  dis.append([int(x),c])

idx = 0
#초기 뱀 설정
x = dis[idx][0]
c = dis[idx][1]
while True:
  #뱀 회전할 시간이면 회전
  if idx < l and sec == dis[idx][0]:
    if arrow == status[0]:
      if c == "D":
        arrow = status[3]
      elif c == "L":
        arrow = status[2]
    elif arrow == status[1]:
      if c == "D":
        arrow = status[2]
      elif c == "L":
        arrow = status[3]
    elif arrow == status[2]:
      if c == "D":
        arrow = status[0]
      elif c == "L":
        arrow = status[1]
    elif arrow == status[3]:
      if c == "D":
        arrow = status[1]
      elif c == "L":
        arrow = status[0]
    idx += 1
    if idx >= l:
      x = dis[idx-1][0]
      c = dis[idx-1][1]
    else:
      x = dis[idx][0]
      c = dis[idx][1]

    #벽에 부딪히는 경우
  if arrow == status[0]:#상
    #벽에 부딪히는 경우
    if row <= 0:
      break
    if matrix[row-1][col] == 2:#자기 몸에 부딪히는 경우
      break

    if matrix[row-1][col] == 1:
      row -= 1
      matrix[row][col] = 2
      p.append([row,col])
    else:
      row -= 1
      matrix[row][col] = 2
      p.append([row,col])
      
      x, y = p.pop(0)
      matrix[x][y] = 0
        
  elif arrow == status[1]:#하
    if row >= n-1:
      break
    if matrix[row+1][col] == 2:
      break

    if matrix[row+1][col] == 1:
      row += 1
      matrix[row][col] = 2
      p.append([row,col])
    else:
      row += 1
      matrix[row][col] = 2
      p.append([row,col])
      x,y = p.pop(0)
      matrix[x][y] = 0
        
  elif arrow == status[2]:#좌
    if col <= 0:
      break
    if matrix[row][col-1] == 2:
      break

    if matrix[row][col-1] == 1:
      col -= 1
      matrix[row][col] = 2
      p.append([row,col])
    else:
      col -= 1
      matrix[row][col] = 2
      p.append([row,col])

      x,y = p.pop(0)
      matrix[x][y] = 0
        
  elif arrow == status[3]: #우
    if col >= n-1:
      break
    if matrix[row][col+1] == 2:
      break
      #뱀의 진행 방향이 우일 경우
    if matrix[row][col+1] == 1: #사과가 있다면
      col += 1
      matrix[row][col] = 2
      p.append([row,col])
    else:
      col += 1
      matrix[row][col] = 2
      p.append([row,col])
      #꼬리 부분 위치 꺼내서 0으로 만들어주기
      x, y = p.pop(0)
      matrix[x][y] = 0
     
  sec += 1
      
print(sec+1)