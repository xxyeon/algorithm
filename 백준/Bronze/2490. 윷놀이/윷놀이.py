lst = list(list(map(int, input().split())) for _ in range(3))

for i in range(3):
  test = [lst[i].count(0), lst[i].count(1)]
  if test[0] == 1:
    print("A");
  elif test[0] == 2:
    print("B")
  elif test[0] == 3:
    print("C")
  elif test[0] == 4:
    print("D")
  elif test[1] == 4:
    print("E")