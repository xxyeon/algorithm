def solution(n, costs):
    answer = 0
    costs.sort(key = lambda x:x[2])
    visited = set([costs[0][0]])
    while len(visited) < n:
        for a, b, cost in costs:
            if a in visited and b in visited:
                continue
            elif a in visited or b in visited: #둘 중 하나가 방문했었다면
                visited.update([a, b])
                answer += cost
                break
    return answer