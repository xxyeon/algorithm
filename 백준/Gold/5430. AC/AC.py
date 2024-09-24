#덱
from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())
#O(n^2)이면 1억
for _ in range(n):
  error = False
  q = deque()
  func = sys.stdin.readline().rstrip()
  length = int(sys.stdin.readline().rstrip())
  ac = sys.stdin.readline().rstrip()
  q = deque(ac[1:len(ac)-1].split(','))

  
  toggle = False #toggle == False일때가 원래 순서
  for f in func:
    
    if length == 0 and f == "D":
      print("error")
      error = True
      break
    if f == 'R':
      # q.reverse() #O(n)
      if toggle == True:
        toggle = False
      elif toggle == False:
        toggle = True
      
      
    elif len(q) != 0 and f == 'D':
      if toggle:
        q.pop()
      else:
        q.popleft()
    else:
      print("error")
      error = True
      break
    # print(toggle)
    # print(q)
  if error != True:
    if toggle == True:
        print("["+','.join(reversed(list(q)))+"]")
    else:
      print("["+','.join(list(q))+"]")