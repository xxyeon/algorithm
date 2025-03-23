
def solution(prices):
    answer = [0 for i in range(len(prices))]
    stack = [(0,0,-1)] #price, time,idx
    total_time = 0
    for idx, price in enumerate(prices):
        total_time += 1
        while stack[-1][0] > price:   
            p, time, i = stack.pop()
            answer[i] = total_time - time
        stack.append((price, total_time, idx))
        
    while stack[1:]:
        price, time, idx = stack.pop()
        answer[idx] = len(prices) - time
            
    return answer