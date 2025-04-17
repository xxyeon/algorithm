
n = int(input())
flower = []
for _ in range(n):
    s_m, s_d, e_m, e_d = map(int, input().split())
    start = 100 * s_m + s_d
    end = 100 * e_m + e_d
    flower.append((start, end))
flower.sort() #시작 순으로 정렬
start = 301
end = 1201
max_end = 0
idx = 0
answer = 0

while idx < n:
    found = False
    while idx < n and start >= flower[idx][0]: #시작 시간보다 늦거나 같은거일 때 end time이 제일 늦은걸 선택
        if max_end < flower[idx][1]:
            max_end = flower[idx][1]
            found = True
        idx += 1
    if not found:
        answer = 0
        break
    answer += 1 #시작이 동일한 꽃 중에서 지닌 시간이 제일 느린 꽃을 선택
    start = max_end #시작 시간을 이전 꽃의 끝나는 시간으로 재설정
    if max_end >= end:
        break
if max_end < end:
    answer = 0
print(answer)
   