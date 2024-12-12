n = int(input())
data = [] #cost, a, b -> a와 b를 연결하는 cost
node_cost = []
for i in range(1, n+1):
    c = int(input())
    data.append((c , 0, i))
    # node_cost.append(c)
# node_cost.sort()
# visited = [False] * (n+1)

parent = [ [] for i in range(n+1)]
for i in range(n+1):
    parent[i] = i



for i in range(n):
    temp = list(map(int, input().split()))
    for j in range(i+1, n):
        data.append((temp[j], i+1, j+1))
    
data.sort() #cost 오름 차순으로 정렬

def find_parent(parent, x): #x의 부모 찾기
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union(a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
#최소스패닝트리
#edge 개수 만큼 돌리면 된다.
#처음에 논에 우물을 파야함 -> cost에서 제일 적은 비용 우물 파기
result = 0
for edge in data: #cost 낮은 순으로 꺼내면서 노드 연결 + 사이클 있는지 확인
    c, a, b = edge 
    if find_parent(parent, a) != find_parent(parent, b):
        union(a, b)
        result += c

print(result)
    

