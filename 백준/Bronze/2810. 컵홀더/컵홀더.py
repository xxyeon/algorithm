num = int(input())
lst = list(input())
cup = []
#LL을 하나의 사람으로 생각.
for i in range(len(lst)):
  if lst[i] == 'S':
    cup.append(2)
  elif lst[i] == 'L':
    cup.append(1)
    
couple = cup.count(1) // 2
single = cup.count(2)
if couple == 0:
  cnt = single 
else:
  cnt = couple + single + 1

print(cnt)