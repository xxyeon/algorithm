import sys
n = int(sys.stdin.readline())
q = list(map(int, sys.stdin.readline().split()))
#https://www.acmicpc.net/board/view/86770
#큐말고 스택을 사용...+인덱스
e = False
stack = []
nge = [-1] * n
#시간초과코드
for i in range(n-1):
  stack.append(i)
  while stack and q[stack[-1]] < q[i+1]:
    nge[stack.pop()] = q[i+1]
print(*nge)