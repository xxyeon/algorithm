string = input()
alpha = []
digit = []
for i in string:
  if i.isdigit():
    digit.append(int(i))
  else:
    alpha.append(i)

alpha.sort()
sum(digit)
nAlpha=''
for i in alpha:
  nAlpha += i
print(nAlpha + str(sum(digit)))
