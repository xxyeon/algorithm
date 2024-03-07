n = int(input())
lst = []
for _ in range(n):
  lst.append(int(input()))

change = []
for i in lst:
  q = 0
  d = 0
  n = 0
  p = 0
  while i != 0:
    if i >= 25:
      q = q + i // 25
      i %= 25
    elif i >= 10:
      d = d + i // 10
      i %= 10
    elif i >= 5:
      n = n + i // 5
      i %= 5
    elif i >= 1:
      p = p + i
      i %= 1
  change.append([q, d, n, p])

for i in change:
  print(*i)