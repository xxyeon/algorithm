n = int(input())
num = 1
for i in range(1, n+1):
  print(" "*(n-i) + "*" * (i*2-1))
for i in range(n*2-3, 0, -2):
  print(" "* num + "*"*i)
  num += 1