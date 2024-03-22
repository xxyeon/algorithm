import sys
n, k = map(int, input().split())
data = [tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

idx = 0
data = sorted(data, key= lambda x:(x[0], x[1]))
for i in range(n):
  if data[i][0] == 1:
    idx = i #남학생 시작 idx
    break
w_lst = data[:idx]
m_lst = data[idx:]
w_grade = []
m_grade = []

for i in w_lst:
  w_grade.append(i[1])
for i in m_lst:
  m_grade.append(i[1])

cnt = 0
for i in range(1,7):
  cnt += w_grade.count(i)//k + w_grade.count(i)%k

for i in range(1,7):
  cnt += m_grade.count(i)//k + m_grade.count(i)%k

print(cnt)