from collections import deque
import sys

data = deque()
n = int(sys.stdin.readline().rstrip())
for _ in range(n):
  s = sys.stdin.readline().rstrip().split()
  
  if s[0] == "push_front":
    data.appendleft(int(s[1]))
  elif s[0] == "push_back":
    data.append(int(s[1]))
  elif s[0] == "pop_front":
    if len(data) != 0:
      print(data.popleft())
    else:
      print(-1)
  elif s[0] == "pop_back":
    if len(data) != 0:
      print(data.pop())
    else:
      print(-1)
  elif s[0] == "size":
    print(len(data))
  elif s[0] == "empty":
    if len(data) == 0:
      print(1)
    else:
      print(0)
  elif s[0] == "front":
    if len(data) != 0:
      print(data[0])
    else:
      print(-1)
  elif s[0] == "back":
    if len(data) != 0:
      print(data[len(data)-1])
    else:
      print(-1)