import heapq
def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    while scoville[0] < K and len(scoville) > 1:
        food1 = heapq.heappop(scoville)
        food2 = heapq.heappop(scoville)
        heapq.heappush(scoville, food1 + food2 * 2)
        answer += 1
    if heapq.heappop(scoville) < K: return -1
    return answer