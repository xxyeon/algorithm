import sys

n = int(sys.stdin.readline())
card = list(map(int, sys.stdin.readline().split()))
card.sort()
m = int((sys.stdin.readline()))
lst = list(map(int, sys.stdin.readline().split()))



def binary_search(start, end, target):
  while start >= 0 and end < n and start <= end:
    
    mid = (start + end) // 2

    if target == card[mid]:
      return 1
    elif target < card[mid]:
      end = mid - 1
      
    elif target > card[mid]:
      start = mid + 1
  return 0
      
    
for i in lst:
  print(binary_search(0, n-1, i), end = " ")