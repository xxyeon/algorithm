import sys

n, m = map(int, input().split())

data = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

#가로형태?로 누적합 구한것
data_sum = [[0] * (n+1) for _ in range(n+1)]

#x1, y1 ~ x1~ y2 / x2, y2 ~ x2, y2
data_sum[1][1] = data[1][1] #초기값 세팅

for i in range(1, n+1):#row
  for j in range(1, n+1):#col
    # if i == 1 and j == 1: #[0][0]이면 누적합이 본인
    #   sum_col[i][j] = data[i-1][j-1]
    if j == 1: #다음 행으로 이동하면 그 행부터 다시 누적합
      data_sum[i][j] = data[i-1][j-1]
    else:
      data_sum[i][j] = data[i-1][j-1] + data_sum[i][j-1]

#m = 100000 이고 x1 = 0
for i in range(m):
  x1, y1, x2, y2 = map(int, input().split())
  box1 = 0
  for i in range(x1, x2+1):
    box1 += data_sum[i][y2]

  box2 = 0
  for i in range(x1, x2+1):
    box2 += data_sum[i][y1-1]
  
  print(box1-box2)