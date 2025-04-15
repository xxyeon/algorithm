import math

def find_parent(parent, x):
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(a, b, parent):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n, m = map(int, input().split())

node = []
link = []
for i in range(n):
    x, y = map(int, input().split())
    node.append((i, x, y))
for i in range(m):
    n1, n2 = map(int, input().split())
    link.append((n1-1, n2-1))
#통로 생성

edges = []
for idx in range(n-1):
    i, x1, y1 = node[idx]
    for idx2 in range(i+1, n):
        j, x2, y2 = node[idx2]
        isLinked = False
        for n1, n2 in link:
            if n1 == i and n2 == j:
                isLinked = True
                break
        if isLinked:
            continue
        length = math.sqrt((x1-x2)**2 + (y1-y2)**2)
        edges.append((length, i, j)) #i와 j가 lenght 길이 통로로 이어질 수 있다.

edges.sort()

parent = [0] * n
for i in range(n):
    parent[i] = i

edgeCnt = len(link)
for a, b in link:
    union_parent(a, b, parent)

answer = 0
for l, a, b in edges:
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(a, b, parent)
   
        answer += l

    
print(f"{answer:.2f}")