from collections import deque
import sys

def find_max(q):
  max = 0
  for i in q:
    if max < i:
        max = i
  return max
test_case = int(sys.stdin.readline().rstrip())
for _ in range(test_case):
  doc, idx = map(int, sys.stdin.readline().rstrip().split())
  doc_lst = list(map(int, sys.stdin.readline().rstrip().split()))
  doc_q = deque(doc_lst)

  print_cnt = 0
  while doc_q:
    #최대 중요도 찾기
    max = find_max(doc_q)
    print_doc = doc_q.popleft()
    if max == print_doc:
      print_cnt += 1
      if idx == 0:
        print(print_cnt)
        break
      
    else:
      doc_q.append(print_doc)

    idx -= 1
    if idx < 0:
      idx = len(doc_q)-1