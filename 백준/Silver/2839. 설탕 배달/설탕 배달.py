#상근이가 최대한 적은 봉지로 설탕 배달
#단위로 나눠지는지 봐야함 -> 가장 큰것부터 해도 배달 갈 수 있는데 안나눠져서 못갈 수도 있음
#배열을 n만큼 선언해서 3으로 만들 수 있는 킬로그램 저장하고 5로 만들수 있는 킬로그램 저장하고... -> N킬로그램...
#점화식 ai = min(ai, a(i-k)+1) -> a(i-k)로 만들 수 있는 경우
#n킬로그램을 만들 수 없으면 -1
n = int(input())
#설탕이 최대 5000이므로 
data = [5001] * (n+1)
bag = [3, 5]

for i in bag:
  if i > n:
    continue
  data[i] = 1

#배열 n에...3키로,, 5키로
for k in bag:
  for i in range(k, n+1):
    if data[i-k] != 5001: #가방 단위로 배달 가능하면...
      data[i] = min(data[i], data[i-k]+1)

if data[n] != 5001:
  print(data[n])
else:
  print(-1)