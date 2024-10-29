#전위 순회: dfs
n = int(input())
tree = {}


def pre(start): #전위 순회
    #루트, 왼, 오
    print(start, end="") #루트 첫 방문에 출력
    for i in tree[start]:
        if '.' not in i:
            pre(i)


def inorder(start): #전위 순회
    #왼쪽, 루트, 오른쪽
    if tree[start][0] != '.':
        inorder(tree[start][0])
    print(start, end="") #본인 출력하고 오른쪽, 본인 두번째 방문에 출력
    if tree[start][1] != '.':
        inorder(tree[start][1])

def post(start):
    #왼, 오, 루트
    if tree[start][0] != '.': #루트의 왼쪽 자식이 있다면
        post(tree[start][0])
    if tree[start][1] != '.': #루트의 오른쪽 자식이 있다면
        post(tree[start][1])
    if start != '.':
        print(start, end="") #본인 세번째 방문에 출력

for i in range(n):
    root, left, right = input().split()
    tree[root] = [left, right]

pre('A')
print()
inorder('A')

print()
post('A')