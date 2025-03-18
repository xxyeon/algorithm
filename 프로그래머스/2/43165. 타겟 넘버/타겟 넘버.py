from itertools import product
def solution(numbers, target):
    answer = 0
    #순서를 바꾸지않고 타겟넘버 만들기, 방법수 return

    pd = product("+-", repeat=len(numbers))
    for operations in pd:
        result = 0
        for number, op in zip(numbers, operations):
            if op == "+":
                result += number
            else:
                result -= number
        if target == result:
            answer += 1
            
    return answer