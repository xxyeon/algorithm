n = int(input())
lst = list(map(int, input().split()))
dp = [0] * n
dp[0] = lst[0]
for now in range(1, n):
    for pre in range(now):
        if lst[pre] < lst[now]:#증가
            dp[now] = max(dp[now], dp[pre] + lst[now])
        else:#감소
            dp[now] = max(dp[now], lst[now])
print(max(dp))