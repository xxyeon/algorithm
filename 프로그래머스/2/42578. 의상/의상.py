from collections import Counter
def solution(clothes):
    answer = 1
    dict = Counter(cloth for _, cloth in clothes)
    for cnt in dict.values():
        answer *= cnt+1
    answer -= 1
    return answer