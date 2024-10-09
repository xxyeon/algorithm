n = int(input())

result = [n+1] * (n +1)
result[0] = 0
result[1] = 0

#연산 수가 작아야하므로 3, 2, 1 순으로 
count = 0
# 3, 2, 1 모두 연산해보면서 연산 수가 작은걸로 업데이트
# n이 만들어질 수 있는 최소 연산 수를 저장한다 -> n까지의 배열을 만들어야함 최대 100만 이므로 가능
#result[n]이 최소가..되도록..
path = ["" for _ in range(n+1)]
path[0] = "0"
path[1] = "1"

for i in range(2, n+1): #result[i] = i가 되기 위한 최소 연산값
    result[i] =result[i-1]+1
    prev = i-1
    if i % 3 == 0 and result[i//3]+1 < result[i]: #path를 저장해야하므로 min(result[i//3]+1, result[i])이렇게 했을경우 어떤 경로를 탓는지 알 수 없음
        result[i] = result[i//3]+1
        prev = i // 3
        
    if i % 2 == 0 and result[i//2]+1 < result[i]:
        result[i] = result[i//2] + 1
        prev = i // 2
    path[i] = str(i) + " " + path[prev]
    
print(result[n])
print(path[n])