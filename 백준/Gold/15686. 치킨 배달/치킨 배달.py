#집을 기준으로 가장 가까운 치킨집거리 2의 모든 좌표와, 1의 모든 좌표
#
#m개의 치킨 집 중에서 1의 좌표를 기준으로 2의 좌표를 완전탐색하면서 치킨거리 찾기
# 집, 치킨 리스트로 저장
import sys
from itertools import combinations
n, m = map(int, input().split())
lst_chicken = []
lst_home = []

map = [list(map(int, sys.stdin.readline().split())) for i in range(n)]

for i in range(n):
  for j in range(n):
    if map[i][j] == 2:#치킨집
      lst_chicken.append((i, j))
    elif map[i][j] == 1:
      lst_home.append((i,j))

dist = []
result = 0
total_dist = 0
answer = []
#치킨집 m개를 조합으로 고른후
#13c6 -> 
m_chicken = list(combinations(lst_chicken, m))

for chickens in m_chicken:#13c6  먼저 m개의 치킨집을 고른 후
  result = 0
  for i, j in lst_home: #각각의 집에서 치킨집 거리 구하기
    dist = [] #각 집에서 m개의 치킨집 중 치킨거리
    for x, y in chickens: #m = 13 -> max
      dist.append(abs(i-x) + abs(j-y)) #한집에서 m개 치킨집의 거리
    # print('home: ', i, j)
    # print('dist', dist)
    result += min(dist)
  answer.append(result)

print(min(answer))
    