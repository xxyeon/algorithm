n, m = map(int, input().split())

#인접행렬
data = [[(5001)] *(n) for _ in range(n)]
for i in range(n):
    for j in range(n):
        if i == j:
            data[i][j] = 0

for _ in range(m):
    a, b = map(int, input().split())
    data[a-1][b-1], data[b-1][a-1] = 1, 1

#최단 길이 구하기
for k in range(n):
    for i in range(n):
        for j in range(n):
            data[i][j] = min(data[i][j], data[i][k] + data[k][j])

#row더해서 가장 작은 값인 사람이 케빈 베이컨의 수가 가장 적음
result = []
for elements in data:
    result.append(sum(elements))
print(result.index(min(result)) + 1)