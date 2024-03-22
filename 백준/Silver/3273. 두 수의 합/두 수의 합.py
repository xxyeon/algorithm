import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
x = int(sys.stdin.readline().rstrip())
data.sort()

left = 0
right = len(data)-1
cnt = 0

while left < right:
  if data[left] + data[right] < x:
    left += 1
  elif data[left] + data[right] > x:
    right -= 1
  elif data[left] + data[right] == x:
    cnt += 1
    right -= 1

print(cnt)