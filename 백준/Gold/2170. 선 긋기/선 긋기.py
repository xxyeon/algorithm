n = int(input())

line = []
for _ in range(n):
    line.append(tuple(map(int, input().split())))

line.sort()

idx = 1
start, end = line[0]
answer = 0
y = line[-1][1]
for i in range(1, n):
    s, e = line[i]
    if end >= s:
        end = max(end, e)
    else:
        answer += end - start
        start, end = s, e
answer += end - start     
print(answer)