from collections import deque

n, m = map(int, input().split())
lst = list(map(int, input().split()))
cnt = 0
i = 0
q = [i for i in range(1,n+1)]
q = deque(q)

while i < m:
    if q[0] == lst[i]:
        q.popleft()
        i += 1
        continue
    if list(q).index(lst[i]) > len(q)//2:
        #뒤쪽에서 빼기
        last = q.pop()
        q.appendleft(last)
        cnt += 1
    else:
        #앞에서 빼서 뒤에
        first = q.popleft()
        q.append(first)
        cnt += 1
print(cnt)
        