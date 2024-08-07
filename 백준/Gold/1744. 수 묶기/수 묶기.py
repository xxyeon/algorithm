n = int(input())

zero = []
one = []
positive = []
negative = []
for _ in range(n):
  num = int(input())
  if num == 0:
    zero.append(num)
  elif num == 1:
    one.append(num)
  elif num > 0:
    positive.append(num)
  elif num < 0:
    negative.append(num)

result = 0
negative_cnt = len(negative)
negative.sort()
if negative_cnt % 2 == 0:
  for i in range(0, negative_cnt-1, 2):
    result += negative[i] * negative[i+1]
elif negative_cnt % 2 != 0:
  for i in range(0, negative_cnt-2, 2):
    result += negative[i] * negative[i+1]
  if len(zero) == 0:
    result += negative[negative_cnt-1]

positive.sort(reverse=True)
while len(positive) > 1 :
  result += positive.pop(0) * positive.pop(0)
if len(positive) == 1:
  result += positive.pop()
for i in one:
  result += i
print(result)