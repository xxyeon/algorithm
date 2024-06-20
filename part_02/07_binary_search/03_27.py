import sys
n, x = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))

start = 0
end = n-1
cnt = 0
def binary():
  global cnt, start, end

  while start <= end:
    mid = (start + end) // 2
    if data[mid] == x:
      data.remove(2) #-> O(logN)을 넘어감... rmove가 아마 O(N)일것 -> O(NlogN)이 되지 않을까?
      cnt += 1
      start = 0
      end = len(data)-1
    elif data[mid] < x:
      start = mid + 1
    elif data[mid] > x:
      end = mid - 1
binary()
if cnt == 0:
  print(-1)
else:
  print(cnt)

#bisect라이브러리 사용하자. bisect_left(array, x): array에서 x가 들어가야할 가장 왼쪽 인덱스 반환, 
# bisect_right(array, x): array에서 x가 들어가야한 가장 오른쪽 인덱스 반환
# array는 당연히 정렬되어 있어야함.