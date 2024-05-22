from itertools import permutations
n = int(input())
lst = list(map(int,input().split()))
op_cnt = list(map(int,input().split()))
op = ['+', '-', '*', '%']
op_idx = []
for cnt, op_symbol in zip(op_cnt, op):
  for i in range(cnt):
    op_idx.append(op_symbol)
op = list(permutations(op_idx, n-1))
result = lst[0]
max = -1e+10
min = 1e+10
for op_symbol_list in op:
  result = lst[0]
  for o, num in zip(op_symbol_list, lst[1:]):
    if o == '+':
      result += num
    elif o == '-':
      result -= num
    elif o == '*':
      result *= num
    elif o == "%":
      if result < 0:
        result = abs(result) // num
        result = -result
      else:
        result //= num
  if max < result:
    max = result
  if min > result:
    min = result
print(max)
print(min)