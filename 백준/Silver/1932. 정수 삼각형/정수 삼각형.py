n = int(input())

tree = []

for i in range(n):
  tree.append(list(map(int, input().split())))

lst = [0] * (n+1) #1계층, 2계층, ....n계층
lst[0] = tree[0][0]
result = []
for step in range(n-1, 0, -1):
  for i in range(step):
    tree[step-1][i] = (max(tree[step][i], tree[step][i+1])) + tree[step-1][i]

print(tree[0][0])