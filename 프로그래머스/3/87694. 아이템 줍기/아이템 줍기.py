from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def solution(rectangle, characterX, characterY, itemX, itemY):
    # 주어진 도형 2배로 늘리기
    for i, (x1, y1, x2, y2) in enumerate(rectangle):
        rectangle[i] = [x1 * 2, y1 * 2, x2 * 2, y2 * 2]

    # 2배 확장된 좌표계를 위한 102x102 크기의 맵
    matrix = [[-1] * 102 for _ in range(102)]
    visited = [[False] * 102 for _ in range(102)]

    # 사각형 테두리만 1로 설정 (내부는 0으로 유지)
    for x1, y1, x2, y2 in rectangle:
        for y in range(y1, y2 + 1):
            for x in range(x1, x2 + 1):
                if matrix[y][x] == 0:
                    continue
                matrix[y][x] = 1  # 모든 영역을 1로 설정
        for y in range(y1 + 1, y2):
            for x in range(x1 + 1, x2):
                matrix[y][x] = 0  # 내부를 0으로 설정

    # BFS 실행 후 결과 반환
    return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, matrix, visited)

def bfs(x, y, targetX, targetY, matrix, visited):
    global dx, dy
    q = deque([(x, y, 0)])
    # visited[y][x] = True  # 시작점 방문 처리
    print(targetX, targetY)

    while q:
        x, y, cnt = q.popleft()
        
        visited[y][x] = True
        
        if x == targetX and y == targetY:
            return cnt // 2  # 목표 도달 즉시 반환
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= 102 or ny < 0 or ny >= 102:
                continue
            
            if not visited[ny][nx] and matrix[ny][nx] == 1:
                q.append((nx, ny, cnt + 1))
                

    return -1  # 도달할 수 없는 경우 (이론상 발생하지 않음)
