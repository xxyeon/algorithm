#1. 한 위치부터 k개의 접시 연속해서 먹을 경우 -> 할인
#2. 각 고객에게 초밥 종류가 쓰인 쿠폰 발행 1번 행사에 참가할 경우, 쿠폰에 적힌 초밥 하나 무료 제공(무조건))
#행사에 참여해서 다양한 초밥 먹기
# N: 접시수, d: 초밥 종류, k: 연속해섯 먹는 접시의 수, c: 쿠폰 번호
from collections import deque
n, d, k, c = map(int, input().split())

kind = []
for _ in range(n): #초밥 종류
    kind.append(int(input()))

kind_q = deque() #먹은 초잡 종류 저장하는 큐
seq = 0 #초밥 연속해서 먹은 개수
count = 0 #먹은 초밥 개수
rotate = 0
start, end = 0, 0 #시작위치는 상관없지만 0부터 시작한다고 치면

while rotate <= len(kind): #start가 한바퀴 다 돌면 종료
    end = end % len(kind)
    if seq == k: 
        rotate += 1
        #k개 연속 먹었다면  쿠폰 사용하고, 먹은 초밥 종류 개수 저장
        kind_q.append(c)
        count = max(count, len(set(kind_q)))

        #쿠폰 초기화 후 start 변경후 다시 시작
        kind_q.pop()

        start += 1
        seq -= 1
        #먹은 초밥 종류에서 pop
        kind_q.popleft()
    else:
        #초밥 종류 저장하기
        kind_q.append(kind[end])
        #end 옯기면서 초밥먹은 개수와 종류 저장하기
        end += 1
        seq += 1

print(count)