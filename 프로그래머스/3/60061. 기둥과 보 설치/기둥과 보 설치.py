def is_possible(answer): #a조건에 모두 만족하는지 확인 (하나씩 설치해보기)
    for x, y ,a in answer:
        if a == 1: #보인경우
            if (x+1, y, 1) in answer and (x-1, y, 1) in answer:
                continue
            elif (x, y-1, 0) in answer or (x+1, y-1, 0) in answer:
                continue
            else:
                return False
        elif a == 0: #기둥인 경우
            if y == 0:#바닥에 설치되는 경우
                continue
            elif (x-1, y, 1) in answer or (x, y, 1) in answer or (x,y-1,0) in answer:
                continue
            else:
                return False
        
    return True
    

def solution(n, build_frame):
    #x, y, a, b frame[x][y]
    #보가 설치된 교차점 [x][y-1]~[x][y]
    #기둥이 설치된 교차점 [x][y] [x-1][y]
    #build_frame 완전탐색 가능 (1000*4)
    #일단 구조물을 설치해보고 완전탐색으로 살펴보고 조건에 안맞으면 제거
    #is_possible을 x, y, a, answer를 넘겨서 a가 x,y좌표에 설치 삭제되나 검사하려고함 -> 고려해야할 조건이 너무 많음
    # 일단 삭제한 후의 answer를 is_possible에서 하나씩 꺼내서 설치해보기
    answer = []
    for x, y, a, b in build_frame:
        if b == 0:#삭제인 경우
            answer.remove((x, y, a))
            if is_possible(answer) == False:
                answer.append((x,y,a))
        elif b == 1: #추가인 경우
            answer.append((x, y, a))
            if is_possible(answer) == False:
                answer.remove((x,y,a))
                

    
    #x좌표 기준으로 오름차순 -> y
    answer.sort()
    return answer