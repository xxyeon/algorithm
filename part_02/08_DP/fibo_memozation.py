#top down방식: 큰 문제를 해결하기 위해 작은 문제를 호출
d = [0] * 100
def fibo(x):
    if x == 1 or x == 2:
        return 1
    if d[x] != 0:
        return d[x]
    d[x] = fibo(x-1) + fibo(x-2) #x번째 피보나치 저장
    return d[x]

#bottom up 방식: 작은 문제부터 차근차근 답을 도출 -> 다이나믹 프로그래밍 방식 결과저장용 리스틍(DP리스트) 사용
d = [0] * 100
d[1] = 1
d[2] = 1
n = 99
for i in range(3, n+1):
    d[i] = d[i-1] + d[i-2]
print(d[n])

