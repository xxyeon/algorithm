INF = 987654321
def solution(n, results):
    answer = n
    MAP = [[INF] * n for i in range(n)]
    for win, lose in results:
        MAP[win-1][lose-1] = 1
        MAP[lose-1][win-1] = -1
    for i in range(n):
        for j in range(n):
            if i == j:
                MAP[i][j] = i
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if MAP[i][k] == 1 and MAP[k][j] == 1:
                    MAP[i][j] = 1
                    MAP[j][i] = -1
    for lst in MAP:
        if INF in lst:
            answer -= 1
                
        
    return answer