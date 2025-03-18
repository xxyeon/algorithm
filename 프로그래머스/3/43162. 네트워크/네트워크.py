def solution(n, computers):
    answer = 0
    link = [[] for _ in range(len(computers))]
    visited = [False for _ in range(len(computers))]
    for i, computer in enumerate(computers):
        for k, node in enumerate(computer):
            if node == 1:
                link[i].append(k)
    cnt = 0
    for i in range(len(computers)):
        cnt = dfs(i, link, visited, cnt)
    
    return cnt

def dfs(now, link, visited, cnt):
    for node in link[now]:
        if not visited[node]:
            visited[node] = True
            dfs(node, link, visited, cnt)
            cnt += 1
    return cnt