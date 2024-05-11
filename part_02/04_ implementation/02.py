# arr[row][col]
#1차 풀이
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

#2차 풀이
start = input()
cnt = 0
x = ord(start[0])
y = int(start[1])
lst = [(2,1), (-2,1), (2,-1), (-2,1), (1,-2) ,(-1,2), (1,2),(-1,-2)] 
for k in lst:
  nx = x+k[0]
  ny = y+k[1]
  if ord('a')<=nx<=ord('h') and 1<=ny<=8:
    cnt += 1
       
print(cnt)
