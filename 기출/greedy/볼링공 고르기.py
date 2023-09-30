n, m = map(int, input().split())
array = list(map(int, input().split()))

idx = 0
count = 0
for i in range(n-1):
  for j in range(1, len(array)):
    a = array[idx]
    b = array[j]

    if(a == b):
      continue
    else:
      count += 1
      
    #이 조건은 count가 다 완료된 이후에 검사해야함 
    # continue 전에 검사를 하면 안쪽 for문이 돌때 idx>=j만족할 때마다 count가 계속 감소해서 원하는 결과가 나오지 않음.
    if idx >= j: 
      count -= 1

  idx += 1
      

print(count)
