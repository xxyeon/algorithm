#3개 벽을 가지고안전 영역 크기 최대화
#연구소 n(3),m(8) 최대 24이므로 완전탐색으로 기둥 설치해보고 bfs로 퍼트리고 안전 영역 확인하기
from collections import deque
from itertools import combinations

n, m = map(int, input().split())
graph = []

#연구소 초기화
for i in range(n):
    graph.append(list(map(int, input().split())))
#바이러스가 있는 인덱스 큐에 넣기
#바이러스 퍼트릴 함수 2에서 퍼트김

#상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(i, j):
    q = deque()
    q.append((i, j))

    while q:
        ni, nj = q.popleft()
        for k in range(4):
            nx, ny = ni + dx[k], nj + dy[k]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:  #벽이나 기둥이 아니면 퍼지게
                graph[nx][ny] = 2

                q.append((nx, ny))

p = []
one_idx = []
#바이러스 위치 찾기
v = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            v.append((i, j))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            one_idx.append((i,j))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            p.append((i, j))  #기둥 세울 수 있는 위치 저장
p = list(combinations(p, 3))

result = []


#기둥 조합을 가지고 기둥 세우고 바이러스 퍼트리는 시뮬레이션 시작
def simulate(p):
    for x, y in p:
        graph[x][y] = 1
    #바이러스 퍼트리기
    #바이러스 퍼트리고나서 안전구역확인하기 (아이스크림 얼리기랑 같은 원리?)
    for x, y in v:
        #바이러스 있으면 상하좌우로 퍼트리기
        bfs(x, y)
#바이러스 다 퍼트리면 안전구역 확인
    sum = 0
    for i in graph:
        sum += i.count(0)
    result.append(sum)
    #그래프 원상태로 돌려놓기
    for i in range(n):
        for j in range(m):
            if (i, j) in v:
                continue
            elif (i,j) in one_idx:
                graph[i][j] = 1
            else:
                graph[i][j] = 0

for i in p:
    simulate(i)
print(max(result))
