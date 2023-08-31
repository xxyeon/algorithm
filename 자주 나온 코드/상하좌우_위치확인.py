dx = [-1, 1, 0, 0] #상 하
dy = [0, 0, -1, 1] #좌 우

#현재 위치에서 네 방향으로의 위치 확인
for i in range(4):
    nx = x + dx[i] # x, y 가 현재 위치
    ny = y + dy[i]
    if nx < 0 or nx >= n or ny < 0 or ny >= m: #NxM 행렬에서 공간 벗어날 경우
        continue
    if graph[nx][ny] == 0: # 움직일 방향이 막혀 있는 경우
        continue