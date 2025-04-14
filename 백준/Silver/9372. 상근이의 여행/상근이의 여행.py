import sys
from collections import deque

def bfs(start, visited, graph):
    q = deque()
    q.append(start)
    visited[start] = True
    cnt = 0
    while q:
        now = q.popleft()
        for next in graph[now]:
            if not visited[next]:
                visited[next] = True
                cnt += 1
                q.append(next)
    return cnt

test = int(input())

for _ in range(test):
    n, m = map(int, input().split())
    MAP = [[] for i in range(n+1)]
    visited = [False] * (n+1)

    #그래프 그리기
    for _ in range(m):
        a, b = map(int, input().split())
        MAP[a].append(b)
        MAP[b].append(a)
    answer = bfs(1, visited, MAP)
    print(answer)

