def binary_search(start, end, target, words):
    while start < end:
        mid = (start + end) // 2
        if words[mid] < target:
            start = mid + 1
        else:
            end = mid
    return start

def solution(words, queries):
    answer = []
    words.sort()
    
    # 원래 단어와 뒤집힌 단어를 길이에 따라 분류
    words_by_length = [[] for _ in range(10001)]
    reversed_words_by_length = [[] for _ in range(10001)]
    
    for word in words:
        words_by_length[len(word)].append(word)
        reversed_words_by_length[len(word)].append(word[::-1])
    
    # 각 길이별 단어 목록을 정렬
    for i in range(10001):
        words_by_length[i].sort()
        reversed_words_by_length[i].sort()

    for query in queries:
        if query[0] == '?':  # 접미사일 경우
            left_query = query.replace('?', 'a')[::-1]
            right_query = query.replace('?', 'z')[::-1]
            words_to_search = reversed_words_by_length[len(query)]
        else:  # 접두사일 경우
            left_query = query.replace('?', 'a')
            right_query = query.replace('?', 'z')
            words_to_search = words_by_length[len(query)]
        
        # 이진 탐색으로 범위 찾기
        left_idx = binary_search(0, len(words_to_search), left_query, words_to_search)
        right_idx = binary_search(0, len(words_to_search), right_query, words_to_search)

        answer.append(right_idx - left_idx)

    return answer

# 예제 실행
print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))
