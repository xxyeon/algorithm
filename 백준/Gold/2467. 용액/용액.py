#0에 가깝게 만들기
#완전탐색은 시간초과
import sys
input = sys.stdin.readline
n = int(input())
data = list(map(int, input().split()))

start, end = 0, n-1
answer_lst = [data[start], data[end]]
answer = abs(data[start] + data[end])
while start < end:
    n1, n2 = data[start], data[end]
    diff  = n1+n2
    if answer >  abs(diff):
        answer = abs(diff)
        answer_lst = [n1, n2]
    
    if diff < 0:
        start += 1
    elif diff >= 0:
        end -= 1
print(*answer_lst)