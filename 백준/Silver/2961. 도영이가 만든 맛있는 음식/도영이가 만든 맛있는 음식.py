from itertools import combinations
n = int(input())
lst = list(tuple(map(int, input().split())) for i in range(n))

answer = 1e9
# lst = combinations(lst, n) # 재료의 개수를 n개 선택하는 줄 알았음..
for cnt in range(1, n +1):
    comb = combinations(lst, cnt) # 재료의 개수를 n개 선택하는 줄 알았음..
    for foods in comb:
        total_s = 1
        total_b = 0
        for s, b in foods:
            total_s *= s
            total_b += b
        answer = min(answer, abs(total_s-total_b))

print(answer)