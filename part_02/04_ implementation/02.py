# arr[row][col]

n = input()
count = 0
col, row = ord(n[0]) - ord('a') + 1, int(n[1])

move1 = [[1, 2], [-1, 2], [1, -2], [-1, -2]]
move2 = [[-2, 1], [2, 1], [-2, -1], [2, -1]]


for i in move1:
  nrow = row + i[0]
  ncol = col + i[1]
  if nrow > 8 or ncol > 8 or nrow < 1 or ncol < 1:
    continue
  count+=1

for j in move2:
  nrow2 = row + j[0]
  ncol2 = col + j[1]

  if nrow2 > 8 or ncol2 > 8 or nrow2 < 1 or ncol2 < 1:
      continue
  count+=1
  
print(count)
