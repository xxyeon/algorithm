from itertools import combinations
an = []
data = list(int(input()) for _ in range(9))
result = list(combinations(data, 7))
for i in range(len(result)):
  if sum(result[i]) == 100:
    an = sorted(list(result[i]))

for i in an:
  print(i)