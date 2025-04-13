from collections import deque
def solution(n, edge):
    answer = 0

    node = [[] for i in range(n)]
    for a, b in edge:
        node[a-1].append(b-1)
        node[b-1].append(a-1)
 
    visited = [False] * n
    lst = bfs(0, node, visited)
    # print(lst)
    answer = lst.count(max(lst))
    return answer

def bfs(start, node, visited):
    edge_cnt = [0] * len(visited)
    visited[0] = True
    cnt = 0
    q = deque()
    q.append(start)
    while q:
        now = q.popleft()

        for n in node[now]:
            if not visited[n]:
                visited[n] = True
                edge_cnt[n] = edge_cnt[now] + 1
                q.append(n)
    return edge_cnt
                