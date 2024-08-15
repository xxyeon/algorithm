#차이가 m이상이면서 가장 작은거 -> 차이를 기준으로 투 포인터 활용
import sys
n, m = map(int, sys.stdin.readline().rstrip().split())

a = []
for _ in range(n):
  a.append(int(sys.stdin.readline().rstrip()))

a.sort()
start, end = 0, 1

current_gap = float('inf')
while start < n and end < n:
  if a[end] - a[start] >= m:
    current_gap = min(current_gap, a[end] - a[start])
    start += 1
    end = start
  elif a[end] - a[start] < m:
    end += 1
  
print(current_gap)