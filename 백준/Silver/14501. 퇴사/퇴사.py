n = int(input())
lst = [(0,0,0)]

for i in range(n):
  t, p = map(int,input().split())
  #t+i = 상담이 완료하는 날짜
  lst.append((i+1, p, t+i))

profit = [0]* (n+1) #i일의 최대 수익을 저장

max_p = 0
for day in range(1, n+1):#1,2,3,..n일에 최대 이익을 저장
  start, p, end = lst[day] 
  if end > n:
    continue

  pre = max(profit[start:end+1])
  if pre != 0: #lst[day] start와 이전에 상담한 날짜와 겹치는 경우
    
    max_p = max(pre, p + max(profit[:day]))
    profit[end] = max_p
  else:
    max_p = p + max(profit[:start])
    profit[end] = max_p #profit[i]의 이익과 lst[day]의 이익을 비교
  

print(max(profit))