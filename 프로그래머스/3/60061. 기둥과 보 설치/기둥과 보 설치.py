def possible(answer):
    result = True
    for x, y, a in answer:
        
        #기둥 일때
        if a == 0:
            #바닥에 설치할 경우
            if y == 0:
                continue

            #보 위에 설치할 경우
            elif [x, y, 1] in answer or [x-1, y, 1] in answer:
                continue
            elif [x, y-1, 0] in answer: #기둥 위에 설치할 경우
                continue
            else:
                return False
        #보일때
        elif a == 1:
            #기둥위에 설치할 경우
            if [x+1, y-1, 0] in answer or [x, y-1, 0] in answer:
                continue
            #보와 보 사이에 설치할 경우
            elif [x-1, y, 1] in answer and [x+1, y, 1] in answer:
                continue
            else:
                return False
    return True

def solution(n, build_frame):
    answer = []
    for x, y, a, b in build_frame:
        #설치할때
        if b == 1:
            answer.append([x,y,a])
            
            if possible(answer):
                continue
            else:
                answer.pop()
        #삭제할때
        if b == 0:
            answer.remove([x,y,a])
            if possible(answer):
                continue
            else:
                answer.append([x,y,a])

    answer = sorted(answer, key=lambda x : (x[0],x[1],x[2]))
    return answer