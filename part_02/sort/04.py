# 배열 A에서 가장 작은 원소가 배열 B에서 가장 큰 원소보다 작을 때에 교체한다는 조건 추가해주기n, k = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))


a.sort()
b.sort()
b.reverse()

for i in range(k):
    if(a[i] < b[i]):
        a[i], b[i] = b[i], a[i]
        
    else:
        break


print(sum(a))
