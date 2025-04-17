n = int(input())
stack = []
for i in range(n):
    stack.append(int(input()))
last_score = stack.pop()
answer = 0
while stack:
    score = stack.pop()
    if last_score  <= score:
        decrease = score - last_score + 1
        last_score = score - decrease
        answer += decrease
    elif last_score > score:
        last_score = score
    
print(answer)