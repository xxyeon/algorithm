answer = -1
def solution(k, dungeons):
    global visited
    visited = [0] * len(dungeons)
    dfs(k, 0, dungeons, len(dungeons))
    return answer

def dfs(k, cnt, dungeons, N):
    global answer
    if answer < cnt:
        answer = cnt
    for i in range(N):
        if not visited[i] and k >= dungeons[i][0]:
            visited[i] = 1
            dfs(k-dungeons[i][1], cnt+1, dungeons, N)
            visited[i] = 0
            