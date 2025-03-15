from itertools import combinations
def solution(clothes):
    answer = 1
    dict = {}
    for name, kind in clothes:
        if kind not in dict:
            dict[kind] = 1
        else:
            dict[kind] += 1
    print(dict)
    for key in dict.keys():
        answer *= dict[key] + 1
    answer -= 1
    return answer