from itertools import permutations
import math
def solution(numbers):
    answer = 0
    num_lst = []
    for i in range(1, len(numbers)+1):
        p = permutations(numbers, i)
        p = list(p)
        for idx in range(len(p)): #동일한게 나올 수 있음
            num_lst.append("".join(list(p[idx])))
    num_lst = list(map(int, num_lst))
    num_lst = list(set(num_lst))

    for num in num_lst:
        isPrime = True
        if num == 2:
            answer += 1
            continue
        if num == 1 or num == 0:
            isPrime = False
            continue
        for k in range(2, int(math.sqrt(num))+1):
            if num % k == 0:
                isPrime = False
                break
        if isPrime:
            answer += 1

    return answer