n = int(input())
lst = list(tuple(map(int, input().split()))for _ in range(n))
dp = [0] * (n+2)
for i in range(n, 0, -1):
    time, profit = lst[i-1]
    if i + time - 1 <= n:
        dp[i] = max(dp[i+1], dp[i+time] + profit)
    else:
        dp[i] = dp[i+1]
    
print(dp[1])