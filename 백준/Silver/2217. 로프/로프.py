n = int(input())
loop = [int(input()) for _ in range(n)]
loop.sort(reverse=True)

result = loop[0]
cnt = 1 #루프 개수
for i in loop:
    result = max(result, cnt*i)
    cnt += 1
print(result)