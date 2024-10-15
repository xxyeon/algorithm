#자신의 친구와 친구의 친구를 초대
#무방향 그래프

n = int(input())
m = int(input())
lst = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)

visited = [False] * n
visited[0] = True #상근이
answer = 0 

for i in lst[1]:#상근이 친구 수
    visited[i-1] = True
    answer += 1
for i in lst[1]:
    for j in lst[i]: #상근이 친구의 친구
        if visited[j-1] == False:
            visited[j-1] = True
            answer += 1
print(answer)

