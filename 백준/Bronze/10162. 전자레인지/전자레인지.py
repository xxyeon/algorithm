time = int(input())

cnt = 0
a, b, c = 0, 0 ,0
if time % 10 != 0:
  print(-1)
else:
  while time != 0:
    if time >= 350:
      a = a + time // 350
      time %= 350
    elif time >= 60:
      b = b + time // 60
      time %= 60
    elif time >= 10:
      c = c + time // 10
      time %= 10

  print(a, b, c)
