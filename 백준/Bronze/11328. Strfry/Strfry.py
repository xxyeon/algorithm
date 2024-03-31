import sys
n = int(input())
first = []
sec = []

for _ in range(n):
  i, j = sys.stdin.readline().rstrip().split()
  first.append("".join(sorted(i)))
  sec.append("".join(sorted(j)))


for i, k in zip(first, sec):
  if i != k:
    print("Impossible")
  else:
    print("Possible")