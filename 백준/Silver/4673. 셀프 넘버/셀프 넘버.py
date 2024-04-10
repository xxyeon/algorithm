lst = []
def d(n): #셀프넘버가 아닌 것들
  num = n + n//1000 + n%1000//100 + n%100//10 + n%10
  return num

for i in range(1,10001):
  if d(i) <= 10000:
    lst.append(d(i))
  
for i in range(1, 10001):
  if i not in lst:
    print(i)