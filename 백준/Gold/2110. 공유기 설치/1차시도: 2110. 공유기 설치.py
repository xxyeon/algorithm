# 결과: 메모리 초과 판정
# 풀이시간: 정답코드 참고함

#접근 방식: 이진 탐색보단 조합으로 풀었음 -> 메모리 초과의 원인...
#공유기 c개를 설치할 모든 경우의 수를 조합으로 만들고, 각 조합을 sort 한 후 인접한 집끼리 거리를 계산해서 조합 중 가장 거리가 긴 것을 출력.

import sys
from itertools import combinations
#공유기 c개 한집에 한개, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 설치
# 공유기를 설치할 집을 탐색해야함.

n, c = map(int, sys.stdin.readline().rstrip().split())
data = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

min = 10e10
data = list(combinations(data, c)) #아마도 이게 문제?

max_distance = 0
for i in range(len(data)):
  min = 10e10
  sort_data = sorted(list(data[i]))
  for x in range(0, c-1):
    sub = abs(sort_data[x] - sort_data[x+1])

    if min > sub:
      min = sub
  
  if max_distance < min:
    max_distance = min

#distance에서 가장 장거리를 구하면된다 -> 장거리의 인덱스 = data[인덱스] = 공유기 설치 위치 c개를 알수있다.
print(max_distance)


#이진탐색으로 접근하면 집과 집 사이의 gap을 이진 탐색으로 찾아내는 것.
# 입력으로 주어진 집 좌표에서 두 공유기 사이의 인접한 거리의 범위를 찾아낸다(예제 입력에서는 1~8)
# "집 좌표의 범위가 10억" 이므로 최대 10억의 범위를 탐색하기 위해 이진 탐색 활용해야함
# 공유기 사이의 gap을 이진 탐색으로 검색하다가 c개 이상의 공유기를 설치할 수 있다면 gap을 늘려나가는 방식으로...(start를 mid + 1)
#떡볶이 떡 자르는 문제와 비슷함 (자 길이 구하는 걸 이진탐색으로 구했음..)
