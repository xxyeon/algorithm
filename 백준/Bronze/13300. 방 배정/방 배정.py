#한방에 같은 학년 같은 성별
#방의 최소 개수
import sys
n, k = map(int, input().split())
data = list(tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n))

data2 = data.copy()
data = set(data)


#성별로 나누고, 학년으로 나누고
#여학생이면서 1학년
#완전탐색 O(n^2) -> 100만
cnt = 0
room = 0
for i in data:
  for j in data2:
    if i[0] == j[0] and i[1] == j[1]: #성별과 학년 같은지 검사
      cnt += 1
  if cnt < k:
    room += 1
  else:
    room += cnt // k
    if cnt % k > 0:
      room += 1
  cnt=0
  
print(room)