from collections import defaultdict
n, k = map(int, input().split())
order = list(map(int, input().split()))
q = []
answer = 0
for i in range(k):
    if order[i] in q:
        continue
    if len(q) < n:
        q.append(order[i])
        continue
    #사용 전 물품 중에서 가장 나중에 나오는 물품을 저장하기 위한 변수
    least = -1
    plugOut = 0
    
    for plug in q:
        if plug not in order[i+1:]: #더이상 나오지 않으면
            plugOut = plug
            break
        else:
            #제일 나중에 등장하는 걸 기준으로 제거
            next = order[i+1:].index(plug)
            if least < next:
                least = next
                plugOut = plug
    
    q.remove(plugOut)
    q.append(order[i])
    
    answer += 1

print(answer)