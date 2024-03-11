n = int(input())
data = list(map(int, input().split()))
y = 0
m = 0
for i in data:
  y +=  10 * (i // 30) + 10
  m += 15 * (i // 60) + 15
  
if y < m:
  print("Y", y)
elif y > m:
  print("M", m)
else:
  print("Y M", y)
  