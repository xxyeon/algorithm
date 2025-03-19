from collections import deque
dx = [0, 0, 1,- 1]
dy = [1, -1, 0, 0]

def solution(maps):
    answer = 0
    #상대팀 진영에 도착하기 위해 지나가야하는 칸의 개수의 최솟값
    #상대팀에 갈 수 없다면 -1
    #0:벽
    #dfs로 풀이
    #갈 수 있는 모든 경우의 수를 저장하는 리스트 따로 만들기 -> 그 리스트에 지나간 칸의 개수를 저장
    dfs(0,0,maps)
    if maps[len(maps)-1][len(maps[0])-1] == 1:
        answer = -1
    else:
        answer = maps[len(maps)-1][len(maps[0])-1]
    return answer
def dfs(x, y, maps):
    global dx, dy
    q = deque([])
    q.append((x, y))
    while q:
        x, y = q.popleft()
        # if 0 > x and x >= len(maps) and 0 > y and y >= len(maps[0]):
        #         continue
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 > nx or nx >= len(maps) or 0 > ny or ny >= len(maps[0]):
                continue
            if maps[nx][ny] == 0:
                continue
            if maps[nx][ny] == 1:#1이나 본인보다 큰 수만 방문하면됨
                #처음 방문했을 때만 넣어주면 됨. 그게 제일 빠른 길이니까
                maps[nx][ny] = maps[x][y] + 1
                q.append((nx, ny))
                #리스트에 append, pop 시간 복잡도: O(1)
            