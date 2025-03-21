from collections import deque
def solution(priorities, location):
    answer = 0
    for i, p in enumerate(priorities):
        priorities[i] = (p, i)
    
    priorities = deque(priorities)
        #큐에 우선순위가 더 높은게 있다는 걸 어떻게 알 수 있을까?
        #큐에서 하나 꺼낼때마다 순회하면서 봐야하나? -> O(N^2) 프로세스 개수가 100이하니까 가능
    turn = 0
    while priorities:
        priority, idx = priorities.popleft()
        for p, i in priorities:
            if priority < p:
                priorities.append((priority, idx))
                #다시 큐에 넣고, 다시 pop()
                break
        else: #꺼낸 프로세스가 큐에 다시 들어가지 않았을 경우
            turn += 1
            if idx == location:
                return turn
    