k = int(input())
data = [int(input()) for _ in range(k)]
lst = [] #k가 최대 100000이므로 리스트 2개 사용해도 충분함
for i in data:
  if i != 0:
    lst.append(i)
  else:
    lst.pop()
print(sum(lst))