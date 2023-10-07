n = int(input())
array = list(map(int, input().split()))

array.sort()
result = 0


# def sumOfTime(elem, idx):
#   global result
#   if idx == 1:
#     elem[idx] = elem[0] + elem[idx]
#     return elem[idx]
#   elif idx == 0:
#     return elem[idx]
    
#   return sumOfTime(elem, idx-1) + sumOfTime(elem, idx-2)

# sumOfTime(array, n-1)
for i in range(n-1):
  result = array[i] + array[i+1]
  array[i+1] = result
  

print(sum(array))