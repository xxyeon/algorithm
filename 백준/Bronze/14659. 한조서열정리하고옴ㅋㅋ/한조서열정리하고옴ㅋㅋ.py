num = int(input())
lst = list(map(int, input().split()))


result = []

for i in range(num-1):
  sub = []
  for k in range(i+1, num):
    if lst[i] - lst[k] < 0:
      break
    sub.append(lst[i] - lst[k])
  result.append(len(sub))

print(max(result))