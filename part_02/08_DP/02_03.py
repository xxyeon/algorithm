#점화식 ai = max(a(i-1), a(i-2) + ki(i번째 식량 개수))

'''
food = [1,3,1,5]
0번째 식량창고의 최댓값: food[0]
1번째 식량 창고의 최댓값: max(food[0], food[1]) -> food[1]
2번째 식량 창고의 최댓값: max(food[1], food[0] + food[2]) -> food[1] 
3번째 식량 창고의 최댓값: max(food[2], food[1] + food[3]) 
=> i번째 식량 창고의 최댓값을 구하기 위해서 i번째 식량 창고를 털지않을 경우(i-1의 최댓값)와 i번째와 i-2의 최댓값을 털 경우를 비교하면 된다

'''

n = int(input())
food = list(map(int, input().split()))
d = [0] * n
d[0] = food[0]
d[1] = max(food[0], food[1])
for i in range(2, n):
  d[i] = max(food[i-1], food[i-2] + food[i])
print(d[n-1])