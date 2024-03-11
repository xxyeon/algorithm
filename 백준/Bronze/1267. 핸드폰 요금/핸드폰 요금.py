n = int(input())
data = list(map(int, input().split()))
y = 0
m = 0
yR = 0
mR = 0
for i in data:
  y +=  10 * (i // 30)
  yR = i % 30
  m += 15 * (i // 60)
  mR = i % 60
  if 0 <= yR <= 29:
    y += 10
  if 0 <= mR <= 59:
    m += 15
if y < m:
  print("Y", y)
elif y > m:
  print("M", m)
else:
  print("Y M", y)