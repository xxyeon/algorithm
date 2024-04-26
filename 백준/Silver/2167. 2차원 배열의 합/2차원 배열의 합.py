import sys

n, m = map(int, sys.stdin.readline().split())
lst = [[0]*n for _ in range(m)]

for i in range(n):
  for idx, k in enumerate(sys.stdin.readline().split()):
    lst[idx][i] = int(k)

num = int(sys.stdin.readline())
result = [0]*num
for idx in range(num):
  i,j,x,y = map(int, sys.stdin.readline().split())
  for row in range(j-1,y):
    for col in range(i-1, x):
      result[idx] += lst[row][col]
for i in result:
  print(i)
      
