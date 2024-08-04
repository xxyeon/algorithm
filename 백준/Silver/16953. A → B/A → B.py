cnt = 0
a, b = map(int, input().split())
while a != b and a <= b:
  if b % 2 == 0:
    b //=2
  elif str(b)[-1] == '1':
    str_b = ''
    for i in str(b)[:-1]:
      str_b += i
    b = int(str_b)
  else:
    print(-1)
    break
  cnt += 1
  if a == b:
    print(cnt+1)
    break

if a > b:
  print(-1)