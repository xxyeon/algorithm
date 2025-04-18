t = int(input())
dp = [(1,0), (0,1)] + [(0,0)] * 40

for _ in range(t):
    n = int(input())
    if dp[n] != (0,0):
        print(dp[n][0], dp[n][1])
        continue
    zero, one = 0, 0
    for i in range(2, n+1):
        zero = dp[i-1][0] + dp[i-2][0]
        one = dp[i-1][1] + dp[i-2][1]
        dp[i] = (zero, one)
    print(dp[n][0], dp[n][1])
    