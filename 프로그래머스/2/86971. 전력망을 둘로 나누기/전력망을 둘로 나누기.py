from collections import deque
def solution(n, wires):
    answer = -1
    visited = [False] * (n+1)
    
    lst = [[] for _ in range(n+1)]

    #dfs 탐색을 위해 새로운 리스트 만들기
    for i, j in wires:
        lst[i].append(j)
        lst[j].append(i)
        
    cnt = 0
    result = 0
    def dfs(cnt, visited, n):
        
        for i in lst[n]: #n에 연결된 전력망
            if visited[i] == False:
                visited[i] = True
                cnt += 1
                dfs(cnt, visited, i)
            
        
    #[1,2]를 끊는다고 하면 lst에서 lst[1] = 2를 삭제하고 탐색
    result = 100
    for n1, n2 in wires:
        lst[n1].remove(n2)
        lst[n2].remove(n1)
       
        visited = [False] * (n+1)
        visited[n1] = True
        dfs(1, visited, n1)
        cnt1 = visited.count(True)
        
        visited = [False] * (n+1)
        visited[n2] = True
        dfs(1, visited, n2)
        cnt2 = visited.count(True)
        
    
        result = min(result, abs(cnt1-cnt2))
        lst[n1].append(n2)
        lst[n2].append(n1)
            
    answer = result
    return answer