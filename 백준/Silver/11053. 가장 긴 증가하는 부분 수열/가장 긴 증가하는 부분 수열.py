from bisect import *

n = int(input())
arr = list(map(int, input().split()))
lst = [arr[0]]

for i in range(1, n):
    if lst[-1] < arr[i]:
        lst.append(arr[i])
    idx = bisect_left(lst, arr[i])
    lst[idx] = arr[i]
print(len(lst))