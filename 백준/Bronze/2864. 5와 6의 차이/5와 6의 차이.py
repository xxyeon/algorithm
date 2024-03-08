n1, n2 = input().split()

newN1, newN2 = 0, 0
num = ''
min, max = 0, 0
for _ in range(2):
  copyN1, copyN2 = n1, n2
  num = '6'
  replace = '5'
  min = int(newN1) + int(newN2)
  if min != 0:
    num = '5'
    replace = '6'
    
  newN1 = copyN1.replace(num, replace)

  newN2 = copyN2.replace(num, replace)

  max = int(newN1) + int(newN2)


print(min, max)