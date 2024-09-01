n = int(input())
time = []
cnt = 0
for i in range(n):
  start, end = map(int, input().split())
  time.append((start, end))
time = sorted(time, key = lambda x:(x[1], x[0]))
now_end = 0
for i in range(n):
  start, end = time[i]
  if now_end > start:
    continue
  cnt += 1
  now_end = end
print(cnt)