n = int(input())
data = []
for _ in range(n):
  d = input()
  sum = 0
  for i in d:
    if 48 <= ord(i) <= 57:
      sum += int(i)
  data.append((len(d), sum, d))

data.sort()
for i in data:
  print(i[2])