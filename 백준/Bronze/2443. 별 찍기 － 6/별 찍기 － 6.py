n = 2*int(input())-1
for i in range(n, 0, -2):
  print(' '*(n-i) + '*'*i)
  n -= 1