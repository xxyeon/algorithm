#작은 수끼리 먼저 더하기-> 입력을 정렬 한 후 비교 횟수 구하기
import heapq
n  = int(input())

heap = []
for _ in range(n):
  heapq.heappush(heap, int(input()))
  
answer = 0
# answer = n_data.popleft()
while len(heap) != 1:
  n1 = heapq.heappop(heap)
  n2 = heapq.heappop(heap)
  answer += n1 + n2
  #n1+n2를 n_data에 넣을때 정렬되도록 넣어야하는데 라이브러리를 사용하면 시간초과가 난다. -> heapq사용
  heapq.heappush(heap, n1+n2)
  
print(answer)
