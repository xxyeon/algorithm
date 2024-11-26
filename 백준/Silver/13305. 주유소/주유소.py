n = int(input())
length = list(map(int, input().split()))
cost = list(map(int, input().split()))

pre_cost = cost[0]
min_cost = cost[0]
to_go = length[0]
result = min_cost * to_go
for i in range(1, n-1): #마지막 도시의 주유소는 이용하지 않음
    now_cost = cost[i]
    to_go = length[i]
    if min_cost > now_cost:
        min_cost = now_cost
    result += min_cost * to_go
    
print(result)