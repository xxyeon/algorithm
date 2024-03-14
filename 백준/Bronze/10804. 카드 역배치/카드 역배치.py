lst = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]

for _ in range(10):
  a, b = map(int, input().split())
  r_lst = lst[a:b+1]
  lst[a:b+1] = reversed(r_lst)

print(*lst[1:])