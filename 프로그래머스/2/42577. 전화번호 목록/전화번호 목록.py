def solution(phone_book):
    phone_book.sort()  # 전화번호 정렬 (O(N log N))

    for i in range(len(phone_book) - 1):  # O(N)
        if phone_book[i+1].startswith(phone_book[i]):  # 인접한 번호 비교
            return False
    return True