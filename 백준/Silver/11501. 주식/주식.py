import sys
t = int(sys.stdin.readline())

result = []
for _ in range(t):
  day = int(sys.stdin.readline())
  lst = list(map(int, input().split()))
  profit = 0
  lst.reverse() #역순으로 하면 다음날보다 작은 주가만 찾아서 이익을 계산하면된다. 역순이 아니면 현재날보다 큰 수 + 현재날 보다 큰수 다음날에또 큰 수가 있는지 확인해야함..


  k=0
  for i in range(1, len(lst)):
    next = lst[k]

    if next >= lst[i]: #다음날 주가가 이전 날보다 크다면 이전 주식 사기
      profit += next - lst[i]
    else:
      # lst = lst[i:] #슬라이싱하면 시간초과된다고 한다
      k = i
  # result.append(profit)
  print(profit)
