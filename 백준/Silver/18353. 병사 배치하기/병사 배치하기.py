n = int(input())
data = [1] * n
lst = list(map(int, input().split()))

for i in range(n):
  for j in range(i):
    if lst[i] < lst[j]:
      data[i] = max(data[i], data[j] + 1)

print(n-max(data))