from collections import deque
import heapq
def solution(operations):
    answer = []
    #operation할때마다 힙 재정렬하면 (NlogN)
    #최대힙, 최소힙
    #디큐를 힙으로? 숫자 삽입할 때 push, 최댓값 삭제: pop(), 최솟값 삭제: popleft()
    max_q = []
    min_q = []
    for op in operations:
        if "D" == op[0] and len(min_q) == 0:
            continue
        if "D 1" == op:
            num = -heapq.heappop(max_q)
            min_q.remove(num)
            
        elif "D -1" == op:
            num = heapq.heappop(min_q)
            max_q.remove(-num)
            
        else:
            num = int(''.join(op[2:]))
            heapq.heappush(min_q,num)
            heapq.heappush(max_q, -num)
    
    if not min_q:
        return [0, 0]
    return [-heapq.heappop(max_q), heapq.heappop(min_q)]