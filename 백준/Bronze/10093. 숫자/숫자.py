#a가 b보다 큰 경우도 생각하자
# a와 b가 같은 경우도 생각하
a, b = map(int, input().split())
lst = []
if b > a:
  cnt = b - a - 1
  for i in range(1, cnt+1):
    lst.append(a + i)
elif a > b:
  cnt = a - b - 1
  for i in range(1, cnt+1):
    lst.append(b + i)
else:
  cnt = a - b
    

print(cnt)
print(*sorted(lst))