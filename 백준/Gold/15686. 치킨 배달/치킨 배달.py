from itertools import combinations

n, m = map(int, input().split())

city = [list(map(int, input().split())) for _ in range(n)]

chicken = []
home = []
#치킨 좌표 찾기 (완전 탐색)
#집 좌표 찾기
for i in range(n):
  for j in range(n):
    if city[i][j] == 2:
      chicken.append((i,j))
    elif city[i][j] == 1:
      home.append((i,j))


chicken_combinations = list(combinations(chicken, m))
min_distence = 2*n*len(home)

for i in chicken_combinations:
  chicken_distence = []
  for h_r, h_c in home:
    min = 2*n
    for r, c in i: #각 집마다 치킨거리 구하기
      distence = abs(h_r-r) + abs(h_c-c)
      if min > distence:
        min = distence
    chicken_distence.append(min) #각 집마다 치킨 거리를구함
  if min_distence > sum(chicken_distence):
    min_distence = sum(chicken_distence)
print(min_distence)