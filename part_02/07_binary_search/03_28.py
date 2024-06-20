#소요시간 6m 58s
import sys
n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))

#이진탐색으로 인덱스와  원소가 같은 수인지 확인
start = 0
end = n-1
result = -1
while start <= end:
  mid = (start + end) // 2
  if data[mid] == mid:
    result = mid
    break
  elif data[mid] < mid:
    start = mid + 1
  elif data[mid] > mid:
    end = mid - 1
print(result)