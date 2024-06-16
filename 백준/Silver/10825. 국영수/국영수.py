n = int(input())
data = [tuple(input().split()) for _ in range(n)]

result = sorted(data, key = lambda score:(-int(score[1]), int(score[2]), -int(score[3]), score[0]))

for i in result:
  print(i[0])