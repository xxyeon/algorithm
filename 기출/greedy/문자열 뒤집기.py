s = input()

lst = []
for i in s:
  lst.append(i)
  
oneIdx = 0
zeroIdx = 0
partOfZero = 0
partOfOne = 0

while len(lst) != 0:
  zeroIdx = s.find("0")
  oneIdx = s.find("1")
  if(zeroIdx == -1 or oneIdx == -1):
    break
  if zeroIdx < oneIdx:
    partOfZero += 1
    del lst[0:oneIdx]
    s = "". join(lst)
    # print(partOfZero)
  else:
    partOfOne += 1
    del lst[0:zeroIdx]
    s = "".join(lst)

if partOfOne < partOfZero:
  print(partOfOne)
else:
  print(partOfZero)
      
