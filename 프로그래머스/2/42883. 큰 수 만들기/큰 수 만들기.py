def solution(number, k):
    answer = ''
    stack = []
    for n in number:
        while k != 0 and stack and n > stack[-1]:
            k -= 1
            stack.pop()
        stack.append(n)
    if k != 0: #number가 내림차순으로 정렬된 경우
        stack = stack[:-k]
    return "".join(stack)