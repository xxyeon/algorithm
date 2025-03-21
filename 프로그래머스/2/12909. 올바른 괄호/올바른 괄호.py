def solution(s):
    answer = True
    
    stack = []
    for i in s:
        if i == '(':
            stack.append('(')
        elif stack and i == ')':
            stack.pop()
        elif not stack and i == ')':
            return False
    if stack:
        return False
    return True