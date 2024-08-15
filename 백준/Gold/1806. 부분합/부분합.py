import sys

n, s = map(int, sys.stdin.readline().rstrip().split())

data = list(map(int, sys.stdin.readline().rstrip().split()))

start, end = 0, 0
interval = n + 1
current_sum = 0

while start < n and end <= n:
  
  if current_sum >= s:
    #구간 줄이기
    interval = min(interval, end - start) #end 포인터 전까지
    current_sum -= data[start]
    start += 1
    
  elif current_sum < s:
    if end >= n:
      break
    current_sum += data[end]
    end += 1


if interval < n+1:
  print(interval)
else:
  print(0)