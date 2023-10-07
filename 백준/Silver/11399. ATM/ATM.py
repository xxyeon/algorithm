n = int(input())
array = list(map(int, input().split()))

array.sort()
result = 0

for i in range(n-1):
  result = array[i] + array[i+1]
  array[i+1] = result
  
print(sum(array))
