num = list(input())
num1 = map(int, num[:len(num)//2])
num2 = map(int, num[len(num)//2:])
if sum(num1) == sum(num2):
  print("LUCKY")
else:
  print("READY")