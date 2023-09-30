s = input()

intList = []

beforOne = 0
afterOne = 0

result = 1

for i in s:
  intList.append(int(i))

for i in intList:
  if i == 0:
    result += i
  elif i == 1:
    if intList[i-1] < intList[i+1]:
      result += i
    else:
      result *= i
  else:
    result *= i


print(result)

#  1 양쪽을 비교해서 더 작은 수에 + 큰 수에 *하도록 했는데 이럴 필요가 없음
#  연산 진행 순서는 어차피 좌에서 우로 순차적으로 진행되므로 지금 처리하고 있는 숫자가 1이면 더해버리면 된다.