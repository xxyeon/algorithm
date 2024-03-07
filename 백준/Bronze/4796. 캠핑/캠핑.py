lst = []
while True:
  day = 0
  L, P, V = map(int, input().split())
  if L == 0 and P == 0 and V == 0:
    break
 
  day += V // P * L
  V = V % P
  if V > L:
    day += L
  else:
    day += V
  lst.append(day)
for i in range(len(lst)):
  print("Case {0}: {1}".format(i+1, lst[i]))