n, k = map(int, input().split())
array = [int(input()) for _ in range(n)]

idx = 0

count = 0
for i in range(n-1, -1, -1):
  if k >= array[i]:
    idx = i
    break
  else:
    idx = -1

while k!=0:
  if idx == -1:
    break
  for i in range(idx, -1, -1):
    q = k // array[i]
    k -= array[i] * q
    count += q

print(count)