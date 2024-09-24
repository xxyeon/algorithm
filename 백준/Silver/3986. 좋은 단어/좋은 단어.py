n = int(input())

count = 0
for _ in range(n):
  word = input()
  stack = []
  stack.append(word[0])
  for e in word[1:]:
    if len(stack) == 0:
      stack.append(e)
      continue
    if e == stack[-1]:
      stack.pop()
    else:
      stack.append(e)
  if len(stack) == 0:
   count += 1
print(count)