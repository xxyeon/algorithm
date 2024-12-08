#프로이드워셜: 모든노드에 대해서 최소 비용
#다익스트라: 특정 노드엣 대해서 최소 비용
n = int(input())
lst = []
#[[]] * n -> 레퍼런스 복사
cost = []
for i in range(n):
    info = list(map(int, input().split()))
    for k in range(i+1, n):
        c, x, y = info[k], i, k
       
        lst.append((c, x, y)) #리스트 크기 최대 100만


lst.sort() #비용순으로 오름차순

#간선 선택할때 사이클이 생기는지 확인해야된다.
#연결 비용이 작은 것부터 -> 우선순위큐 사용 -> 그냥 정렬해도 가능 한번 정렬하고 난후 새로운 간선이 추가되지 않으므로
parent = [0] * n
for i in range(n):
    parent[i] = i
result = 0
def find_parent(parent, x):
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a > b:
        parent[a] = b
    else:
        parent[b] = a
for edge in lst:
    c, x, y = edge
    if find_parent(parent, x) != find_parent(parent, y):
        union_parent(parent, x, y)
        result += c
print(result)