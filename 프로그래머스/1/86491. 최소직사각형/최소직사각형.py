#작은 크기의 지갑에 모든 명함이 들어가야함
#모든 명함 최대 만개, 가로로 눕힌거 만개
#각 명함을 하나씩 가로로 눕힌거랑 안눕힌거랑 비교
# 각 명함의 긴 길이찾기, 긴 길이 중에서 가장 긴 길이 찾기 + 각 명함의 짧은 길이찾기, 짧은것 중에서 긴 길이 찾기
def solution(sizes):
    answer = 0
    max_x = 1001
    max_y = 1001
    long_lst = []
    short_lst = []
    for x, y in sizes:
        if x > y:
            long_lst.append(x)
            short_lst.append(y)
        else:
            long_lst.append(y)
            short_lst.append(x)
    answer = max(long_lst) * max(short_lst)
    return answer