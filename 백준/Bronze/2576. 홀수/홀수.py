sum = 0
min = 100
for i in range(7):
  num = int(input())
  if (num % 2 == 1):
    sum += num
    if min > num:
      min = num

if sum == 0:
  print(-1)
else:
  print(sum)
  print(min)