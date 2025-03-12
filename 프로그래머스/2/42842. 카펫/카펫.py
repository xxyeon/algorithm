def solution(brown, yellow):
    answer = []
    volumn = brown + yellow
    half_length = brown//2 + 2
    
    h = half_length // 2 #세로의 최대 길이
    w = half_length - h
    while 0 < h and h <= w:
        mid = h // 2
        w = half_length - h
        if volumn == w * h:
            answer = [w, h]
            break
        elif volumn < w * h:
            h -= 1
        elif volumn > w * h:
            h += 1
    return answer