def solution(phone_book):
    answer = True
    dict = {}
    for number in phone_book:
        dict[number] = 0 #같은 전화번호가 중복하지 않음
    length = set(map(len, phone_book))
    for l in length:
        for number in phone_book:
            if len(number) > l and number[:l] in dict:
                return False
        
            
    return answer