n = int(input())

count = 0
while(n != 0):
  if n == 3 or n == 6 or n == 9 or n == 12:
      count += n//3
      break
  elif n < 3:
    count = -1
    break
  n -= 5
  count += 1
        
print(count)  