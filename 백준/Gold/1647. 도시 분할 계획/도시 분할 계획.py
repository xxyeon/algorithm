#각 마을마다 mst적용
# 간선비용 오름차순 -> result에 추가(사이클 빼고)

def find_parent(parent, i):
  if parent[i] != i:
    parent[i] = find_parent(parent, parent[i])
  return parent[i]


def union(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a > b:
    parent[a] = b
  else:
    parent[b] = a

n, m = map(int, input().split())
parent = [0] * (n+1)
#부모 초기화
for i in range(n+1):
  parent[i] = i
info = []
for i in range(m):
  a, b, c = map(int, input().split())
  info.append((c,a,b))

info.sort() #c 기준으로 오름차순정렬
result = 0
last = 0
for i in info:
  #간선 확인할 때마다 사이클인지 확인
  if find_parent(parent, i[1]) != find_parent(parent, i[2]): #사이클이 아닌 경우 추가
    #union 진행
    union(parent, i[1], i[2])
    result += i[0]
    last = i[0] #최소신장트리 만들고 가장 마지막에 연결된 간선 제거

#최소신장트리로 만들고 그중에서 간선 비용이 제일 큰거 제외 (2개 마을로 분리해야하니까)
print(result-last)