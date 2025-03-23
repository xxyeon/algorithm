from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    time = 0
    
    q = deque([0]* bridge_length)
    truck_weights = deque(truck_weights)
    total_w = 0
    
    while q:
        if len(truck_weights) == 0:
            q.popleft()
            time += 1
            continue
        total_w -= q.popleft()
        time += 1
        
        if total_w + truck_weights[0] > weight:
            q.append(0)
        else:
            w = truck_weights.popleft()
            q.append(w)
            total_w += w
    return time