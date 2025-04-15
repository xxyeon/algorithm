n, m = map(int, input().split())
edges = []

for _ in range(m+1):
    a, b, type = map(int, input().split())
    edges.append((type, a, b))

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(a, b, parent):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def kruskal(MAP, sorte_type):
    parent = [i for i in range(n+1)]
    count = 0
    sorted_edge = sorted(MAP, reverse=sorte_type)
    for t, a, b in sorted_edge:
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(a, b, parent)
            if t == 0: #오르막 길이면 count 증가
                count += 1
    return count

max_tired = kruskal(edges, False) #최대 피로도 계산(오르막 순으로 정렬 후 union-find
min_tired = kruskal(edges, True) #최소 피로도 계산 (내리막 순으로 정렬 후 unoin-find)

print(max_tired ** 2 - min_tired ** 2)