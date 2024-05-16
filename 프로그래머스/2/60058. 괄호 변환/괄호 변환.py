# from collections import deque
def process(v):
    if v == "":
        return v
    else:
        idx = split_string(v)
        u = v[:idx]
        v = v[idx:]
        if check_string(u):
            return u + process(v)
            
        else: #4번째 과정 진행
            new = ""
            new += '('
            new  += process(v)
            
            new += ')'
        
            u = u[1:len(u)-1]
            for i in u:
                if i == '(':
                    new += ')'
                else:
                    new += '('
        return new
        
def split_string(v):
    #균현잡힌 괄호문자열로 나누기 u
    # '(', ')' 의 개수가 동일해야함.
    lst_l = [] #왼쪽 괄호
    lst_r = [] #오른쪽 괄호
    for i in v:
        if i == '(':
            lst_l.append(i)
        else:
            lst_r.append(i)
        if len(lst_l) == len(lst_r):
            break
    return len(lst_l) + len(lst_r)
        
def check_string(p):
    result = True
    s = []
    for i in p:
        if i == '(':
            s.append(i)
        else:
            if len(s) == 0: #균현잡힌 문자열이라면 False 반환
                result = False
                break
            else:
                s.pop()
    return result

def solution(p):
    answer = ''
    s = []
    
    if check_string(p): #입력이 올바른 괄호일 경우
        answer = p
    else:
        answer = process(p)
            
            
    
    #p는 항상 균형잡힌 괄호이므로 올바른 괄호인지 검사
    
    return answer