import sys

n, c = map(int, sys.stdin.readline().rstrip().split())
data = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

data.sort()
start, end = 1 , data[n-1] - data[0]
result = 0
mid = 0
while start <= end:
  
  mid = (start + end) // 2 #gap 탐색하기
  install = data[0] #앞에서부터 공유기 설치 시작
  count = 1 # 공유기 설치 개수
  for i in range(1, n): #앞에서부터 공유기 설치하다가 현재 집 좌표 + mid보다 다음 집 좌표가 크다면 공유기 설치
    if data[i] >= install + mid:
      install = data[i] #다음 집에 공유기 설치
      count += 1
      
  if count >= c:#설치해야할 공유기 개수보다 더 많이 설치할 수 있는 경우 gap늘리기
    start = mid + 1
    result = mid
  if count < c:
    end = mid - 1
print(result)