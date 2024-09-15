import sys
n = int(sys.stdin.readline())
tall = list(map(int, sys.stdin.readline().split()))

tall.reverse()
answer = [0] * n
stack = []
for i in range(n-1):
  stack.append(i)
  while stack and tall[stack[-1]] <= tall[i+1]:
    answer[stack.pop()] = n-(i+1)

answer.reverse()
print(*answer)