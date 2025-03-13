def solution(word):
    answer = 0
    alpha = ['A', 'E', 'I', 'O', 'U']
    weights = [781, 156, 31, 6, 1]
    idx = 0
    for i, a in enumerate(word):
        answer += alpha.index(a) * weights[i] + 1
    return answer