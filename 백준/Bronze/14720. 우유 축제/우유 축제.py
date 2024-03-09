num = int(input())
lst = list(map(int, input().split()))

cnt = 0
for i in lst:
  if i == cnt%3:
    cnt += 1
print(cnt)