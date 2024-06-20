#정답 코드 참고
# H의 길이를 찾아야하는 문제 -> 절단기 높이 최대 10억의 정수이므로 이진 탐색으로 탐색 시간을 줄이자
import sys
n, m = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))

def binary(start, end):
  while start <= end:
    mid = (start + end) // 2
    h_sum = 0
    for i in data:
      if i > mid:
        h_sum += i-mid
    if h_sum == m:
      return mid
    elif h_sum < m:
      end = mid - 1
    elif h_sum > m:
      start = mid + 1
  return None
print(binary(0, max(data)))