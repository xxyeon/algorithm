'''
방향을 설정해서 이동하는 문제 유형
dx, dy라는 별도의 리스트 만들어서 방향 정하기
입력에서 방향을 정하면 정한 방향에서 -1씩 해주면 왼쪽으로 회전
'''

#2번째 풀이
dx = [-1,0,1,0] #북동남서 북쪽으로부터 떨어진 거리
dy = [0,1,0,-1] #서쪽으로부터 떨어진거리
n, m = map(int, input().split())
a, b, d = map(int, input().split())
game_map = [list(map(int, input().split())) for _ in range(n)]
game_map[a][b] = -1 #현재 위치
cnt = 1 #처음에 위치한 자리도 포함
def turn_left(direction):
  if direction == 0:
    return 3
  elif direction == 1:
    return 0
  elif direction == 2:
    return 1
  elif direction == 3:
    return 2

result = True
while result:
  result = False
  for _ in range(4):
    d = turn_left(d)
    n_a = a + dx[d]
    n_b = b + dy[d]
    if game_map[n_a][n_b] != -1 and game_map[n_a][n_b] != 1:
      #왼쪽에 가보지 않은 칸이 존재하면 회전
      game_map[n_a][n_b] = -1
      a = n_a
      b = n_b
      cnt += 1
      result = True
      continue
    
  if not result: #4방향을 돌아도 갈 곳이 없다면
    if game_map[n_a-1][n_b] != 1: #뒤가 바다가 아니라면
      a -= 1
      result = True
    else: #뒤가 바다라면 종료
      break

print(cnt)
