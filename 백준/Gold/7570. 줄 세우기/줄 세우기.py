n = int(input())
child = list(map(int,input().split()))
max_sequence = 1
sequence = 1
#각 학생을 한번씩만 옮기는게 최소 -> 한번씩 옮기려면? 연속 증가는 건드리면 안됨. 전체 학생 수 - 연속 증가 순열 길이
dp = [0] * (n+1)
for num in range(1, n+1):
    dp[child[num-1]] =  num#dp[i] = i번호 학생의 위치

for i in range(1, n):
    sequence = 1
    for j in range(i+1, n+1):
        if dp[i] > dp[j]: #   i번호 학생이 i+1번호 학생보다 뒤에 있다면
            break
        else:
            sequence += 1
            dp[i] = max(dp[j], dp[i]) #i+1번호 학생이 i번호 학생보다 뒤에 있다면 i번호 학생과 연속 증가
    max_sequence = max(max_sequence, sequence)

print(n-max_sequence)

