n = int(input())
dp =[[0] * 10 for i in range(n+1)]
for i in range(1, 10):
    dp[1][i] = 1
#dp[i][j] = i자리에서 j로 끝나는 계단수
for i in range(2, n+1):
    for j in range(10):
        if j == 0: #0으로 끝나는 경우
            dp[i][j] = dp[i-1][1]
        elif j == 9:
            dp[i][j] = dp[i-1][8]
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

print(sum(dp[n]) % 1000000000)