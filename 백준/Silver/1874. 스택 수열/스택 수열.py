n = int(input())
stack = []

num = 1
arr = []
res_lst = []
p = True
for i in range(n):
  arr.append(int(input()))
for i in range(len(arr)): #스택에서 순열을 만들 수 있는가?
  
  if arr[i] not in stack:#push 로 i까지 추가
    while num <= arr[i]:
      stack.append(num)
      num += 1
      res_lst.append('+')
  while True:
    result = stack.pop()
    if result != arr[i]:
      p = False
      break
    else:
      res_lst.append('-')
      break

if p == False:
  print('NO')
else:
  for i in res_lst:
    print(i)   