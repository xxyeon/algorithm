from collections import deque
def solution(people, limit):
    if len(people) == 1:
        return 1
    answer = 0
    people.sort()
    people = deque(people)
    boat = []
    rest = []
    while people:
        if len(boat) == 0:
            boat.append(people.popleft())
        if people:
            if boat[0] + people[-1] <= limit:
                boat.append(people.pop())
            else:
                rest.append(people.pop())
        if len(boat) == 2:
            answer += 1
            boat = []
            
    return answer + len(boat) + len(rest)