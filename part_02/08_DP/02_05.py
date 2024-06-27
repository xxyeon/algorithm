# ai = i금액을 만들수 있는 최소 화폐개수
# k단위의 화폐로 i금액을 만들기위한 최소 화폐 개수 ai = min(ai, a(i-k)+1)
n ,m = map(int, input().split())
lst = [10001] * (m+1)
coin = []
for _ in range(n):
  idx = int(input())
  if idx > m:
    continue
  coin.append(idx)
  lst[idx] = 1

for i in coin:
  for k in range(i, len(lst)):
    lst[k] = min(lst[k], lst[k-i] + 1)
if lst[m] == 10001:
  print(-1)
else:
  print(lst[m])
