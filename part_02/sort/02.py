n = int(input())
list = []

for i in range(n):
  list.append(int(input()))

list.sort()
list.reverse()
for i in range(n):
  print(list[i], end=' ')

  # 정렬 라이브러리의 reverse 오션
  #list = sorted(list, reverse=True)

  