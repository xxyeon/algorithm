def solution(N, number):
    answer = 1
    dp = [set() for _ in range(9)]
    for i in range(1, 9):
        dp[i].add(int(str(N) * i))

    dp[2].add(N+N)
    dp[2].add(N-N)
    dp[2].add(N*N)
    dp[2].add(N//N)

    for i in range(1, 9):
        for j in range(1, i+1):
            for k in dp[j]:
                for s in dp[i-j]:
                    dp[i].add(k + s)
                    dp[i].add(k - s)
                    dp[i].add(k * s)
                    if s != 0:
                        dp[i].add(k // s)
        if number in dp[i]:
            return i
    return -1