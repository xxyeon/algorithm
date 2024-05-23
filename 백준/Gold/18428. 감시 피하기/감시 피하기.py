from itertools import combinations

n = int(input())
data = [input().split() for _ in range(n)]
empty = []
teacher = []

for i in range(n):
  for j in range(n):
    if data[i][j] == 'X':
      empty.append((i, j))
    elif data[i][j] == 'T':
      teacher.append((i, j))

empty = list(combinations(empty, 3))

def watch(row, col, direction):
  global fail
  if direction == 1: #상
    while row >= 0:
      if data[row][col] == 'S':
        fail += 1
        return fail
      if data[row][col] == 'O':
        return
      
      row -= 1
  if direction == 2: #하
    while row < n:
      if data[row][col] == 'S':
        fail += 1
        return fail
      if data[row][col] == 'O':
        return
      
      row += 1
  if direction == 3: #좌
    while col >= 0:
      if data[row][col] == 'S':
        fail += 1
        return fail
      if data[row][col] == 'O':
        return
  
      col -= 1
  if direction == 4: #우
    while col < n:
      if data[row][col] == 'S':
        fail += 1
        return fail
      if data[row][col] == 'O':
        return
      col += 1

fail = 0
success = 0
#장애물 설치하고 선생님 감시 시작
for lst in empty:
  fail = 0
  #장애물 설치
  for row, col in lst:
    data[row][col] = 'O'
  #감시 시작
  for i in teacher:
    #상하좌우 방향으로 학생을 볼 수 있는지 검사
    for j in range(1,5):
      watch(i[0], i[1], j)
  if fail == 0:
    success += 1
    
  #장애물 수거
  for row, col in lst:
    data[row][col] = 'X'


if success > 0:
  print("YES")
else:
  print("NO")