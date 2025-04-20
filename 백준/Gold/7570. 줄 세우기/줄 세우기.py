n = int(input())
child = list(map(int,input().split()))
max_sequence = 1
sequence = 1
#각 학생을 한번씩만 옮기는게 최소 -> 한번씩 옮기려면? 연속 증가는 건드리면 안됨. 전체 학생 수 - 연속 증가 순열 길이
dp = [0] * (n+1)
for num in range(1, n+1):
    dp[child[num-1]] =  num#dp[i] = i번호 학생의 위치

for i in range(1, n):
    if dp[i] < dp[i+1]:
        sequence += 1
    else:
        sequence = 1
    max_sequence = max(max_sequence, sequence)
   

print(n-max_sequence)

