from collections import deque

n, c = map(int, input().split())
m = int(input())

q = []
for _ in range(m):
    s, e, box = map(int, input().split())
    q.append((s, e, box))

# 받는 마을 순서로 정렬 (먼저 내릴 수 있게)
q.sort(key=lambda x: (x[1], x[0]))

capacity = [0] * (n + 1)
answer = 0

for s, e, box in q:
    max_load = 0
    for i in range(s, e):
        max_load = max(max_load, capacity[i])
    
    # 남은 여유 용량만큼만 실을 수 있음
    can_load = min(c - max_load, box)
    answer += can_load
    
    for i in range(s, e):
        capacity[i] += can_load

print(answer)
