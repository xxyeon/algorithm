INF = 987654321
def solution(arr):
    
    op = []
    number = []
    for i in arr:
        try:
            number.append(int(i))
        except:
            op.append(i)
            
    n = len(arr) // 2 + 1
    MAX = [[-INF] * n for _ in range(n)]
    MIN = [[INF] * n for _ in range(n)]
    for step in range(n):
        for i in range(n-step):
            j = i + step
            if step == 0:
                MAX[i][j] = number[i]
                MIN[i][j] = number[i]
            for k in range(i, j):
                if op[k] == "+":
                    MAX[i][j] = max(MAX[i][j], MAX[i][k] + MAX[k+1][j])
                    MIN[i][j] = min(MIN[i][j], MIN[i][k] + MIN[k+1][j])
                else:
                    MAX[i][j] = max(MAX[i][j], MAX[i][k] - MIN[k+1][j])
                    MIN[i][j] = min(MIN[i][j], MIN[i][k] - MAX[k+1][j])
    return MAX[0][n-1]