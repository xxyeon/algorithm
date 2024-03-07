n = int(input())
lst = []
for _ in range(n):
  start, end = map(int, input().split())
  lst.append([start, end])

lst.sort(key=lambda x: (x[1], x[0]))

cnt = 1
start = lst[0][0]
end = lst[0][1]
for i in range(n - 1):
  if end > lst[i + 1][0]:
    continue

  cnt += 1
  end = lst[i + 1][1]

print(cnt)