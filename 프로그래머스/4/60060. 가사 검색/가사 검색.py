from bisect import bisect_left, bisect_right


def count_by_range(a, left_value, right_value):
    right_idx = bisect_right(a, right_value)
    left_idx = bisect_left(a, left_value)
    return right_idx - left_idx
#최대 단어길이 10000
array = [[] for _ in range(10001)]  #단어 길이대로 저장할 리스트
reverse = [[] for _ in range(10001)]
def solution(words, queries):
    answer = []
    #단어 길이대로 저장하기
    for word in words:
        array[len(word)].append(word)
        reverse[len(word)].append(word[::-1])
        
    #각 배열에 담긴 가사 정렬
    for i in range(10001):
        array[i].sort()
        reverse[i].sort()
        
    #가사 검색 시작
    for i in queries:
        #i가 포함된 가사 수가 words에 총 몇개있는지 ...
        if i[0] != "?": #와일드카드가 접두사이면
            cnt = count_by_range(array[len(i)], i.replace("?", "a"), i.replace("?", "z"))
        else:
            cnt = count_by_range(reverse[len(i)], i[::-1].replace("?", "a"), i[::-1].replace("?", "z"))
        answer.append(cnt)
                
    return answer