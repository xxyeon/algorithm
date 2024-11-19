#우선순위큐
import heapq

n, m = map(int, input().split())
card = list(map(int, input().split()))
card.sort()
for _ in range(m):
    num1 = heapq.heappop(card) #O(logN)
    num2 = heapq.heappop(card)

    result = num1 + num2
    heapq.heappush(card, result)
    heapq.heappush(card, result)
print(sum(card))