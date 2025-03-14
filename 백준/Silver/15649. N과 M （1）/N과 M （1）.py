#완전탐색
from itertools import permutations

n, m = map(int, input().split())
lst = [i for i in range(1, n+1)]
for a in permutations(lst, m):
    for i in a:
        print(i, end=" ")
    print()