from collections import defaultdict
def solution(tickets):
    answer = []
    dict = defaultdict(list)
    for a, b in tickets:
        dict[a].append(b)
        
    for i in dict:
        dict[i].sort(reverse=True)
    
    stack = ["ICN"]
    while stack:
        city = stack[-1]
        if city not in dict or len(dict[city]) == 0:
            answer.append(stack.pop())
        else:
            stack.append(dict[city].pop())
    return answer[::-1]


