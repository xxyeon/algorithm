def solution(numbers):
    answer = ''
    numbers = sorted(map(str, numbers), key = lambda x:x*3, reverse=True)
    
    #모든 요소가 0인 경우를 생각해야함
    if numbers[0] == '0':
        answer = '0'
    else:
        answer = ''.join(numbers)
    return answer