n = int(input())

array = list(map(int, input().split()))

#공포도가 작은 사람부터 그룹을 지어서 그룹수 최대로..
#공포도 수만큼 사람 채우고 팀원 중 공포도가 가장 높은 사람은 기준으로 채우기
array.sort()

idx = 0
count = 0
i = array[idx]
team = []
team += array[:i]

while True:
  if len(team) < max(team):
    if n - len(team) < max(team):
      break
    team += array[0:max(team)]

  else:
    del array[:len(team)]
    count += 1
    if(max(array) >= len(array)): #예외 잘 생각하기
       break
    else:
      team = []
      idx = array[0]
      team += array[:idx]

print(count)