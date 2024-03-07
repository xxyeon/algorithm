time = int(input())

cnt = 0
a, b, c = 0, 0 ,0

a = a + time // 350
time %= 350
b = b + time // 60
time %= 60
c = c + time // 10
time %= 10
if time > 0:
  print(-1)
else:
  print(a, b, c)
