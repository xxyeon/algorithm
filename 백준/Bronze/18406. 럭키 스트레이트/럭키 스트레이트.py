n = input()
left = map(int, list(n[:len(n)//2]))
right = map(int, list(n[len(n)//2:]))
if sum(left) == sum(right):
  print("LUCKY")
else:
  print("READY")